package jpmc.hackathon.rpi1;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public enum SerialUtil {

    INSTANCE;

    private volatile String serial;

    private static final String DEFAULT_SERIAL = "00000";

    public String serial() {

        if (serial != null) {
            return serial;
        }

        synchronized (this) {
            if (serial != null) {
                return serial;
            }

            serial = retrieveSerial();

            System.out.println(">>> " + serial);

            return serial;
        }
    }

    private String retrieveSerial() {
        BufferedReader in = null;
        String lineWithSerial = "";
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("cat", "/proc/cpuinfo");
            Process process = processBuilder.start();

            in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                if (line.contains("Serial")) {
                    lineWithSerial = line;
                }
            }
            process.waitFor();
            in.close();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(in);
        }

        return extractSerial(lineWithSerial);
    }

    private String extractSerial(String line) {
        if (StringUtils.isEmpty(line)) {
            System.out.println("Line with serial is empty. Going to use default serial: " + DEFAULT_SERIAL);
            return DEFAULT_SERIAL;
        }
        return line
                .replace("Serial", "")
                .replace("\t", "")
                .replace(":", "")
                .replace(" ", "");
    }
}

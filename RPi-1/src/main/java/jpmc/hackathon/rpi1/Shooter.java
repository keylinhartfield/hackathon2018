package jpmc.hackathon.rpi1;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class Shooter {

    private final static Logger logger = LoggerFactory.getLogger(Shooter.class);


    private String receiverUrl;


    @Scheduled(fixedRate = 5000)
    public void process() {
        try {
            String filename = doShot();
              submitShotToReceiver(filename);
        } catch (Throwable e) {
            logger.error("Can't do shot", e);
        }
    }

    private void submitShotToReceiver(String filename) throws URISyntaxException, IOException {
        try {

            File file = new File(filename);

            logger.debug("File size: " + file.length());

            InputStream stream = new FileInputStream(file);

            byte[] buffer = new byte[stream.available()];
            stream.read(buffer);

            HttpEntity entity = MultipartEntityBuilder.create()
                    .addBinaryBody("file", file)
                    .build();

            int statusCode = Request.Post(new URIBuilder(receiverUrl)
                    .addParameter("serial", SerialUtil.INSTANCE.serial()).build())
                    .body(entity)
                    .execute().returnResponse().getStatusLine().getStatusCode();

            IOUtils.closeQuietly(stream);

            logger.debug("Sending complete: " + statusCode);
        } finally {
            File file = new File(filename);
            if (!file.delete()) {
                logger.error("Can't delete file: " + file.toPath().toString());
            }
        }
    }

    protected String doShot() throws InterruptedException, IOException {
        String filename = "/home/pi/hackathon2018/photo/" + Math.abs(new Random().nextInt()) + ".jpg";

        try {


            logger.debug("Filename: " + filename);

            List<String> params = new ArrayList<>();
            params.add("raspistill");
            params.add("--nopreview");
            params.add("-w");
            params.add("800");
            params.add("-h");
            params.add("600");
            //   params.addAll(config.getParams());
            params.add("-o");
            params.add(filename);

            logger.debug("Params: " + params);

            Process process = new ProcessBuilder(params)
                    .start();
            process.waitFor();

            logger.debug("Snapshot is ready");

        }catch(Exception e){
            e.printStackTrace();

        }

        return filename;
    }
}
package hackathon.rpi2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {
        GsonAutoConfiguration.class
})
@EnableScheduling
public class Runner {

    public static void main(String[] args) {
        SpringApplication.run(Runner.class);
    }
}

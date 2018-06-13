package jpmc.hackathon.rpi1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*


sudo mkdir /ram
sudo mount -osize=100m tmpfs /ram -t tmpfs

 */

@SpringBootApplication
public class Runner {

    public static void main(String[] args) {
        SpringApplication.run(Runner.class);
    }
}

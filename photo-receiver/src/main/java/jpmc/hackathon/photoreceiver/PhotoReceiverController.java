package jpmc.hackathon.photoreceiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PhotoReceiverController {


    private final static Logger logger = LoggerFactory.getLogger(PhotoReceiverController.class);

    @RequestMapping(value = "/imagereceiver", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity receiveImage(@RequestPart("file") MultipartFile file, String serial) {

        try {

            logger.debug("file received from " + serial);


            // save to s3
            // send message to the queue



        } catch (Exception e) {
            logger.error("Error with receiving image", e);
        }

        return ResponseEntity.ok().build();
    }

}

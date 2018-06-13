package jpmc.hackathon.photoreceiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
public class PhotoReceiverController {


    private final static Logger logger = LoggerFactory.getLogger(PhotoReceiverController.class);

    @Autowired
    private S3 s3;

    @Autowired
    private SQS sqs;

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = "multipart/form-data")
    @ResponseBody
    public ResponseEntity receiveImage(@RequestPart("file") MultipartFile file, String serial) {

        try {



            String uuid = UUID.randomUUID().toString();
            logger.debug(uuid);

            s3.save(file.getInputStream(), uuid);

            sqs.sendMessage(uuid);


            // save to s3
            // send message to the queue



        } catch (Exception e) {
            logger.error("Error with receiving image", e);
        }

        return ResponseEntity.ok().build();
    }

}

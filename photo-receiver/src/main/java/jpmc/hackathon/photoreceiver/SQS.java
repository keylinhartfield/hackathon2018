package jpmc.hackathon.photoreceiver;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.stereotype.Component;

@Component
public class SQS {

    public void sendMessage(String filename) {

        // hackathon-2018-photo-received



        AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();


        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl("https://sqs.us-east-1.amazonaws.com/658319906931/hackathon-2018-photo-received")
                .withMessageBody(filename);
        sqs.sendMessage(send_msg_request);

    }

}

package jpmc.hackathon.photoreceiver;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import org.springframework.stereotype.Component;

@Component
public class SQS {

    public void sendMessage(String filename) {

        AmazonSQS sqs = AmazonSQSClientBuilder.defaultClient();

        String queueUrl = "https://sqs.us-east-2.amazonaws.com/076189656150/photo-received";

        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody(filename);
        sqs.sendMessage(send_msg_request);

    }

}

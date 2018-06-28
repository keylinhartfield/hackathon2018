package hackathon.rpi2;

import com.amazon.sqs.javamessaging.AmazonSQSExtendedClient;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClientBuilder;
import com.amazonaws.services.sqs.model.DeleteMessageRequest;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SQS {

@Autowired
    private LedControl ledControl;

    @Scheduled(fixedRate = 100)
    public void listen() {

        String queueUrl = "https://sqs.us-east-2.amazonaws.com/076189656150/photo-received";


        final AmazonSQS sqsExtended =
                new AmazonSQSExtendedClient(AmazonSQSClientBuilder.defaultClient());


        final ReceiveMessageRequest receiveMessageRequest =
                new ReceiveMessageRequest(queueUrl);

        List<Message> messages = sqsExtended
                .receiveMessage(receiveMessageRequest).getMessages();

        // Print information about the message.
        for (Message message : messages) {
            System.out.println("\nMessage received.");
            System.out.println("  ID: " + message.getMessageId());
            System.out.println("  Receipt handle: " + message.getReceiptHandle());
            System.out.println("  Message body: " + message.getBody());


            AccessControl accessControl = new Gson().fromJson(message.getBody(), AccessControl.class);

            if (accessControl.getStatus()) {
                ledControl.green();
            } else {
                ledControl.red();
            }


            final String messageReceiptHandle = messages.get(0).getReceiptHandle();
            sqsExtended.deleteMessage(new DeleteMessageRequest(queueUrl,
                    messageReceiptHandle));
            System.out.println("Deleted the message.");
        }
    }

}

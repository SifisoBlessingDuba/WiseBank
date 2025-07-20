package za.ac.cput.wisebank.factory;

import org.springframework.stereotype.Component;
import za.ac.cput.wisebank.domain.Message;

import java.time.LocalDateTime;

@Component
public class MessageFactory {
 public static Message createMessage(Integer messageId, int senderUserId, int receiverUserId, String content, LocalDateTime timestamp, String status){
     return new Message.Builder()
             .setMessageId(messageId)
             .setSenderUserId(senderUserId)
             .setReceiverUserId(receiverUserId)
             .setContent(content)
             .setTimestamp(timestamp)
             .setStatus(status)
             .build();
 }
}



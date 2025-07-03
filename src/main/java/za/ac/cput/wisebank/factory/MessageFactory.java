package za.ac.cput.wisebank.factory;

import org.springframework.stereotype.Component;
import za.ac.cput.wisebank.domain.Message;

import java.time.LocalDateTime;

@Component
public class MessageFactory {
    public Message createMessage(int messageId, int senderUserId, int receiverUserId, String content, String status) {
        return new Message(messageId, senderUserId, receiverUserId, content, LocalDateTime.now(), status);
    }
}



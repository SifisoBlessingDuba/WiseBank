package za.ac.cput.wisebank.factory;

import org.springframework.stereotype.Component;
import za.ac.cput.wisebank.domain.Message;
import za.ac.cput.wisebank.domain.User;

import java.time.LocalDateTime;

@Component
public class MessageFactory {

    public static Message createMessage(
            Integer messageId,
            User sender,
            User receiver,
            String content,
            LocalDateTime timestamp,
            String status) {

        return new Message.Builder()
                .setMessageId(messageId)
                .setUser(sender)
                .setContent(content)
                .setTimestamp(timestamp)
                .setStatus(status)
                .build();
    }
}

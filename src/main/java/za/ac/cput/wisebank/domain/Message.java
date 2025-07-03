package za.ac.cput.wisebank.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    private int messageId;

    private int senderUserId;
    private int receiverUserId;
    private String content;
    private LocalDateTime timestamp;
    private String status;

    protected Message() {} // required by JPA

    public Message(int messageId, int senderUserId, int receiverUserId, String content, LocalDateTime timestamp, String status) {
        this.messageId = messageId;
        this.senderUserId = senderUserId;
        this.receiverUserId = receiverUserId;
        this.content = content;
        this.timestamp = timestamp;
        this.status = status;
    }

    // Getters
    public int getMessageId() { return messageId; }
    public int getSenderUserId() { return senderUserId; }
    public int getReceiverUserId() { return receiverUserId; }
    public String getContent() { return content; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public String getStatus() { return status; }
}

package za.ac.cput.wisebank.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;

    private int senderUserId;
    private int receiverUserId;
    private String content;
    private LocalDateTime timestamp;
    private String status;

    protected Message() {} // required by JPA

    public Message(Builder builder) {
        this.messageId = builder.messageId;
        this.senderUserId = builder.senderUserId;
        this.receiverUserId = builder.receiverUserId;
        this.content = builder.content;
        this.timestamp = builder.timestamp;
        this.status = builder.status;
    }

    // Getters
    public Integer getMessageId() {
        return messageId;
    }
    public int getSenderUserId() {
        return senderUserId;
    }
    public int getReceiverUserId() {
        return receiverUserId;
    }
    public String getContent() {
        return content;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", senderUserId=" + senderUserId +
                ", receiverUserId=" + receiverUserId +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                ", status='" + status + '\'' +
                '}';
    }
    public static class Builder{
        private Integer messageId;
        private int senderUserId;
        private int receiverUserId;
        private String content;
        private LocalDateTime timestamp;
        private String status;

        public Builder setMessageId(Integer messageId) {
            this.messageId = messageId;
            return this;
        }
        public Builder setSenderUserId(int senderUserId) {
            this.senderUserId = senderUserId;
            return this;
        }
        public Builder setReceiverUserId(int receiverUserId) {
            this.receiverUserId = receiverUserId;
            return this;
        }
        public Builder setContent(String content) {
            this.content = content;
            return this;
        }
        public Builder setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            return this;
        }
        public Builder setStatus(String status) {
            this.status = status;
            return this;
        }
        public Message build() {
            return new Message(this);
        }
    }


}

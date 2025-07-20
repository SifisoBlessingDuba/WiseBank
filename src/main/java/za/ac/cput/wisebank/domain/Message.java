package za.ac.cput.wisebank.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer messageId;

    private String content;
    private LocalDateTime timestamp;
    private String status;

    // Relationship: Many Messages → One User
    @ManyToOne(optional = false)
    @JoinColumn(name = "sender_user_id", referencedColumnName = "id")
    private User sender;

    // Relationship: Many Messages → One User
    @ManyToOne(optional = false)
    @JoinColumn(name = "receiver_user_id", referencedColumnName = "id")
    private User receiver;

    protected Message() {}

    public Message(Builder builder) {
        this.messageId = builder.messageId;
        this.sender = builder.sender;
        this.receiver = builder.receiver;
        this.content = builder.content;
        this.timestamp = builder.timestamp;
        this.status = builder.status;
    }

    public Integer getMessageId() {
        return messageId;
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
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
                ", sender=" + (sender != null ? sender.getId() : null) +
                ", receiver=" + (receiver != null ? receiver.getId() : null) +
                ", senderUserId=" + senderUserId +
                ", receiverUserId=" + receiverUserId +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                ", status='" + status + '\'' +
                '}';
    }

    public static class Builder {
        private Integer messageId;
        private User sender;
        private User receiver;
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

        public Builder setSender(User sender) {
            this.sender = sender;
            return this;
        }

        public Builder setReceiver(User receiver) {
            this.receiver = receiver;
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

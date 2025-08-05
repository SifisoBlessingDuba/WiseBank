package za.ac.cput.wisebank.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Integer messageId;
    private String content;
    private LocalDateTime timestamp;
    private String status;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    protected Message() {}

    public Message(Builder builder) {
        this.messageId = builder.messageId;
        this.user = builder.user;
        this.content = builder.content;
        this.timestamp = builder.timestamp;
        this.status = builder.status;
    }

    public Integer getMessageId() {
        return messageId;
    }



    public User getUser() {
        return user;
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
                ", sender=" + (user != null ? user.getUserid() : null) +
                ", content='" + content + '\'' +
                ", timestamp=" + timestamp +
                ", status='" + status + '\'' +
                '}';
    }

    public static class Builder {
        private Integer messageId;
        private User user;
        private String content;
        private LocalDateTime timestamp;
        private String status;

        public Builder setMessageId(Integer messageId) {
            this.messageId = messageId;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
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

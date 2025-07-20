package za.ac.cput.wisebank.domain;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer notificationId;
    private Integer userId;
    private String title;
    private String message;
    private String notificationType;
    private String isRead;
    private LocalDateTime timeStamp;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    protected Notification() {

    }

    public void setUser(User user){
        this.user = user;
    }

    public Notification(Builder builder) {
        this.notificationId = builder.notificationId;
        this.userId = builder.userId;
        this.title = builder.title;
        this.message = builder.message;
        this.notificationType = builder.notificationType;
        this.isRead = builder.isRead;
        this.timeStamp = builder.timeStamp;

    }

    public Integer getNotificationId() {
        return notificationId;
    }


    public Integer getUserId() {
        return userId;
    }


    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public String getNotificationType() {
        return notificationType;
    }

    public String getIsRead() {
        return isRead;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "notificationId=" + notificationId
                + ", userId=" + userId +'\''
                + ", title='" + title + '\''
                + ", message='" + message + '\''
                + ", notificationType='" + notificationType + '\''
                + ", isRead='" + isRead + '\''
                + ", timeStamp=" + timeStamp +
                '}';
    }

    public static class Builder {
        private Integer notificationId;
        private Integer userId;
        private String title;
        private String message;
        private String notificationType;
        private String isRead;
        private LocalDateTime timeStamp;
        private User user;

        public Builder setNotificationId(Integer notificationId) {
            this.notificationId = notificationId;
            return this;
        }

        public Builder setUserId(Integer userId) {
            this.userId = userId;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setNotificationType(String notificationType) {
            this.notificationType = notificationType;
            return this;
        }

        public Builder setIsRead(String isRead) {
            this.isRead = isRead;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setTimeStamp(LocalDateTime timeStamp) {
            this.timeStamp = timeStamp;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }
    }
}

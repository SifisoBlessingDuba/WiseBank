package za.ac.cput.wisebank.domain;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "notification_id")
    private Integer notificationId;
    private String title;
    private String message;
    private String notificationType;
    private String isRead;
    private LocalDateTime timeStamp;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;


    protected Notification() {

    }

    public Notification(Builder builder) {
        this.notificationId = builder.notificationId;
        this.title = builder.title;
        this.message = builder.message;
        this.notificationType = builder.notificationType;
        this.isRead = builder.isRead;
        this.timeStamp = builder.timeStamp;
        this.user = builder.user;

    }

    public Integer getNotificationId() {
        return notificationId;
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
                "notificationId=" + notificationId +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", notificationType='" + notificationType + '\'' +
                ", isRead='" + isRead + '\'' +
                ", timeStamp=" + timeStamp +
                ", user=" + user+
                '}';
    }

    public static class Builder {
        private Integer notificationId;
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

        public Builder copy(Notification notification) {
            this.notificationId = notification.notificationId;
            this.title = notification.title;
            this.message = notification.message;
            this.notificationType = notification.notificationType;
            this.isRead = notification.isRead;
            this.timeStamp = notification.timeStamp;
            this.user = notification.user;
            return this;
        }

        public Notification build() {
            return new Notification(this);
        }
    }
}
//guys check if this page will show up in the final project
//23
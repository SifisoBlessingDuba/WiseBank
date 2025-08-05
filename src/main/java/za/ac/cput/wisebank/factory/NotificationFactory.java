package za.ac.cput.wisebank.factory;

import za.ac.cput.wisebank.domain.Notification;
import za.ac.cput.wisebank.domain.User;

import java.time.LocalDateTime;

public class NotificationFactory {

    public static Notification createNotification(Integer notificationId, String title, String message, String notificationType, String isRead, LocalDateTime timeStamp, User user) {

        return new Notification.Builder()
                .setNotificationId(notificationId)
                .setTitle(title)
                .setMessage(message)
                .setNotificationType(notificationType)
                .setIsRead(isRead)
                .setTimeStamp(timeStamp)
                .setUser(user)
                .build();
    }
}

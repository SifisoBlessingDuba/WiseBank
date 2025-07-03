package za.ac.cput.wisebank.Factory;

import za.ac.cput.wisebank.domain.Notification;

import java.time.LocalDateTime;

public class NotificationFactory {

    public static Notification createNotification(Integer notificationId, Integer userId, String title, String message, String notificationType, String isRead, LocalDateTime timeStamp) {

        return new Notification.Builder()
                .setNotificationId(notificationId)
                .setUserId(userId)
                .setTitle(title)
                .setMessage(message)
                .setNotificationType(notificationType)
                .setIsRead(isRead)
                .setTimeStamp(timeStamp)
                .build();
    }
}

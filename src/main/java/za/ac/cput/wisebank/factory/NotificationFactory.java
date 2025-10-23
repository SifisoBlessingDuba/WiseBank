package za.ac.cput.wisebank.factory;

import za.ac.cput.wisebank.domain.Notification;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.util.Helper;

import java.time.LocalDateTime;

public class NotificationFactory {

    public static Notification createNotification(Integer notificationId, String title, String message, String notificationType, String isRead, LocalDateTime timeStamp, User user) {
        if(Helper.isValidInteger(notificationId) ||
        Helper.isNullOrEmpty(title) ||
        Helper.isNullOrEmpty(message) ||
        Helper.isNullOrEmpty(notificationType) ||
        Helper.isNullOrEmpty(isRead)) {
            return null;
        }
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
//guys check if this page will show up in the final project
//37
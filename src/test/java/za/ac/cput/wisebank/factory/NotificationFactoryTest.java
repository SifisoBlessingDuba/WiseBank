package za.ac.cput.wisebank.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.wisebank.domain.Notification;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class NotificationFactoryTest {

    @Test
    void createNotification() {

        Notification notification = NotificationFactory.createNotification(123456,  "Loan", "Loan payment in process", "Message/Income", "True", LocalDateTime.now(), null );
        assertNotNull(notification);
    }
}
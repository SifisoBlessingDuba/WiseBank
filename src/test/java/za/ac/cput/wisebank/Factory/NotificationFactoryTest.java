package za.ac.cput.wisebank.Factory;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.wisebank.domain.Notification;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class NotificationFactoryTest {

    @Test
    void createNotification() {

        Notification notification = NotificationFactory.createNotification(123456, 7891011, "Loan", "Loan payment in process", "Message/Income", "True", LocalDateTime.now() );
        assertNotNull(notification);
    }
}
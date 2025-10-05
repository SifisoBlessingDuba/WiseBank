package za.ac.cput.wisebank.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.cglib.core.Local;
import za.ac.cput.wisebank.domain.Notification;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.repository.NotificationRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest
class NotificationServiceTest {

@Autowired
private NotificationService notificationService;

private Notification testNotification;

    private Notification testNotification2;
    private Notification testNotification3;
    private Notification testNotification4;
    private Notification testNotification5;

@BeforeEach
void setUp() {

    User user = new User.Builder()
            .setFirstName("John")
            .setLastName("Doe")
            .setEmail("john.doe@example.com")
            .setPassword("securePass123")
            .setIdNumber("123456789")
            .setPhoneNumber("12345678905")
            .setAddress("123 Main St")
            .setDateOfBirth(LocalDate.now())
            .setCreatedAt(LocalDate.now())
            .setLastLogin(LocalDate.now())
            .build();

    User user2 = new User.Builder()
            .setFirstName("Johnny")
            .setLastName("Doe")
            .setEmail("johnny.doe@example.com")
            .setPassword("securePass456")
            .setIdNumber("1234569")
            .setPhoneNumber("1234590")
            .setAddress("123 Main St")
            .setDateOfBirth(LocalDate.now())
            .setCreatedAt(LocalDate.now())
            .setLastLogin(LocalDate.now())
            .build();

    testNotification = new Notification.Builder()
            .setTitle("New Transaction")
            .setMessage("R10000 has been deposited into your account")
            .setIsRead("Read")
            .setTimeStamp(LocalDateTime.now())
            .setUser(user)
            .build();

    testNotification2 = new Notification.Builder()
            .setTitle("New Transaction 2")
            .setMessage("R2000 has been deposited into your account")
            .setIsRead("Unread")
            .setTimeStamp(LocalDateTime.now())
            .setUser(user2)
            .build();

    User user3 = new User.Builder()
            .setFirstName("Alice")
            .setLastName("Smith")
            .setEmail("alice.smith@example.com")
            .setPassword("passwordAlice789")
            .setIdNumber("987654321")
            .setPhoneNumber("9876543210")
            .setAddress("45 Oak Street")
            .setDateOfBirth(LocalDate.now())
            .setCreatedAt(LocalDate.now())
            .setLastLogin(LocalDate.now())
            .build();

    User user4 = new User.Builder()
            .setFirstName("Bob")
            .setLastName("Williams")
            .setEmail("bob.williams@example.com")
            .setPassword("passwordBob123")
            .setIdNumber("192837465")
            .setPhoneNumber("8765432109")
            .setAddress("67 Pine Avenue")
            .setDateOfBirth(LocalDate.now())
            .setCreatedAt(LocalDate.now())
            .setLastLogin(LocalDate.now())
            .build();

    User user5 = new User.Builder()
            .setFirstName("Sarah")
            .setLastName("Johnson")
            .setEmail("sarah.johnson@example.com")
            .setPassword("passwordSarah321")
            .setIdNumber("564738291")
            .setPhoneNumber("7654321098")
            .setAddress("89 Maple Drive")
            .setDateOfBirth(LocalDate.now())
            .setCreatedAt(LocalDate.now())
            .setLastLogin(LocalDate.now())
            .build();

     testNotification3 = new Notification.Builder()
            .setTitle("New Transaction 3")
            .setMessage("R500 has been withdrawn from your account")
            .setIsRead("Unread")
            .setTimeStamp(LocalDateTime.now())
            .setUser(user3)
            .build();

     testNotification4 = new Notification.Builder()
            .setTitle("Security Alert")
            .setMessage("Login attempt from new device")
            .setIsRead("Read")
            .setTimeStamp(LocalDateTime.now())
            .setUser(user4)
            .build();

     testNotification5 = new Notification.Builder()
            .setTitle("Payment Received")
            .setMessage("R7500 has been received from Jane Doe")
            .setIsRead("Unread")
            .setTimeStamp(LocalDateTime.now())
            .setUser(user5)
            .build();

}

    @Test
    void testSaveNotification() {
    Notification saved = notificationService.save(testNotification);

    assertNotNull(saved);
    assertEquals(testNotification.getNotificationId(), saved.getNotificationId());
        System.out.println(saved);

        Notification saved2 = notificationService.save(testNotification2);

        assertNotNull(saved2);
        assertEquals(testNotification2.getNotificationId(), saved2.getNotificationId());
        System.out.println(saved2);

        Notification saved3 = notificationService.save(testNotification3);

        assertNotNull(saved3);
        assertEquals(testNotification3.getNotificationId(), saved3.getNotificationId());
        System.out.println(saved3);

        Notification saved4 = notificationService.save(testNotification4);

        assertNotNull(saved4);
        assertEquals(testNotification4.getNotificationId(), saved4.getNotificationId());
        System.out.println(saved4);

        Notification saved5 = notificationService.save(testNotification5);

        assertNotNull(saved5);
        assertEquals(testNotification5.getNotificationId(), saved5.getNotificationId());
        System.out.println(saved5);
    }

    @Test
    @Transactional
    void testUpdate() {
    Notification notification1 = new Notification.Builder().copy(testNotification).setIsRead("Not Read").build();
    Notification updated = notificationService.update(notification1);

    assertNotNull(updated);
    System.out.println(updated);
    }
//
    @Test
    @Transactional
    void testFindByIdExists() {
    Notification found = notificationService.findById(1);

    assertNotNull(found);
    System.out.println(found);
    }

//    @Test
//    void testDeleteNotification() {
//
//    doNothing().when(notificationRepository).deleteById(1);
//
//    notificationService.deleteById(1);
//
//    verify(notificationRepository).deleteById(1);
//
//    }
//
    @Test
    @Transactional
    void testGetAll() {

    List<Notification> result = notificationService.getAll();
        System.out.println(result);
    }
}
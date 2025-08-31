package za.ac.cput.wisebank.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import za.ac.cput.wisebank.domain.Notification;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.repository.NotificationRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@SpringBootTest
class NotificationServiceTest {

@Mock
private NotificationRepository notificationRepository;

@Autowired
private NotificationService notificationService;

private Notification testNotification;



@BeforeEach
void setUp() {
    MockitoAnnotations.openMocks(this);

    User user = new User();

    testNotification = new Notification.Builder()

            .setTitle("New Transaction")
            .setMessage("R10000 has been deposited into your account")
            .setIsRead("Read")
            .setTimeStamp(LocalDateTime.now())
            .setUser(user)
            .build();
}

    @Test
    void testSaveNotification() {
    //when(notificationRepository.save(testNotification)).thenReturn(testNotification);

    Notification saved = notificationService.save(testNotification);

    assertNotNull(saved);
    assertEquals(testNotification.getNotificationId(), saved.getNotificationId());
    //verify(notificationRepository).save(testNotification);
        System.out.println(saved);
    }

    @Test
    void testUpdate() {
    when(notificationRepository.save(testNotification)).thenReturn(testNotification);

    Notification updated = notificationService.update(testNotification);

    assertEquals("New Transaction", updated.getTitle());
    assertEquals("R10000 has been deposited into your account", updated.getMessage());
    assertEquals("Read", updated.getIsRead());
    verify(notificationRepository).save(testNotification);
    }

    @Test
    void testFindByIdExists() {
    when(notificationRepository.findById(1)).thenReturn(Optional.of(testNotification));

    Notification found = notificationService.findById(1);

    assertNotNull(found);
    assertEquals("New Transaction", found.getTitle());
    assertEquals("Read", found.getIsRead());
    verify(notificationRepository).findById(1);

    }

    @Test
    void testFindByIdDoesNotExist() {
    when(notificationRepository.findById(2)).thenReturn(Optional.empty());

    Notification found = notificationService.findById(2);

    assertNull(found);
    verify(notificationRepository).findById(2);
    }

    @Test
    void testDeleteNotification() {

    doNothing().when(notificationRepository).deleteById(1);

    notificationService.deleteById(1);

    verify(notificationRepository).deleteById(1);

    }

    @Test
    void testGetAll() {

    List<Notification> notificationList = List.of(testNotification);
    when(notificationRepository.findAll()).thenReturn(notificationList);

    List<Notification> result = notificationService.getAll();

    assertEquals(1, result.size());
    assertEquals("New Transaction", result.get(0).getTitle());
    verify(notificationRepository).findAll();
    }
}
package za.ac.cput.wisebank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.ac.cput.wisebank.domain.Notification;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.service.NotificationService;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
//import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NotificationController.class)
public class NotificationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private NotificationService notificationService;

    private Notification testNotification;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        User testUser = new User.Builder()
                .setUserid("user456")
                .setFirstName("Fatso")
                .setLastName("Bojatseha")
                .setEmail("Bojabs@sample.com")
                .build();

       Notification testNotification = new Notification.Builder()
                .setNotificationId(1)
                .setTitle("Welcome")
                .setMessage("Your account has been created successfully.")
                .setNotificationType("INFO")
                .setIsRead("false")
                .setTimeStamp(LocalDateTime.now())
                .setUser(testUser)
                .build();
    }




    @Test
    void testSaveNotification() throws Exception {
    when(notificationService.save(any(Notification.class))).thenReturn(testNotification);

    mockMvc.perform(post("/Notification/save")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(testNotification)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.title").value("Welcome"))
            .andExpect(jsonPath("$.message").value("Your account has been created successfully."));
    }

    @Test
    void testUpdateNotification() throws Exception {
        when(notificationService.update(any(Notification.class))).thenReturn(testNotification);

        mockMvc.perform(put("/Notification/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testNotification)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.notificationId").value(1));

    }

    @Test
    void testFindNotificationById() throws Exception {
            when(notificationService.findById(1)).thenReturn(testNotification);

            mockMvc.perform(get("/Notification/find_notification"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.notificationId").value(1));
    }

    @Test
    void testDeleteNotification() throws Exception {
        doNothing().when(notificationService).deleteById(1);

        mockMvc.perform(delete("/Notification/delete/1"))
                .andExpect(status().isOk());

        verify(notificationService, times(1)).deleteById(1);
    }

    @Test
    void testFindAllNotifications() throws Exception {
        when(notificationService.getAll()).thenReturn(List.of(testNotification));

        mockMvc.perform(get("/Notification/all-notifications"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].notificationId").value(1))
                .andExpect(jsonPath("$[0].title").value("Welcome"))
                .andExpect(jsonPath("$[0].message").value("Your account has been created successfully."));
    }
}
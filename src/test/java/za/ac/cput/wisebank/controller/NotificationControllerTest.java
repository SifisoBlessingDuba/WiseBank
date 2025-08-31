package za.ac.cput.wisebank.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.web.servlet.MockMvc;
import za.ac.cput.wisebank.domain.Notification;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.service.NotificationService;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class NotificationControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    private Notification testNotification;

    private static final String BASE_URL = "http://localhost:8080/notification";
    @BeforeEach
    void setUp() {
        User testUser = new User.Builder()
                .setUserid("user456")
                .setFirstName("Fatso")
                .setLastName("Bojatseha")
                .setEmail("Bojabs@sample.com")
                .build();

        testNotification = new Notification.Builder()
                .setTitle("Welcome")
                .setMessage("Your account has been created successfully.")
                .setNotificationType("INFO")
                .setIsRead("false")
                .setTimeStamp(LocalDateTime.now())
                .setUser(testUser)
                .build();

    }




    @Test
    void testSaveNotification() {
        String url = BASE_URL + "/save";
        ResponseEntity<Notification> postResponse = restTemplate.postForEntity(url, testNotification,Notification.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println("Created: " + postResponse.getBody());
    }

//    @Test
//    void testUpdateNotification() throws Exception {
//        when(notificationService.update(any(Notification.class))).thenReturn(testNotification);
//
//        mockMvc.perform(put("/notification/update")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(objectMapper.writeValueAsString(testNotification)))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.notificationId").value(1));
//
//    }
//
//    @Test
//    void testFindNotificationById() throws Exception {
//            when(notificationService.findById(1)).thenReturn(testNotification);
//
//            mockMvc.perform(get("/notification/findById/17"))
//                    .andDo(print())
//                    .andExpect(status().isOk())
//                    .andExpect(jsonPath("$.notificationId").value(16));
//    }
//
//    @Test
//    void testDeleteNotification() throws Exception {
//        doNothing().when(notificationService).deleteById(1);
//
//        mockMvc.perform(delete("/notification/deleteById/1"))
//                .andDo(print())
//                .andExpect(status().isOk());
//
//        verify(notificationService).deleteById(1);
//    }
//
    @Test
    void testFindAllNotifications() {
        String url = BASE_URL + "/find-all";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println("All Notifications:");
        System.out.println(response.getBody());
    }
}
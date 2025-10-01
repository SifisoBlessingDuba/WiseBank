package za.ac.cput.wisebank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.service.UserService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class UserControllerTest {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private User testUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        testUser = new User.Builder()
                .setIdNumber("83749247")
                .setFirstName("Jane")
                .setLastName("Doe")
                .setEmail("jane.doe@example.com")
                .setPassword("password123")
                .setPhoneNumber("1234567890L")
                .setAddress("456 Another St")
                .setDateOfBirth(LocalDate.now())
                .setCreatedAt(LocalDate.now())
                .setLastLogin(LocalDate.now())
                .build();
    }

    @Test
    void testSaveUser() throws Exception {
        when(userService.save(any(User.class))).thenReturn(testUser);

        mockMvc.perform(post("/user/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testUser)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(1))
                .andExpect(jsonPath("$.firstName").value("Jane"));
    }

    @Test
    void testUpdateUser() throws Exception {
        when(userService.update(any(User.class))).thenReturn(testUser);

        mockMvc.perform(put("/user/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testUser)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("jane.doe@example.com"));
    }

    @Test
    void testDeleteUser() throws Exception {
        doNothing().when(userService).deleteById("1");

        mockMvc.perform(delete("/user/deleteUser/1"))
                .andExpect(status().isOk());

        verify(userService, times(1)).deleteById("1");
    }

    @Test
    void testFindUserById() throws Exception {
        when(userService.findById("1")).thenReturn(testUser);

        mockMvc.perform(get("/user/read_user/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userId").value(1));
    }

    @Test
    void testFindAllUsers() throws Exception {
        List<User> users = Arrays.asList(testUser);
        when(userService.findAll()).thenReturn(users);

        mockMvc.perform(get("/user/all_users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].userId").value(1));
    }
}

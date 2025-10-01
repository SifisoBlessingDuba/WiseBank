package za.ac.cput.wisebank.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.repository.UserRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        user = new User.Builder()
                .setIdNumber("2387234")
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("john.doe@example.com")
                .setPassword("securePass123")
                .setPhoneNumber("1234567890L")
                .setAddress("123 Main St")
                .setDateOfBirth(LocalDate.now())
                .setCreatedAt(LocalDate.now())
                .setLastLogin(LocalDate.now())
                .build();
    }

    @Test
    void testSave() {
        when(userRepository.save(user)).thenReturn(user);
        User saved = userService.save(user);
        assertNotNull(saved);
        assertEquals("U001", saved.getIdNumber());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testFindById() {
        when(userRepository.findById("1")).thenReturn(Optional.of(user));

        User found = userService.findById("1");

        assertNotNull(found);
        assertEquals("John", found.getFirstName());
        verify(userRepository, times(1)).findById("1");
    }

    @Test
    void testFindAll() {
        List<User> users = Arrays.asList(user);
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.findAll();

        assertEquals(1, result.size());
        assertEquals("U001", result.get(0).getIdNumber());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testUpdate() {
        when(userRepository.save(user)).thenReturn(user);

        User updated = userService.update(user);

        assertNotNull(updated);
        assertEquals("John", updated.getFirstName());
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testDeleteById() {
        doNothing().when(userRepository).deleteById("1");

        userService.deleteById("1");

        verify(userRepository, times(1)).deleteById("1");
    }
}



package za.ac.cput.wisebank.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.wisebank.domain.User;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void createUser() {
        User user = UserFactory.createUser("03120467373", "bedeshoitumeleng@gmail.com", "TGGY", 999999, "Sky", "Walker", new Date(),
                8333388L, "123 Sunset Blvd, Soweto", LocalDate.now(), "2025-07-02 18:00:00",null, null, null,
                null, null, null, null);

        assertNotNull(user);
        System.out.println(user);
    }

    @Test
    void testCreateUser() {
    }
}


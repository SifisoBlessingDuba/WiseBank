

package za.ac.cput.wisebank.factory;

import org.junit.jupiter.api.Test;
import org.springframework.cglib.core.Local;
import za.ac.cput.wisebank.domain.User;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void createUser() {

        User user = UserFactory.createUser("03120467373", "bedeshoitumeleng@gmail.com", "TGGY", "Sifiso", "Sky", LocalDate.now(),
                "09367362545", "123 Sunset Blvd, Soweto", LocalDate.now(),LocalDate.now(),null, null, null,
                null, null, null, null);

        assertNotNull(user);
        System.out.println(user);
    }

    @Test
    void testCreateUser() {
    }
}


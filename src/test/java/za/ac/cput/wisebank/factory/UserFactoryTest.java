

package za.ac.cput.wisebank.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.wisebank.domain.User;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void createUser() {
        User user = UserFactory.createUser(
                1,  // userid
                "bedeshoitumeleng@gmail.com",  // email
                "TGGY",  // password
                999999,  // idNumber
                "Sky",  // firstName
                "Walker",  // lastName
                new Date(),  // dateOfBirth
                8333388L,  // phoneNumber
                "123 Sunset Blvd, Soweto",  // address
                LocalDate.now(),  // createdAt
                "2025-07-02 18:00:00"
        );

        assertNotNull(user);
        System.out.println(user);
    }
}


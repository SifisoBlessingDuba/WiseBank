package za.ac.cput.wisebank.Factory;

import za.ac.cput.wisebank.domain.User;

import java.time.LocalDate;
import java.util.Date;

public class UserFactory {
    public static User createUser(Integer userid,
                                  String email,
                                  String password ,
                                  Integer idNumber,
                                  String firstName,
                                  String lastName ,
                                  Date dateOfBirth,
                                  Long phoneNumber ,
                                  String address ,
                                  LocalDate createdAt,
                                  String lastLogin) {
        return new User.Builder()
                .setUserid(userid)
                .setEmail(email)
                .setPassword(password)
                .setIdNumber(idNumber)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setDateOfBirth(dateOfBirth)
                .setPhoneNumber(phoneNumber)
                .setAddress(address)
                .setCreatedAt(createdAt)
                .setLastLogin(lastLogin)
                .build();

    }
}

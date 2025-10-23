package za.ac.cput.wisebank.factory;

import org.springframework.stereotype.Component;
import za.ac.cput.wisebank.domain.*;
import za.ac.cput.wisebank.util.Helper;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
public class UserFactory {
    public static User createUser(String idNumber, String email, String password , String firstName, String lastName , LocalDate dateOfBirth,
                                  String phoneNumber , String address , LocalDate createdAt, LocalDate lastLogin) {

        if(Helper.isNullOrEmpty(idNumber) ||
            Helper.isNullOrEmpty(email) ||
            Helper.isNullOrEmpty(password) ||
            Helper.isNullOrEmpty(firstName) ||
            Helper.isNullOrEmpty(lastName) ||
            Helper.isNullOrEmpty(phoneNumber) ||
            Helper.isNullOrEmpty(address)) {
            return null;
        }
        return new User.Builder()
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
//guys check if this page will show up in the final project
//39

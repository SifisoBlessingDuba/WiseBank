package za.ac.cput.wisebank.factory;

import org.springframework.stereotype.Component;
import za.ac.cput.wisebank.domain.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Component
public class UserFactory {
    public static User createUser(String idNumber,
                                  String email,
                                  String password ,
                                  String firstName,
                                  String lastName ,
                                  LocalDate dateOfBirth,
                                  String phoneNumber ,
                                  String address ,
                                  LocalDate createdAt,
                                  LocalDate lastLogin
//                                  List<Account> account,
//                                  List<LoanPayment> loanpayment,
//                                  List<Beneficiary> beneficiary,
//                                  List<Message> messages,
//                                 List<Notification> notifications,
//                                  List<Card> cards,
//                                  List<Loan> loans


                                  ) {
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
//                .setAccount(account)
//                .setBeneficiary(beneficiary)
//                .setMessage(messages)
//                .setNotification(notifications)
                .build();

    }
}

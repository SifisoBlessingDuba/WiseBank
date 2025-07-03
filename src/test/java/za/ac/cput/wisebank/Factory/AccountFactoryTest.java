package za.ac.cput.wisebank.Factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.User;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
class AccountFactoryTest {
    @Test
    void createAccount() {
        Account account = AccountFactory.createAccount(
                11,12344586789L,"Savings",9.8,8.4,""
        );

        assertNotNull(account);
        System.out.println(account);
    }
}

  

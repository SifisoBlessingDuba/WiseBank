package za.ac.cput.wisebank.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.wisebank.domain.Account;

import static org.junit.jupiter.api.Assertions.*;
class AccountFactoryTest {
    @Test
    void createAccount() {
        Account account = AccountFactory.createAccount(
                11,12344586789L,"Savings",9.8,8.4,"Active"
        );

        assertNotNull(account);
        System.out.println(account);
    }
}



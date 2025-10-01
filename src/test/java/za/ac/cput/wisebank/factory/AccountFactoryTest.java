package za.ac.cput.wisebank.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.AccountType;

import static org.junit.jupiter.api.Assertions.*;
class AccountFactoryTest {
    @Test
    void createAccount() {
        Account account = AccountFactory.createAccount(
                "2378125738", AccountType.SAVINGS,9.8,8.4,"Active",null,null,null);

        assertNotNull(account);
        System.out.println(account);
    }
}



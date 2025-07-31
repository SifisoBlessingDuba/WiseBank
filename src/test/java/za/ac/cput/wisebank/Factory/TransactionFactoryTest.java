package za.ac.cput.wisebank.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.Transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TransactionFactoryTest {

    @Test

    void createTransaction_nullAccount_returnsNull() {
        Transaction transaction = TransactionFactory.createTransaction(
                1, null, new BigDecimal("50.00"), "Deposit",
                LocalDateTime.now(), "Top-up", "Pending"
        );

        assertNull(transaction);
    }

    @Test
    void createTransaction_negativeAmount_returnsNull() {
        Account mockAccount = new Account();
        Transaction transaction = TransactionFactory.createTransaction(
                1, mockAccount, new BigDecimal("-10.00"), "Withdraw",
                LocalDateTime.now(), "Invalid test", "Failed"
        );

        assertNull(transaction);
    }
}
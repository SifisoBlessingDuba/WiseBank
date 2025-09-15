package za.ac.cput.wisebank.service;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.Transaction;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.repository.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Autowired
    UserRepository userRepository;

    private Transaction testTransaction1;
    private Transaction testTransaction2;
    private Transaction testTransaction3;

    @BeforeEach
    void setUp() {
        User user1 = new User.Builder()
                .setUserid("U001")
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("john@example.com")
                .setPassword("password123")
                .build();

        User user2 = new User.Builder()
                .setUserid("U002")
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("john@example.com")
                .setPassword("password123")
                .build();


        User user3 = new User.Builder()
                .setUserid("U003")
                .setFirstName("John")
                .setLastName("Doe")
                .setEmail("john@example.com")
                .setPassword("password123")
                .build();




        Account account1 = new Account.Builder()
                .setAccountNumber("112")
                .setUser(user1)
                .build();
        Account account2 = new Account.Builder()
                .setAccountNumber("883")
                .setUser(user2)
                .build();

        Account account3 = new Account.Builder()
                .setAccountNumber("777")
                .setUser(user3)
                .build();


        testTransaction1 = new Transaction.Builder()

                .setAccount(account1)
                .setAmount(new BigDecimal("2500.00"))
                .setTransactionType("Credit")
                .setTimestamp(LocalDateTime.now())
                .setDescription("Salary Deposit")
                .setStatus("Completed")
                .build();

        testTransaction2 = new Transaction.Builder()

                .setAccount(account2)
                .setAmount(new BigDecimal("500.00"))
                .setTransactionType("Debit")
                .setTimestamp(LocalDateTime.now())
                .setDescription("ATM Withdrawal")
                .setStatus("Completed")
                .build();

        testTransaction3 = new Transaction.Builder()

                .setAccount(account3)
                .setAmount(new BigDecimal("1200.00"))
                .setTransactionType("Credit")
                .setTimestamp(LocalDateTime.now())
                .setDescription("EFT Payment")
                .setStatus("Pending")
                .build();
    }

    @Test
    void testSaveTransaction() {
        Transaction saved1 = transactionService.save(testTransaction1);
        assertNotNull(saved1);
        System.out.println("Saved: " + saved1);

        Transaction saved2 = transactionService.save(testTransaction2);
        assertNotNull(saved2);
        System.out.println("Saved: " + saved2);

        Transaction saved3 = transactionService.save(testTransaction3);
        assertNotNull(saved3);
        System.out.println("Saved: " + saved3);
    }

    @Test
    @Transactional
    void testUpdateTransaction() {
        Transaction updatedTransaction = new Transaction.Builder()
                .copy(testTransaction1)
                .setStatus("Reversed")
                .build();

        Transaction updated = transactionService.update(updatedTransaction);
        assertNotNull(updated);
        assertEquals("Reversed", updated.getStatus());
        System.out.println("Updated: " + updated);
    }

    @Test
    @Transactional
    void testFindTransactionByIdExists() {
        Transaction found = transactionService.findById(1L);
        assertNotNull(found);
        System.out.println("Found: " + found);
    }

    @Test
    @Transactional
    void testGetAllTransactions() {
        List<Transaction> transactions = transactionService.getAll();
        assertNotNull(transactions);
        System.out.println("All transactions: " + transactions);
    }
}

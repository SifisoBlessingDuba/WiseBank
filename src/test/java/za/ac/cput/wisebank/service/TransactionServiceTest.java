package za.ac.cput.wisebank.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.Transaction;
import za.ac.cput.wisebank.repository.TransactionRepository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    private Transaction testTransaction1;
    private Transaction testTransaction2;

    @BeforeEach
    void setUp() {
        Account account1 = new Account.Builder()
                .setAccountNumber("112")
                .build();
        Account account2 = new Account.Builder()
                .setAccountNumber("883")
                .build();

        testTransaction1 = new Transaction.Builder()
                .setTransactionId(1L)
                .setAccount(account1)
                .setAmount(new BigDecimal("2500.00"))
                .setTransactionType("Credit")
                .setTimestamp(LocalDateTime.now())
                .setDescription("Salary Deposit")
                .setStatus("Completed")
                .build();

        testTransaction2 = new Transaction.Builder()
                .setTransactionId(2L)
                .setAccount(account2)
                .setAmount(new BigDecimal("500.00"))
                .setTransactionType("Debit")
                .setTimestamp(LocalDateTime.now())
                .setDescription("ATM Withdrawal")
                .setStatus("Completed")
                .build();
    }

    @Test
    void testSaveTransaction() {
        when(transactionRepository.save(any(Transaction.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Transaction saved1 = transactionService.save(testTransaction1);
        assertNotNull(saved1);
        assertEquals("Credit", saved1.getTransactionType());

        Transaction saved2 = transactionService.save(testTransaction2);
        assertNotNull(saved2);
        assertEquals("Debit", saved2.getTransactionType());

        verify(transactionRepository, times(2)).save(any(Transaction.class));
    }

    @Test
    void testUpdateTransaction() {
        when(transactionRepository.save(any(Transaction.class))).thenAnswer(invocation -> invocation.getArgument(0));

        Transaction updatedTransaction = new Transaction.Builder()
                .copy(testTransaction1)
                .setStatus("Reversed")
                .build();

        Transaction updated = transactionService.update(updatedTransaction);
        assertNotNull(updated);
        assertEquals("Reversed", updated.getStatus());
        verify(transactionRepository).save(any(Transaction.class));
    }

    @Test
    void testFindTransactionByIdExists() {
        when(transactionRepository.findById(1L)).thenReturn(Optional.of(testTransaction1));

        Transaction found = transactionService.findById(1L);
        assertNotNull(found);
        assertEquals(1L, found.getTransactionId());
        verify(transactionRepository).findById(1L);
    }

    @Test
    void testGetAllTransactions() {
        when(transactionRepository.findAll()).thenReturn(List.of(testTransaction1, testTransaction2));

        List<Transaction> transactions = transactionService.getAll();
        assertNotNull(transactions);
        assertEquals(2, transactions.size());
        assertEquals("Credit", transactions.get(0).getTransactionType());
        verify(transactionRepository).findAll();
    }
}

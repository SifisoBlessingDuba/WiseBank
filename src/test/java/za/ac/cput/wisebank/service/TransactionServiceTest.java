package za.ac.cput.wisebank.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.Transaction;
import za.ac.cput.wisebank.repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    private Transaction testTransaction;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        Account account = new Account();

        testTransaction = new Transaction.Builder()
                .setTransactionId(1L)
                .setAccount(account)
                .setAmount(new BigDecimal("2500.00"))
                .setTransactionType("Credit")
                .setTimestamp(LocalDateTime.now())
                .setDescription("Salary Deposit")
                .setStatus("Completed")
                .build();
    }

    @Test
    void testSaveTransaction() {
        when(transactionRepository.save(testTransaction)).thenReturn(testTransaction);

        Transaction saved = transactionService.save(testTransaction);

        assertNotNull(saved);
        assertEquals("Credit", saved.getTransactionType());
        verify(transactionRepository).save(testTransaction);
    }

    @Test
    void testUpdateTransaction() {
        when(transactionRepository.save(testTransaction)).thenReturn(testTransaction);

        Transaction updated = transactionService.update(testTransaction);

        assertEquals("Completed", updated.getStatus());
        verify(transactionRepository).save(testTransaction);
    }

    @Test
    void testDeleteTransaction() {
        Long transactionId = 1L;
        doNothing().when(transactionRepository).deleteById(transactionId);

        transactionService.deleteById(transactionId);

        verify(transactionRepository).deleteById(transactionId);
    }

    @Test
    void testFindTransactionByIdExists() {
        when(transactionRepository.findById(1L)).thenReturn(Optional.of(testTransaction));

        Transaction found = transactionService.findById(1L);

        assertNotNull(found);
        assertEquals("Salary Deposit", found.getDescription());
        verify(transactionRepository).findById(1L);
    }

    @Test
    void testFindTransactionByIdNotExists() {
        when(transactionRepository.findById(2L)).thenReturn(Optional.empty());

        Transaction found = transactionService.findById(2L);

        assertNull(found);
        verify(transactionRepository).findById(2L);
    }

    @Test
    void testGetAllTransactions() {
        List<Transaction> transactionList = List.of(testTransaction);
        when(transactionRepository.findAll()).thenReturn(transactionList);

        List<Transaction> result = transactionRepository.findAll();

        assertEquals(1, result.size());
        assertEquals(new BigDecimal("2500.00"), result.get(0).getAmount());
        verify(transactionRepository).findAll();
    }
}

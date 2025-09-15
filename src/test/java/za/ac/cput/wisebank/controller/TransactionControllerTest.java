package za.ac.cput.wisebank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.Transaction;
import za.ac.cput.wisebank.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TransactionController.class)
public class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService transactionService;

    private ObjectMapper objectMapper;

    private Transaction testTransaction;

    @BeforeEach
    void setUp() {
        // Register JavaTimeModule to handle LocalDateTime serialization
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        // Create a sample Account object (use minimal info to avoid deep dependency issues)
        Account account = new Account.Builder()
                .setAccountNumber("1234567890")
                .build();

        // Create a sample Transaction
        testTransaction = new Transaction.Builder()
                .setTransactionId(1L)
                .setAccount(account)
                .setAmount(BigDecimal.valueOf(1000.50))
                .setTransactionType("Deposit")
                .setTimestamp(LocalDateTime.now())
                .setDescription("Initial Deposit")
                .setStatus("Completed")
                .build();
    }

    @Test
    void testSaveTransaction() throws Exception {
        when(transactionService.save(any(Transaction.class))).thenReturn(testTransaction);

        mockMvc.perform(post("/transaction/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testTransaction)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transactionType").value("Deposit"))
                .andExpect(jsonPath("$.status").value("Completed"));
    }

    @Test
    void testUpdateTransaction() throws Exception {
        when(transactionService.update(any(Transaction.class))).thenReturn(testTransaction);

        mockMvc.perform(put("/transaction/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testTransaction)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transactionType").value("Deposit"));
    }

    @Test
    void testDeleteTransaction() throws Exception {
        doNothing().when(transactionService).deleteById(1L);

        mockMvc.perform(delete("/transaction/deleteById/1"))
                .andExpect(status().isOk());

        verify(transactionService).deleteById(1L);
    }

    @Test
    void testFindTransactionById() throws Exception {
        when(transactionService.findById(1L)).thenReturn(testTransaction);

        mockMvc.perform(get("/transaction/findById/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.transactionId").value(1))
                .andExpect(jsonPath("$.transactionType").value("Deposit"));
    }

    @Test
    void testFindAllTransactions() throws Exception {
        // The controller returns a list of TransactionDTO via transactionService.getAllTransactions()
        // so we need to mock that method instead of getAll().
        za.ac.cput.wisebank.dto.TransactionDTO dto = new za.ac.cput.wisebank.dto.TransactionDTO(
                testTransaction.getTransactionId(),
                testTransaction.getAccount().getAccountNumber(),
                testTransaction.getAmount(),
                testTransaction.getTransactionType(),
                testTransaction.getTimestamp(),
                testTransaction.getDescription(),
                testTransaction.getStatus()
        );
        when(transactionService.getAllTransactions()).thenReturn(java.util.List.of(dto));

        mockMvc.perform(get("/transaction/find-all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].transactionType").value("Deposit"))
                .andExpect(jsonPath("$[0].status").value("Completed"));
    }
}

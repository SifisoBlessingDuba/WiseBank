package za.ac.cput.wisebank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.Loan;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.service.LoanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LoanController.class)
public class LoanControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoanService loanService;

    private Loan testLoan;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        // Register JavaTimeModule to handle LocalDateTime serialization/deserialization
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        User testUser = new User.Builder()
                .setIdNumber("1233543")
                .setFirstName("Sifiso")
                .setLastName("Duba")
                .setEmail("sifiso@example.com")
                .build();

        Account testAccount = new Account.Builder()
                .setAccountNumber("acc123")
                .setAccountBalance(1000.0)
                .setAccountType("Savings")
                .setUser(testUser)
                .build();

        testLoan = new Loan.Builder()
                .setLoanId(1)
                .setLoanType("Personal")
                .setLoanStatus("Approved")
                .setLoanAmount(5000)
                .setLoanInterest(5)
                .setLoanTotal(5250)
                .setMonthlyPayment(500)
                .setOutstandingPayment(2500)
                .setLoanDate(LocalDateTime.now())
                .setUser(testUser)
                .setAccount(testAccount)
                .build();
    }

    @Test
    void testSaveLoan() throws Exception {
        when(loanService.save(any(Loan.class))).thenReturn(testLoan);

        mockMvc.perform(post("/Loan/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testLoan)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.loanType").value("Personal"))
                .andExpect(jsonPath("$.loanStatus").value("Approved"));
    }

    @Test
    void testUpdateLoan() throws Exception {
        when(loanService.update(any(Loan.class))).thenReturn(testLoan);

        mockMvc.perform(put("/Loan/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testLoan)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.loanAmount").value(5000));
    }

    @Test
    void testFindLoanById() throws Exception {
        when(loanService.findById(1)).thenReturn(testLoan);

        mockMvc.perform(get("/Loan/find_loan1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.loanId").value(1))
                .andExpect(jsonPath("$.loanStatus").value("Approved"));
    }

    @Test
    void testDeleteLoan() throws Exception {
        doNothing().when(loanService).deleteById(1);

        mockMvc.perform(delete("/Loan/delete-loan1"))
                .andExpect(status().isOk());

        verify(loanService, times(1)).deleteById(1);
    }

    @Test
    void testFindAllLoans() throws Exception {
        when(loanService.getAll()).thenReturn(List.of(testLoan));

        mockMvc.perform(get("/Loan/all-loans"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].loanType").value("Personal"));
    }
}

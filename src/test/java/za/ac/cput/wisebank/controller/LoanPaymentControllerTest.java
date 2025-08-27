package za.ac.cput.wisebank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.ac.cput.wisebank.domain.Loan;
import za.ac.cput.wisebank.domain.LoanPayment;
import za.ac.cput.wisebank.domain.Notification;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.service.LoanPaymentService;
import za.ac.cput.wisebank.service.NotificationService;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(NotificationController.class)
public class LoanPaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LoanPaymentService loanPaymentService;

    private LoanPayment testLoanPayment;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        Loan testLoan = new Loan.Builder()
                .setLoanId(1)
                .setLoanType("Personal")
                .setLoanAmount(5000.0)
                .build();

        LoanPayment testLoanPayment = new LoanPayment.Builder()
                .setPaymentId(1)
                .setPaymentDate(LocalDateTime.now())
                .setAmountPaid(1000.0)
                .setStatus("PAID")
                .setLoan(testLoan)
                .build();
    }

    @Test
    void testSaveLoanPayment() throws Exception {
        when(loanPaymentService.save(any(LoanPayment.class))).thenReturn(testLoanPayment);

        mockMvc.perform(post("/LoanPayment/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testLoanPayment)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.paymentId").value(1))
                .andExpect(jsonPath("$.amountPaid").value(1000.0))
                .andExpect(jsonPath("$.status").value("PAID"))
                .andExpect(jsonPath("$.loan.loanType").value("Personal"));
    }

    @Test
    void testUpdateLoanPayment() throws Exception {
        when(loanPaymentService.update(any(LoanPayment.class))).thenReturn(testLoanPayment);

        mockMvc.perform(put("/LoanPayment/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testLoanPayment)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.paymentId").value(1))
                .andExpect(jsonPath("$.amountPaid").value(1200.0))
                .andExpect(jsonPath("$.status").value("PENDING"))
                .andExpect(jsonPath("$.loan.loanType").value("Personal"));

    }

    @Test
    void testFindLoanPaymentById() throws Exception {
        when(loanPaymentService.findById(1)).thenReturn(testLoanPayment);

        mockMvc.perform(get("/LoanPayment/find_loanPayment"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.paymentId").value(1))
                .andExpect(jsonPath("$.amountPaid").value(1200.0))
                .andExpect(jsonPath("$.status").value("PENDING"))
                .andExpect(jsonPath("$.loan.loanType").value("Personal"));
    }

    @Test
    void testDeleteLoanPayment() throws Exception {
        doNothing().when(loanPaymentService).deleteById(1);

        mockMvc.perform(delete("/LoanPayment/delete/1"))
                .andExpect(status().isOk());

        verify(loanPaymentService, times(1)).deleteById(1);
    }

    @Test
    void testFindAllLoanPayment() throws Exception {
        when(loanPaymentService.getAll()).thenReturn(List.of(testLoanPayment));

        mockMvc.perform(get("/LoanPayment/all"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].paymentId").value(1))
                .andExpect(jsonPath("$[0].amountPaid").value(1200.0))
                .andExpect(jsonPath("$[0].status").value("PENDING"))
                .andExpect(jsonPath("$[0].loan.loanType").value("Personal"));
    }
}
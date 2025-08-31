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
import za.ac.cput.wisebank.service.LoanPaymentService;


import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(LoanPaymentController.class)
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

        testLoanPayment = new LoanPayment.Builder()
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

        mockMvc.perform(post("/loanPayment/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testLoanPayment)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.amountPaid").value(1000.0))
                .andExpect(jsonPath("$.status").value("PAID"));
    }

    @Test
    void testUpdateLoanPayment() throws Exception {

        when(loanPaymentService.update(any(LoanPayment.class))).thenReturn(testLoanPayment);

        mockMvc.perform(put("/loanPayment/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testLoanPayment)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value("PAID"));
    }

    @Test
    void testFindLoanPaymentById() throws Exception {
        when(loanPaymentService.findById(1)).thenReturn(testLoanPayment);

        mockMvc.perform(get("/loanPayment/findById/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.amountPaid").value(1000.0))
                .andExpect(jsonPath("$.status").value("PAID"));
    }


    @Test
    void testDeleteLoanPayment() throws Exception {
        doNothing().when(loanPaymentService).deleteById(1);

        mockMvc.perform(delete("/loanPayment/deleteById/1"))
                .andDo(print())
                .andExpect(status().isOk());

        verify(loanPaymentService).deleteById(1);
    }


    @Test
    void testFindAllLoanPayment() throws Exception {
        when(loanPaymentService.getAll()).thenReturn(List.of(testLoanPayment));

        mockMvc.perform(get("/loanPayment/find-all"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].amountPaid").value(1000.0))
                .andExpect(jsonPath("$[0].status").value("PAID"));
    }
}




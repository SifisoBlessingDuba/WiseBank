package za.ac.cput.wisebank.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import za.ac.cput.wisebank.domain.Loan;
import za.ac.cput.wisebank.domain.LoanPayment;
import za.ac.cput.wisebank.repository.LoanPaymentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoanPaymentServiceTest {

    @Mock
    private LoanPaymentRepository loanPaymentRepository;

    @InjectMocks
    private LoanPaymentService loanPaymentService;

    private LoanPayment loanPayment;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        Loan loan = new Loan();

        loanPayment = new LoanPayment.Builder()
                .setPaymentId(1)
                .setPaymentDate(LocalDateTime.now())
                .setAmountPaid(5000.00)
                .setStatus("Installment")
                .setLoan(loan)
                .build();

    }

    @Test
    void testSaveLoanPayment() {
        when(loanPaymentRepository.save(loanPayment)).thenReturn(loanPayment);

        LoanPayment saved = loanPaymentService.save(loanPayment);

        assertNotNull(saved);
        assertEquals("Installment", saved.getStatus());
        verify(loanPaymentRepository).save(loanPayment);
    }

    @Test
    void testUpdateLoanPayment() {
        when(loanPaymentRepository.save(loanPayment)).thenReturn(loanPayment);

        LoanPayment updated = loanPaymentService.update(loanPayment);

        assertEquals(5000.00, updated.getAmountPaid());
        verify(loanPaymentRepository).save(loanPayment);
    }

    @Test
    void testFindLoanPaymentByIdExists() {
        when(loanPaymentRepository.findById(1)).thenReturn(Optional.of(loanPayment));

        LoanPayment found = loanPaymentService.findById(1);

        assertNotNull(found);
        assertEquals("Installment", found.getStatus());
        verify(loanPaymentRepository).findById(1);
    }

    @Test
    void testFindLoanPaymentByIdDoesNotExist() {

        when(loanPaymentRepository.findById(2)).thenReturn(Optional.empty());

        LoanPayment found = loanPaymentService.findById(2);

        assertNull(found);
        verify(loanPaymentRepository).findById(2);
    }

    @Test
    void testDeleteLoanPayment() {
        doNothing().when(loanPaymentRepository).deleteById(1);

        loanPaymentService.deleteById(1);

        verify(loanPaymentRepository).deleteById(1);
    }

    @Test
    void testGetAllLoanPayments() {
        List<LoanPayment> loanPaymentList = List.of(loanPayment);
        when(loanPaymentRepository.findAll()).thenReturn(loanPaymentList );

        List<LoanPayment> result = loanPaymentService.getAll();

        assertEquals(1, result.size());
        assertEquals(5000.00, result.get(0).getAmountPaid());
        verify(loanPaymentRepository).findAll();
    }
}
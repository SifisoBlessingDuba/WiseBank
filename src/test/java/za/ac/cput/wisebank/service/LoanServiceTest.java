package za.ac.cput.wisebank.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.Loan;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.repository.LoanRepository;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoanServiceTest {

    @Mock
    private LoanRepository loanRepository;

    @InjectMocks
    private LoanService loanService;

    private Loan testLoan;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        User user = new User();
        Account account = new Account();

        testLoan = new Loan.Builder()
                .setLoanId(1)
                .setLoanType("Personal Loan")
                .setLoanStatus("Approved")
                .setLoanAmount(10000)
                .setLoanInterest(5.5)
                .setLoanTotal(10550)
                .setMonthlyPayment(879.17)
                .setOutstandingPayment(879.17)
                .setLoanDate(LocalDateTime.now())
                .setUser(user)
                .setAccount(account)
                .setPayments(new ArrayList<>())
                .build();
    }

    @Test
    void testSaveLoan() {
        when(loanRepository.save(testLoan)).thenReturn(testLoan);

        Loan saved = loanService.save(testLoan);

        assertNotNull(saved);
        assertEquals("Personal Loan", saved.getLoanType());
        verify(loanRepository).save(testLoan);
    }

    @Test
    void testUpdateLoan() {
        when(loanRepository.save(testLoan)).thenReturn(testLoan);

        Loan updated = loanService.update(testLoan);

        assertEquals(10550, updated.getLoanTotal());
        verify(loanRepository).save(testLoan);
    }

    @Test
    void testFindLoanByIdExists() {
        when(loanRepository.findById(1)).thenReturn(Optional.of(testLoan));

        Loan found = loanService.findById(1);

        assertNotNull(found);
        assertEquals("Approved", found.getLoanStatus());
        verify(loanRepository).findById(1);
    }

    @Test
    void testFindLoanByIdNotExists() {
        when(loanRepository.findById(2)).thenReturn(Optional.empty());

        Loan found = loanService.findById(2);

        assertNull(found);
        verify(loanRepository).findById(2);
    }

    @Test
    void testDeleteLoan() {
        doNothing().when(loanRepository).deleteById(1);

        loanService.deleteById(1);

        verify(loanRepository).deleteById(1);
    }

    @Test
    void testGetAllLoans() {
        List<Loan> loanList = List.of(testLoan);
        when(loanRepository.findAll()).thenReturn(loanList);

        List<Loan> result = loanService.getAll();

        assertEquals(1, result.size());
        assertEquals(10000, result.get(0).getLoanAmount());
        verify(loanRepository).findAll();
    }
}

package za.ac.cput.wisebank.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.User;
import za.ac.cput.wisebank.repository.AccountRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AccountServiceTest {

    @Mock
    private AccountRepository accountRepository;

    @InjectMocks
    private AccountService accountService;

    private Account testAccount;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        //User user = new User(); // You can set fields if necessary
        User user = mock(User.class);


        testAccount = new Account.Builder()
                .setAccountNumber("12345")
                .setAccountType("Savings")
                .setAccountBalance(1000.00)
                .setCurrency(1.0)
                .setBankName("WiseBank")
                .setStatus("Active")
                .setUser(user)
                .build();
    }

    @Test
    void testFindAll() {
        List<Account> accounts = List.of(testAccount);
        when(accountRepository.findAll()).thenReturn(accounts);

        List<Account> result = accountService.findAll();

        assertEquals(1, result.size());
        assertEquals("Savings", result.get(0).getAccountType());
        verify(accountRepository).findAll();
    }

    @Test
    void testSaveAccount() {
        when(accountRepository.save(testAccount)).thenReturn(testAccount);

        Account saved = accountService.save(testAccount);

        assertNotNull(saved);
        assertEquals("WiseBank", saved.getBankName());
        verify(accountRepository).save(testAccount);
    }

    @Test
    void testUpdateAccount() {
        when(accountRepository.save(testAccount)).thenReturn(testAccount);

        Account updated = accountService.update(testAccount);

        assertEquals(1000.00, updated.getAccountBalance());
        verify(accountRepository).save(testAccount);
    }

    @Test
    void testDeleteAccount() {
        String accountNumber = "12345";
        doNothing().when(accountRepository).deleteById(accountNumber);

        accountService.deleteById(accountNumber);

        verify(accountRepository).deleteById(accountNumber);
    }

    @Test
    void testFindAccountByIdExists() {
        when(accountRepository.findById("12345")).thenReturn(Optional.of(testAccount));

        Account found = accountService.findById("12345");

        assertNotNull(found);
        assertEquals("Savings", found.getAccountType());
        verify(accountRepository).findById("12345");
    }

    @Test
    void testFindAccountByIdNotExists() {
        when(accountRepository.findById("99999")).thenReturn(Optional.empty());

        Account found = accountService.findById("99999");

        assertNull(found);
        verify(accountRepository).findById("99999");
    }
}

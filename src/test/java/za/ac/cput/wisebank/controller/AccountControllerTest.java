package za.ac.cput.wisebank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.service.AccountService;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class AccountControllerTest {

    private MockMvc mockMvc;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private AccountService accountService;

    @InjectMocks
    private AccountController accountController;

    private Account testAccount;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(accountController).build();

        testAccount = new Account.Builder()
                .setAccountNumber("1234567890")
                .setAccountType("Savings")
                .setAccountBalance(1000.00)
                .setBankName("WiseBank")
                .setStatus("Active")
                .build();
    }

    @Test
    void testSaveAccount() throws Exception {
        when(accountService.save(any(Account.class))).thenReturn(testAccount);

        mockMvc.perform(post("/account/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testAccount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountNumber").value("1234567890"))
                .andExpect(jsonPath("$.accountType").value("Savings"));
    }

    @Test
    void testUpdateAccount() throws Exception {
        when(accountService.save(any(Account.class))).thenReturn(testAccount);

        mockMvc.perform(put("/account/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testAccount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountType").value("Savings"));
    }

    @Test
    void testDeleteAccount() throws Exception {
        doNothing().when(accountService).deleteById("1234567890");

        mockMvc.perform(delete("/account/deleteAccount1234567890"))
                .andExpect(status().isOk());

        verify(accountService, times(1)).deleteById("1234567890");
    }

    @Test
    void testFindById() throws Exception {
        when(accountService.findById("1234567890")).thenReturn(testAccount);

        mockMvc.perform(get("/account/rad_account1234567890"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.accountNumber").value("1234567890"));
    }

    @Test
    void testFindAllAccounts() throws Exception {
        List<Account> accounts = Collections.singletonList(testAccount);
        when(accountService.findAll()).thenReturn(accounts);

        mockMvc.perform(get("/account/all_accounts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].accountNumber").value("1234567890"));
    }
}

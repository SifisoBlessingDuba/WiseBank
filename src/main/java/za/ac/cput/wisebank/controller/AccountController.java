package za.ac.cput.wisebank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.Card;
import za.ac.cput.wisebank.service.AccountService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;
    private final za.ac.cput.wisebank.repository.UserRepository userRepository;

    @Autowired
    public AccountController(AccountService accountService, za.ac.cput.wisebank.repository.UserRepository userRepository) {
        this.accountService = accountService;
        this.userRepository = userRepository;
    }

    @PostMapping("/save")
    public Account save(@RequestBody Account account) {
        return accountService.save(account);
    }

    @PutMapping("/update")
    public Account update(@RequestBody Account account) {
        return accountService.save(account);
    }

    @DeleteMapping("/deleteAccount/{id}")
    public void deleteById(@PathVariable String id) {
        accountService.deleteById(id);
    }

    @GetMapping("/read_account/by-id/{id}")
    public ResponseEntity<Account> findById(@PathVariable String id) {
        Account account = accountService.findById(id);
        if (account == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(account);
    }

    @GetMapping("/read_account/by-user/{userId}")
    public List<Account> findByUserId(@PathVariable String userId) {
        return accountService.findByUserId(userId);
    }

    @GetMapping("/me")
    public ResponseEntity<List<Account>> myAccounts(java.security.Principal principal) {
        if (principal == null) {
            return ResponseEntity.status(401).build();
        }
        String name = principal.getName();
        // name can be email or idNumber depending on how the user authenticated
        String idNumber = userRepository.findByEmail(name)
                .map(za.ac.cput.wisebank.domain.User::getIdNumber)
                .orElse(name);
        List<Account> accounts = accountService.findByUserId(idNumber);
        if (accounts == null || accounts.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(accounts);
    }


    @GetMapping("/all_accounts")
    public ResponseEntity<List<Account>> findAll() {
        List<Account> accounts = accountService.findAll();

        if (accounts.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 if no accounts
        }
        return ResponseEntity.ok(accounts); // 200 + JSON body
    }

}
//guys check if this page will show up in the final project
//5


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
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
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


    @GetMapping("/all_accounts")
    public ResponseEntity<List<Account>> findAll() {
        List<Account> accounts = accountService.findAll();

        if (accounts.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 if no accounts
        }
        return ResponseEntity.ok(accounts); // 200 + JSON body
    }

}



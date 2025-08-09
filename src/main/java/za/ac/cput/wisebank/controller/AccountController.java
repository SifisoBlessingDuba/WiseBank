package za.ac.cput.wisebank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.Card;
import za.ac.cput.wisebank.service.AccountService;

import java.util.List;

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
    public Account update (@RequestBody Account account) {
        return accountService.save(account);
    }
    @DeleteMapping("/deleteAccount{id}")
    public void deleteById (@PathVariable String id) {
        accountService.deleteById(id);
    }
    @GetMapping("/rad_account{id}")
    public Account findById (@PathVariable String id) {
        return accountService.findById(id);
    }
    @GetMapping("/all_accounts")
    public List<Account> findAll () {
        return accountService.findAll();
    }
}

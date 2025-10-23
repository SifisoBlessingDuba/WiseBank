package za.ac.cput.wisebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.repository.AccountRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService implements IAccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account update(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public void deleteById(String id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account findById(String id) {
        return accountRepository.findById(id).orElse(null);
    }

    public List<Account> findByUserId(String idNumber) {
        return accountRepository.findByUser_IdNumber(idNumber);
    }


    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
//guys check if this page will show up in the final project
//56
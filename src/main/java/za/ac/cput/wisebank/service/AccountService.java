package za.ac.cput.wisebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.Card;
import za.ac.cput.wisebank.repository.AccountRepository;

import java.util.List;

@Service
public class AccountService implements IAccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account save (Account account){
        return accountRepository.save(account);
    }
    @Override
    public Account update (Account account){
        return accountRepository.save(account);
    }

    @Override
    public void deleteById (String id){
        accountRepository.deleteById(id);
    }


    @Override
    public Account findById ( String id){
        return accountRepository.findById(id).orElse(null);
    }
@Override

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}


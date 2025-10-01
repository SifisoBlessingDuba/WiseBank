package za.ac.cput.wisebank.service;

import za.ac.cput.wisebank.domain.Account;

import java.util.List;

public interface IAccountService extends IService<Account,String> {
    List<Account> findAll();
    List<Account> findByUserId(String idNumber);

}

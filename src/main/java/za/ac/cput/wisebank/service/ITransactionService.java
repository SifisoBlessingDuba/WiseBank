package za.ac.cput.wisebank.service;

import za.ac.cput.wisebank.domain.Transaction;

import java.util.List;

public interface ITransactionService extends IService<Transaction, Long> {
    List<Transaction> getAll();
}

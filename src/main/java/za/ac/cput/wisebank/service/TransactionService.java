package za.ac.cput.wisebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.wisebank.domain.Transaction;
import za.ac.cput.wisebank.dto.TransactionDTO;
import za.ac.cput.wisebank.repository.TransactionRepository;

import java.util.List;

@Service
public class TransactionService implements ITransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction save(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction update(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteById(Long id) {
        transactionRepository.deleteById(id);

    }

    @Override
    public Transaction findById(Long id) {
        return transactionRepository.findById(id).orElse(null);
    }
    @Override
    public List<Transaction> getAll() {
        return transactionRepository.findAll();
    }
    public List<TransactionDTO> getAllTransactions() {
        return transactionRepository.findAll().stream()
                .map(tx -> new TransactionDTO(
                        tx.getTransactionId(),
                        tx.getAccount().getAccountNumber(),
                        tx.getAmount(),
                        tx.getDescription(),
                        tx.getTimestamp(),
                        tx.getTransactionType(),
                        tx.getStatus()
                ))
                .toList();
    }
}
//guys check if this page will show up in the final project
//72

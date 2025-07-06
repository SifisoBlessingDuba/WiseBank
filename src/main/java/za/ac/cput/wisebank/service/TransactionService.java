package za.ac.cput.wisebank.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.wisebank.domain.Transaction;
import za.ac.cput.wisebank.factory.TransactionFactory;
import za.ac.cput.wisebank.repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final TransactionFactory transactionFactory;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, TransactionFactory transactionFactory) {
        this.transactionRepository = transactionRepository;
        this.transactionFactory = transactionFactory;
    }

    public Transaction createTransaction(Long transactionId, Long senderAccountId, BigDecimal amount,
                                         String transactionType, LocalDateTime timestamp, String description, String status) {

        Transaction transaction = TransactionFactory.createTransaction(transactionId, senderAccountId, amount,
                transactionType, timestamp, description, status);
        return transactionRepository.save(transaction);

    }


    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId).orElseThrow(
                () -> new IllegalArgumentException("Transaction with ID " + transactionId + " does not exist"));
    }

    public List<Transaction> getTransactionsBySenderAccountId(Long senderAccountId) {
        return transactionRepository.findBySenderAccountId(senderAccountId);

    }

    public List<Transaction> getTimestampBetween(LocalDateTime fromStart, LocalDateTime toEnd) {
        return transactionRepository.findByTimestampBetween(fromStart, toEnd);
    }
    public void deleteIfCancelled(Long transactionId) {
        Transaction tx= transactionRepository.getTransactionById(transactionId);
        if(!"CANCELED".equalsIgnoreCase(tx.getStatus())) {
            throw new IllegalArgumentException("Only CANCELED transactions can be deleted");
        }
        transactionRepository.deleteById(transactionId);

    }

    @Transactional
   public Transaction updateTransaction(Long transactionId, Transaction newData) {
        Transaction existingTransaction = getTransactionById(transactionId);

        if("COMPLETED".equalsIgnoreCase(existingTransaction.getStatus())) {
            throw new IllegalArgumentException("Cannot update a completed transaction");
        }
        Transaction updatedTransaction= transactionFactory.updateTransaction(existingTransaction, newData);
                return transactionRepository.save(updatedTransaction);
    }

}

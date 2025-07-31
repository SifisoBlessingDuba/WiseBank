package za.ac.cput.wisebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.Transaction;
import za.ac.cput.wisebank.factory.TransactionFactory;
import za.ac.cput.wisebank.repository.TransactionRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    // This service will handle business logic related to transactions
    // It will interact with the TransactionRepository to perform CRUD operations


    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }
    public Transaction createTransaction(int transactionId, Account senderAccount,
                                         BigDecimal amount, String transactionType,
                                         LocalDateTime timestamp, String description,
                                         String status) {

        Transaction transaction = TransactionFactory.createTransaction
                (transactionId, senderAccount, amount, transactionType,
                        timestamp, description, status);
        if (transaction != null) {
            return transactionRepository.save(transaction);
        }
        return null;
    }
    public List<Transaction> getAllTransactionsByAccount(Account account) {
        return transactionRepository.findAll().stream()
                .filter(transaction -> transaction.getSenderAccount().equals(account))
                .toList();
    }
    public Optional<Transaction> findTransactionById(int transactionId) {
        return transactionRepository.findById(transactionId);
    }
    public List<Transaction> getTransactionsByType(String transactionType) {
        return transactionRepository.findAll().stream()
                .filter(transaction -> transaction.getTransactionType().equalsIgnoreCase(transactionType))
                .toList();
    }
    public List<Transaction> getTransactionsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        return transactionRepository.findAll().stream()
                .filter(transaction -> !transaction.getTimestamp().isBefore(startDate) &&
                        !transaction.getTimestamp().isAfter(endDate))
                .toList();
    }
    public List<Transaction> getTransactionsByStatus(String status) {
        return transactionRepository.findAll().stream()
                .filter(transaction -> transaction.getStatus().equalsIgnoreCase(status))
                .toList();
    }
}

    /*
   public void deleteTransaction(int transactionId) {
       transactionRepository.deleteById(transactionId);
  }
    i dont think its a good idea to delete transactions
    as they are important records of financial activity.
    Instead, we might consider marking them as inactive or archived.
    This way, we maintain a complete history of transactions
    while preventing any accidental loss of data.

    Ans also i wont include the updateTransaction method
    as it is not a common operation in financial systems.
    Transactions are typically immutable once created.
    If a correction is needed, a new transaction is created
    to reverse or adjust the previous one.
    This ensures a clear audit trail and maintains the integrity of financial records.
    Instead, we can provide methods to retrieve transactions
    by various criteria such as account, date range, or transaction type.
     */



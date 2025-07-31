package za.ac.cput.wisebank.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.Transaction;
import za.ac.cput.wisebank.service.TransactionService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/transaction")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @PostMapping
    public Transaction createTransaction(Transaction transaction) {
        return transactionService.createTransaction(transaction.getTransactionId(),
                transaction.getSenderAccount(), transaction.getAmount(),
                transaction.getTransactionType(), transaction.getTimestamp(),
                transaction.getDescription(), transaction.getStatus());
    }

    @GetMapping
    public List<Transaction> getTransactionsByAccount(Account accountId) {
        return transactionService.getAllTransactionsByAccount(accountId);
    }

    @GetMapping(path = "/{transactionId}")
    public Transaction getTransactionById(int transactionId) {
        return transactionService.findTransactionById(transactionId)
                .orElse(null);
    }
    @GetMapping
    public List<Transaction> getTransactionsByType(String transactionType) {
        return transactionService.getTransactionsByType(transactionType);
    }
//    @GetMapping
//    public List<Transaction> getTransactionsByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
//        return transactionService.getTransactionsByDateRange(startDate, endDate);
//    }
    @GetMapping
    public List<Transaction> getTransactionsByStatus(String status) {
        return transactionService.getTransactionsByStatus(status);
    }

}

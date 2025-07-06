package za.ac.cput.wisebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.wisebank.domain.Transaction;
import za.ac.cput.wisebank.dto.TransactionRequest;
import za.ac.cput.wisebank.service.TransactionService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/transactions")
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

    @GetMapping("/{transactionId}")
    public Transaction getTransactionById(@PathVariable Long transactionId) {
        return transactionService.getTransactionById(transactionId);
    }

    @GetMapping("/sender/{senderAccountId}")
    public List<Transaction> getTransactionsBySenderAccountId(@PathVariable Long senderAccountId) {
        return transactionService.getTransactionsBySenderAccountId(senderAccountId);
    }

    @GetMapping("/range")
    public List<Transaction> getByTimestampRange(@RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime from,
                                                 @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime to) {
        return transactionService.getTimestampBetween(from, to);
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction createdTransact = transactionService.createTransaction(
                transaction.getTransactionId(),
                transaction.getSenderAccountId(),
                transaction.getAmount(),
                transaction.getTransactionType(),
                transaction.getTimestamp(),
                transaction.getDescription(),
                transaction.getStatus()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTransact);
    }

    @PostMapping("/{transactionId}")
    public ResponseEntity<Transaction> cancelTransaction(@PathVariable Long transactionId,
                                                         @RequestBody TransactionRequest newData) {
        try {
            Transaction updatedTransaction = transactionService.updateTransaction(transactionId, newData.toTransaction());
            return ResponseEntity.ok(updatedTransaction);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{transactionId}")
    public ResponseEntity<?> deleteTransaction(@PathVariable Long transactionId) {
        try {
            transactionService.deleteIfCancelled(transactionId);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}

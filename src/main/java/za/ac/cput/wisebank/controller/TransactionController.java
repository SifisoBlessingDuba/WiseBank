package za.ac.cput.wisebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.wisebank.domain.Transaction;
import za.ac.cput.wisebank.dto.TransactionDTO;
import za.ac.cput.wisebank.service.ITransactionService;
import za.ac.cput.wisebank.service.TransactionService;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/save")
    public Transaction save (@RequestBody Transaction transaction) {
        return transactionService.save(transaction);
    }
    @PutMapping("/update")
    public Transaction update (@RequestBody Transaction transaction) {
        return transactionService.update(transaction);
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id) {
        transactionService.deleteById(id);
    }
    @GetMapping("/findById/{id}")
    public Transaction findById(@PathVariable Long id) {
        return transactionService.findById(id);
    }
    @GetMapping("/find-all")
    public ResponseEntity<List<TransactionDTO>> getAllTransactions() {
        return ResponseEntity.ok(transactionService.getAllTransactions());
    }

}

package za.ac.cput.wisebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.wisebank.domain.Loan;
import za.ac.cput.wisebank.service.LoanService;

import java.util.List;

@RestController
@RequestMapping("/Loan")
public class LoanController {

    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping({"/save"})
    public ResponseEntity<?> save(@RequestBody Loan loan) {
        // Basic defensive validation: ensure user id is present and looks valid.
        if (loan == null) {
            return ResponseEntity.badRequest().body("Loan payload is required");
        }
        if (loan.getUser() == null || loan.getUser().getIdNumber() == null) {
            return ResponseEntity.badRequest().body("user.userId is required");
        }

        String userIdStr = loan.getUser().getIdNumber();
        // Accept numeric strings. Reject extremely long values that likely indicate overflow from client numeric literal.
        if (userIdStr.length() > 20) {
            return ResponseEntity.badRequest().body("user.userId is too large");
        }
        // optional: ensure it only contains digits
        if (!userIdStr.matches("\\d+")) {
            return ResponseEntity.badRequest().body("user.userId must be numeric");
        }

        // Passed validation — save and return created with 201
        Loan saved = loanService.save(loan);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
    @PutMapping("/update")
    public Loan update (@RequestBody Loan loan) {
        return loanService.update(loan);
    }
    @GetMapping("/find_loan/{id}")
    public Loan findById(@PathVariable Integer id) {
        return loanService.findById(id);
    }
    @DeleteMapping("/delete-loan/{id}")
    public void deleteById(@PathVariable Integer id) {
        loanService.deleteById(id);
    }
    @GetMapping("/all-loans")
    public List<Loan> findAll() {
        return loanService.getAll();
    }
}
//guys check if this page will show up in the final project
//9
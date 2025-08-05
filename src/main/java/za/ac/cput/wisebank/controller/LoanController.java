package za.ac.cput.wisebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Loan save(@RequestBody Loan loan) {
        return loanService.save(loan);
    }
    @PutMapping("/update")
    public Loan update (@RequestBody Loan loan) {
        return loanService.update(loan);
    }
    @GetMapping("/find_loan{id}")
    public Loan findById(@PathVariable Integer id) {
        return loanService.findById(id);
    }
    @DeleteMapping("/delete-loan{id}")
    public void deleteById(@PathVariable Integer id) {
        loanService.deleteById(id);
    }
    @GetMapping("/all-loans")
    public List<Loan> findAll() {
        return loanService.getAll();
    }
}

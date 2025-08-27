package za.ac.cput.wisebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.wisebank.domain.LoanPayment;
import za.ac.cput.wisebank.service.LoanPaymentService;

import java.util.List;

@RestController
@RequestMapping("/LoanPayment")
public class LoanPaymentController {

    private final LoanPaymentService loanPaymentService;

    @Autowired
    public LoanPaymentController(LoanPaymentService loanPaymentService) {
        this.loanPaymentService = loanPaymentService;
    }

    @PostMapping({"/save"})
    public LoanPayment save(@RequestBody LoanPayment loanPayment) {
        return loanPaymentService.save(loanPayment);
    }

    @PutMapping("/update")
    public LoanPayment update(@RequestBody LoanPayment loanPayment) {
        return loanPaymentService.update(loanPayment);
    }

    @GetMapping("/find_loanPayment{id}")
    public LoanPayment findLoanPayment(@PathVariable Integer id) {
        return loanPaymentService.findById(id);
    }

    @DeleteMapping("/delete-loanPayment{id}")
    public void deleteById(@PathVariable Integer id) {
        loanPaymentService.deleteById(id);
    }

    @GetMapping("/all-loans")
    public List<LoanPayment> getAllLoans() {
        return loanPaymentService.getAll();
    }
}

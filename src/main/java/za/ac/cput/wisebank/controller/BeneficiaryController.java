package za.ac.cput.wisebank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.wisebank.domain.Beneficiary;
import za.ac.cput.wisebank.service.BeneficiaryService;

import java.util.List;

@RestController
@RequestMapping("/beneficiary")
public class BeneficiaryController {

    private final BeneficiaryService beneficiaryService;

    @Autowired
    public BeneficiaryController(BeneficiaryService beneficiaryService) {
        this.beneficiaryService = beneficiaryService;
    }

    @PostMapping("/save")
    public Beneficiary save(@RequestBody Beneficiary beneficiary) {
        return beneficiaryService.save(beneficiary);
    }

    @PutMapping("/update")
    public Beneficiary update(@RequestBody Beneficiary beneficiary) {
        return beneficiaryService.update(beneficiary);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable String id) {
        beneficiaryService.deleteById(id);
    }

    @GetMapping("/read/{id}")
    public Beneficiary findById(@PathVariable String id) {
        return beneficiaryService.findById(id);
    }

    @GetMapping("/all")
    public List<Beneficiary> findAll() {
        return beneficiaryService.findAll();
    }
}
//guys check if this page will show up in the final project
//7
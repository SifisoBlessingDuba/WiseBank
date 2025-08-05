package za.ac.cput.wisebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.wisebank.domain.Loan;
import za.ac.cput.wisebank.repository.LoanRepository;

import java.util.List;

@Service
public class LoanService implements ILoanService {

    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan save(Loan loan) {
        return loanRepository.save(loan);
    }
    @Override
    public Loan update(Loan loan) {
        return loanRepository.save(loan);
    }
    @Override
    public Loan findById(Integer id) {
        return loanRepository.findById(id).orElse(null);
    }
    @Override
    public void deleteById(Integer id) {
        loanRepository.deleteById(id);
    }
    @Override
    public List<Loan> getAll() {
        return loanRepository.findAll();
    }
}

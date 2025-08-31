package za.ac.cput.wisebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.wisebank.domain.LoanPayment;
import za.ac.cput.wisebank.repository.LoanPaymentRepository;

import java.util.List;

@Service
public class LoanPaymentService implements ILoanPaymentService {

    private final LoanPaymentRepository loanPaymentRepository;

    @Autowired
    public LoanPaymentService(LoanPaymentRepository loanPaymentRepository) {

        this.loanPaymentRepository = loanPaymentRepository;
    }

    @Override
    public LoanPayment save (LoanPayment loanPayment){

        return loanPaymentRepository.save(loanPayment);
    }

    @Override
    public LoanPayment update (LoanPayment loanPayment){

        return loanPaymentRepository.save(loanPayment);
    }

    @Override
    public LoanPayment findById(Integer id){

        return loanPaymentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Integer id){

        loanPaymentRepository.deleteById(id);
    }

    @Override
    public List<LoanPayment> getAll(){

        return loanPaymentRepository.findAll();
    }
}

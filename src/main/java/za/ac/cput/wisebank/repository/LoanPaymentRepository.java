package za.ac.cput.wisebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.wisebank.domain.LoanPayment;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanPaymentRepository extends JpaRepository<LoanPayment, Integer> {
    @Override
    LoanPayment save (LoanPayment loanpayment);

    @Override
    void deleteById(Integer id);

    @Override
    Optional<LoanPayment> findById(Integer id);

    @Override
    List<LoanPayment> findAll();
}


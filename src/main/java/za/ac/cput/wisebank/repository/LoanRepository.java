package za.ac.cput.wisebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.wisebank.domain.Loan;

import java.util.List;
import java.util.Optional;
@Repository
public interface LoanRepository extends JpaRepository<Loan, Integer> {
    @Override
    Loan save(Loan loan);

    @Override
    void deleteById(Integer loanId);

    @Override
    Optional<Loan> findById(Integer loanId);

    @Override
    List<Loan> findAll();

}

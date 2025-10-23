package za.ac.cput.wisebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.wisebank.domain.Beneficiary;

import java.util.List;
import java.util.Optional;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, String> {
    @Override
    Beneficiary save(Beneficiary beneficiary);

    @Override
    void deleteById(String accountNumber);

    @Override
    Optional<Beneficiary> findById(String accountNumber);

    @Override
    List<Beneficiary> findAll();
}
//guys check if this page will show up in the final project
//42
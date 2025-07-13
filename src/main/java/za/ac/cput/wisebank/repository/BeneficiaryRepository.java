package za.ac.cput.wisebank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.wisebank.domain.Account;
import za.ac.cput.wisebank.domain.Beneficiary;

import java.util.List;
import java.util.Optional;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Integer> {
    @Override
    Beneficiary save(Beneficiary beneficiary);

    @Override
    void deleteById(Integer beneficiaryId);

    @Override
    Optional<Beneficiary> findById(Integer beneficiaryId);

    @Override
    List<Beneficiary> findAll();
}

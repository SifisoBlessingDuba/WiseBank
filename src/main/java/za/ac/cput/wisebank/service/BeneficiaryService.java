package za.ac.cput.wisebank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.wisebank.domain.Beneficiary;
import za.ac.cput.wisebank.repository.BeneficiaryRepository;

import java.util.List;

@Service
public class BeneficiaryService implements IBeneficiaryService {

    private final BeneficiaryRepository beneficiaryRepository;

    @Autowired
    public BeneficiaryService(BeneficiaryRepository beneficiaryRepository) {
        this.beneficiaryRepository = beneficiaryRepository;
    }

    @Override
    public Beneficiary save(Beneficiary beneficiary) {
        return beneficiaryRepository.save(beneficiary);
    }

    @Override
    public Beneficiary update(Beneficiary beneficiary) {
        return beneficiaryRepository.save(beneficiary);
    }


    @Override
    public void deleteById(String id) {
        beneficiaryRepository.deleteById(id);
    }

    @Override
    public Beneficiary findById(String id) {
        return beneficiaryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Beneficiary> findAll() {
        return beneficiaryRepository.findAll();
    }
}

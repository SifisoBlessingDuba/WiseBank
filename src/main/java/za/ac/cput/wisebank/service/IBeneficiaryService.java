package za.ac.cput.wisebank.service;

import za.ac.cput.wisebank.domain.Beneficiary;


import java.util.List;

public interface IBeneficiaryService extends IService<Beneficiary, String> {
    Beneficiary save(Beneficiary beneficiary);
    Beneficiary update(Beneficiary beneficiary);
    void deleteById(String id);
    Beneficiary findById(String id);
    List<Beneficiary> findAll();
}


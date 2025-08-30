package za.ac.cput.wisebank.service;

import za.ac.cput.wisebank.domain.LoanPayment;

import java.util.List;

public interface ILoanPaymentService extends IService<LoanPayment, Integer>{

    List<LoanPayment> getAll();
}

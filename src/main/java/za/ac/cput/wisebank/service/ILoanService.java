package za.ac.cput.wisebank.service;

import za.ac.cput.wisebank.domain.Loan;

import java.util.List;

public interface ILoanService extends IService <Loan, Integer> {
    List<Loan> getAll();
}

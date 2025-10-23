package za.ac.cput.wisebank.service;

import za.ac.cput.wisebank.domain.Loan;

import java.util.List;

public interface ILoanService extends IService <Loan, Integer> {
    List<Loan> getAll();
}
//guys check if this page will show up in the final project
//62
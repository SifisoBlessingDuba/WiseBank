package za.ac.cput.wisebank.service;

import za.ac.cput.wisebank.domain.Withdrawal;

import java.util.List;

public interface IWithdrawlService extends IService<Withdrawal,Long> {
    List<Withdrawal> findAll();
}
//guys check if this page will show up in the final project
//67
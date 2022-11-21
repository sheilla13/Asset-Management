package com.project.AssetManagement.services;

import com.project.AssetManagement.entities.Loan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanService {
    // get all
    public List<Loan> findAllLoans();

    // find by id
    public Loan findLoanById(int id);

    // save Loan
    public boolean saveLoan(Loan loan);

    // delete
    public boolean deleteLoanById(int id);

    public boolean approval(int id);
}

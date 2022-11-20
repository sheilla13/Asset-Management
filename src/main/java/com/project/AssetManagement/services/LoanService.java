package com.project.AssetManagement.services;

import com.project.AssetManagement.entities.Loan;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoanService {
//    get all
    public List<Loan> findAllLoans();
}

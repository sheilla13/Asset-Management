package com.project.AssetManagement.services.impl;

import com.project.AssetManagement.entities.Loan;
import com.project.AssetManagement.repositories.LoanRepository;
import com.project.AssetManagement.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanRepository loanRepository;

    @Override
    public List<Loan> findAllLoans(){
        return loanRepository.findAll();
    }
}

package com.project.AssetManagement.services.impl;

import com.project.AssetManagement.entities.Asset;
import com.project.AssetManagement.entities.Loan;
import com.project.AssetManagement.repositories.AssetRepository;
import com.project.AssetManagement.repositories.LoanRepository;
import com.project.AssetManagement.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanRepository loanRepository;

    @Autowired
    private AssetRepository assetRepository;

    @Override
    public List<Loan> findAllLoans(){
        return loanRepository.findAll();
    }

    // get by id
    public Loan findLoanById(int id){
        return loanRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Loan tidak ditemukan"));
    }

    // save asset
    @Override
    public boolean saveLoan(Loan loan){
        Asset asset = assetRepository.findById(loan.getId()).get();
        asset.setStatus(false);
        loanRepository.save(loan);
        return loanRepository.findById(loan.getId()).isPresent();
    }

    // delete
    @Override
    public boolean deleteLoanById(int id){
        loanRepository.deleteById(id);
        return !loanRepository.findById(id).isPresent();
    }

    @Override
    // nama method diganti approve
    public boolean approve(int id) {
        Loan loan = loanRepository.findById(id).get();
        loan.setStatus("Approve");
        loanRepository.save(loan);
        return true;
    }

    @Override
    public boolean reject(int id) {
        Loan loan = loanRepository.findById(id).get();
        loan.setStatus("Reject");
        loanRepository.save(loan);
        return false;
    }
}
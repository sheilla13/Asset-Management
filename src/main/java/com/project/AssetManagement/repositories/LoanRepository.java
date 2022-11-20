package com.project.AssetManagement.repositories;

import com.project.AssetManagement.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
}

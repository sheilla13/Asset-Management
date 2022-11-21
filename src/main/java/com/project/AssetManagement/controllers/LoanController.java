package com.project.AssetManagement.controllers;

import com.project.AssetManagement.entities.Loan;
import com.project.AssetManagement.services.AssetService;
import com.project.AssetManagement.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("loan")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @Autowired
    private AssetService assetService;

    // get all
    @GetMapping
    public String loanIndex(Model model){
        model.addAttribute("loans", loanService.findAllLoans());
        return "loan/loan-index";
    }

    // add sekalian find by id (bisa buat update)
    @GetMapping(value = {"form", "form/{id}"})
    public String loanForm(@PathVariable(required = false) Integer id, Model model){
        if(id != null){
            model.addAttribute("loan", loanService.findLoanById(id));
        }
        else {
            model.addAttribute("assets", assetService.findAllAssets());
            model.addAttribute("loan", new Loan());
        }
        return "loan/loan-form";
    }

    // ketika tidak ada id nya, langsung bisa disave sebagai data baru
    @PostMapping("save")
    public String loanSave(Loan loan){
        loan.setStatus("pending");
        loan.setSubmit_date("localDateTime");
        loanService.saveLoan(loan);
        return "redirect:/loan";
    }

    // delete
    @PostMapping("delete/{id}")
    public String loanDelete(@PathVariable int id){
        loanService.deleteLoanById(id);
        return "redirect:/loan";
    }

    @PostMapping("approve/{id}")
    public String approveLoan(@PathVariable int id){
        loanService.approve(id);
        return "redirect:/loan";
    }

    @PostMapping("reject/{id}")
    public String rejectLoan(@PathVariable int id){
        loanService.reject(id);
        return "redirect:/loan";
    }
}
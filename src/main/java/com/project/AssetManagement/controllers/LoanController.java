package com.project.AssetManagement.controllers;

import com.project.AssetManagement.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("loan")
public class LoanController {
    @Autowired
    private LoanService loanService;

    // get all
    @GetMapping
    public String loanIndex(Model model){
        model.addAttribute("loans", loanService.findAllLoans());
        return "loan/loan-index";
    }
}

package com.project.AssetManagement.controllers;

import com.project.AssetManagement.services.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("asset")
public class AssetController {

    // instance object dari service
    @Autowired
    private AssetService assetService;

    // get all
    @GetMapping
    public String assetIndex(Model model){
        model.addAttribute("assets", assetService.findAllAssets());
        return "asset/asset-index";
    }
}

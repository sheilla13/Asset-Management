package com.project.AssetManagement.controllers;

import com.project.AssetManagement.entities.Asset;
import com.project.AssetManagement.services.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    // add sekalian find by id (bisa buat update)
    @GetMapping(value = {"form", "form/{id}"})
    public String assetForm(@PathVariable(required = false) Integer id, Model model){
        if(id != null){
            model.addAttribute("asset", assetService.findAssetById(id));
        }
        else {
            model.addAttribute("asset", new Asset());
        }
        return "asset/asset-form";
    }

    // ketika tidak ada id nya, langsung bisa disave sebagai data baru
    @PostMapping("save")
    public String assetSave(Asset asset){
        assetService.saveAsset(asset);
        return "redirect:/asset";
    }
}

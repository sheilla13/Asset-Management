package com.project.AssetManagement.services.impl;

import com.project.AssetManagement.entities.Asset;
import com.project.AssetManagement.repositories.AssetRepository;
import com.project.AssetManagement.services.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AssetServiceImpl implements AssetService {
    @Autowired
    private AssetRepository assetRepository;

    // get all
    @Override
    public List<Asset> findAllAssets() {
        return assetRepository.findAll();
    }

    // get by id
    public Asset findAssetById(int id){
        return assetRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Aset tidak ditemukan"));
    }

    // add
    @Override
    public boolean saveAsset(Asset asset){
        assetRepository.save(asset);
        return assetRepository.findById(asset.getId()).isPresent();
    }
}

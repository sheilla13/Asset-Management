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

    @Override
    public List<Asset> findAllAssets() {
        return assetRepository.findAll();
    }
}

package com.project.AssetManagement.services;

import com.project.AssetManagement.entities.Asset;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetService {
    public List<Asset> findAllAssets();
}

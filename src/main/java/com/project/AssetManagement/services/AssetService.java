package com.project.AssetManagement.services;

import com.project.AssetManagement.entities.Asset;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetService {
    //  get all
    public List<Asset> findAllAssets();

    // find by id
    public Asset findAssetById(int id);

    // add
    public boolean saveAsset(Asset asset);
}

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

    // save asset
    public boolean saveAsset(Asset asset);

    // delete
    public boolean deleteAssetById(int id);
}

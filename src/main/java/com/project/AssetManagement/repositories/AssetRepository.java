package com.project.AssetManagement.repositories;

import com.project.AssetManagement.entities.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssetRepository extends JpaRepository<Asset, Integer> {
}

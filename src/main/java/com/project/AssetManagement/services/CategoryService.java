package com.project.AssetManagement.services;

import com.project.AssetManagement.entities.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryService {
    public boolean saveCategory(Category category);
    public List<Category> findAllCategories();
    public Category findCategoryById(int id);
    public boolean deleteCategoryById(int id);
}

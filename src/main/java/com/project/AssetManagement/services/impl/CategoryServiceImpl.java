package com.project.AssetManagement.services.impl;

import com.project.AssetManagement.entities.Category;
import com.project.AssetManagement.repositories.CategoryRepository;
import com.project.AssetManagement.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean saveCategory(Category category) {
        categoryRepository.save(category);
        return categoryRepository.findById(category.getId()).isPresent();
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findCategoryById(int id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Category tidak ditemukan"));
    }

    @Override
    public boolean deleteCategoryById(int id) {
        categoryRepository.deleteById(id);
        return !categoryRepository.findById(id).isPresent();
    }
}

package com.example.Real_Store.service;

import com.example.Real_Store.dto.CategoryDTO;
import com.example.Real_Store.entity.Category;

import java.util.List;

public interface CategoryService {
//    CategoryDTO addCategory(CategoryDTO categoryDTO);

//    CategoryDTO updateCategory(CategoryDTO categoryDTO);
//
//    String deleteCategoryById(Long categoryId);

    List<Category> getAllCategory();

    CategoryDTO getCategoryById(Long categoryId);
}

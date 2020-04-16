package com.ea.miushop.service;

import com.ea.miushop.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategory(Long id);
    void createCategory(Category category);
}

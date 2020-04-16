package com.ea.miushop.service.impl;

import com.ea.miushop.domain.Category;
import com.ea.miushop.repository.CategoryRepository;
import com.ea.miushop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategory(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }
}

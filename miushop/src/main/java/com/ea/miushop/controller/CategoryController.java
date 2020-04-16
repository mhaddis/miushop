package com.ea.miushop.controller;

import com.ea.miushop.domain.Category;
import com.ea.miushop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping(value = "all")
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @GetMapping(value = "{categoryId}")
    public Category getCategoryById(@PathVariable Long categoryId){
        return categoryService.getCategory(categoryId);
    }

    @PostMapping(value = "new-category", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    public void createCategory(@RequestBody Category category){
        System.out.println(category);
        categoryService.createCategory(category);
    }

}

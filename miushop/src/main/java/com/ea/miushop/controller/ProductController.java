package com.ea.miushop.controller;

import com.ea.miushop.domain.Category;
import com.ea.miushop.domain.Product;
import com.ea.miushop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping(value = "all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping(value = "{productId}")
    public Product getProductById(@PathVariable Long productId){
        return productService.getProduct(productId);
    }

    @PostMapping(value = "new-product", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    public void makeProduct(@RequestBody Product product){
        productService.createProduct(product);
    }

    @GetMapping(value = "category/{categoryId}")
    public List<Product> getProductsByCategory(Category category){
        return productService.getProductsByCategory(category);
    }

}
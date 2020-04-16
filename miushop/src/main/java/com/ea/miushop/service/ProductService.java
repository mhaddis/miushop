package com.ea.miushop.service;

import com.ea.miushop.domain.Category;
import com.ea.miushop.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> getAllProducts();
    Product getProduct(Long id);
    void createProduct(Product product);
    List<Product> getProductsByCategory(Category category);
}

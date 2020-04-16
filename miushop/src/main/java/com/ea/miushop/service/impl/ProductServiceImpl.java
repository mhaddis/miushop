package com.ea.miushop.service.impl;

import com.ea.miushop.domain.Category;
import com.ea.miushop.domain.Product;
import com.ea.miushop.repository.ProductRepository;
import com.ea.miushop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {
        return productRepository.getProductsByCategory(category);
    }
}

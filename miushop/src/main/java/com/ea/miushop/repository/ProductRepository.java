package com.ea.miushop.repository;

import com.ea.miushop.domain.Category;
import com.ea.miushop.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> getProductsByCategory(Category category);
}

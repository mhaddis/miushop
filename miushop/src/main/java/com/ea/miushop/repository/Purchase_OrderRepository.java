package com.ea.miushop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ea.miushop.domain.Category;
import com.ea.miushop.domain.Order;

public interface Purchase_OrderRepository extends JpaRepository<Category, Long> {
		       
}

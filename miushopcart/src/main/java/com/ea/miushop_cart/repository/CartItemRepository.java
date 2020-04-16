package com.ea.miushop_cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ea.miushop.domain.Order;
import com.ea.miushop_cart.domain.CartItem;

import java.util.List;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}

package com.ea.miushop_cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ea.miushop_cart.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}

package com.ea.miushop_cart.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ea.miushop_cart.domain.CartItem;
import com.ea.miushop_cart.repository.CartItemRepository;
import com.ea.miushop_cart.service.CartItemService;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	CartItemRepository cartItemRepository;

	@Override
	public List<CartItem> getAllItems() {
		return cartItemRepository.findAll();
	}

	@Override
	public CartItem getCartItem(Long cartItemId) {
		return cartItemRepository.findById(cartItemId).get();
	}

	@Override
	public void saveItem(CartItem cartItem) {
		cartItemRepository.save(cartItem);
	}

}

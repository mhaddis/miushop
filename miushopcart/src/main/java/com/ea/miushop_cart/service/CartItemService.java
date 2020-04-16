package com.ea.miushop_cart.service;

import org.springframework.stereotype.Service;

import com.ea.miushop_cart.domain.CartItem;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface CartItemService {
    List<CartItem> getAllItems();
    void saveItem(CartItem cartItem);
	CartItem getCartItem(Long cartItemId);
}

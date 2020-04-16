package com.ea.miushop_cart.service;

import java.util.List;

import javax.mail.MessagingException;

import org.springframework.stereotype.Service;

import com.ea.miushop.domain.User;
import com.ea.miushop_cart.domain.Cart;
import com.ea.miushop_cart.domain.CartItem;

@Service
public interface CartService {
    Cart getCart(Long id);
    Cart createCart(Cart cart);
    Cart updateCart(Cart cart);
    Cart addToCart(CartItem cartItem, Long cartId);
	void removeItem(Long itemId);
	List<CartItem> getAllItemsInCart(Long cartId);
	CartItem getItem(Long cartId, Long itemId);
//	void checkOut(List<CartItem> cartItems) throws MessagingException;
	void checkOut(List<CartItem> cartItems, User user);
}

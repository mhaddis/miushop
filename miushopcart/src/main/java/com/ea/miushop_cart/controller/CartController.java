package com.ea.miushop_cart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ea.miushop.controller.OrderController;
import com.ea.miushop.domain.Item;
import com.ea.miushop.domain.User;
import com.ea.miushop_cart.domain.Cart;
import com.ea.miushop_cart.domain.CartItem;
import com.ea.miushop_cart.service.CartItemService;
import com.ea.miushop_cart.service.CartService;

import java.util.List;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/api/cart")
public class CartController {
	@Autowired
	CartService cartService;
	@Autowired
	CartItemService itemService;
	
	@GetMapping(value = "{cartId}")
	public Cart getCartById(@PathVariable Long cartId) {
		return cartService.getCart(cartId);
	}

	@GetMapping(value = "items/{cartId}")
	public List<CartItem> getAllItemsInCart(@PathVariable Long cartId) {
		return cartService.getAllItemsInCart(cartId);
	}

	@GetMapping(value = "itembyId/{cartId}/{itemId}")
	public CartItem getItem(@PathVariable Long cartId, @PathVariable Long cartItemId) {
		return cartService.getItem(cartId, cartItemId);
	}

	@PostMapping(value = "new-cart", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public void createCart(@RequestBody Cart cart) {
		cartService.createCart(cart);
	}

	@PostMapping(value = "update-cart", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public void updateCart(@RequestBody Cart cart) {
		cartService.createCart(cart);
	}

	@PostMapping(value = "add-item", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
	public void addItem(@RequestBody CartItem cartItem, @RequestBody Long cartId) {
		cartService.addToCart(cartItem, cartId);
	}

	@PostMapping(value = "checkout", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
//	public void sendOrder(@RequestBody List<CartItem> cartItems) throws MessagingException {
//		cartService.checkOut(cartItems);
//	}
	public void sendOrder(@RequestBody List<CartItem> cartItems, @RequestBody User user) {
		cartService.checkOut(cartItems, user);
	}
		
	@RequestMapping(method = RequestMethod.DELETE, path = "/delete/{cartItem}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void removeFromCart(@PathVariable("cartItem") Long itemId) {
		cartService.removeItem(itemId);
	}
}

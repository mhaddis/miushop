package com.ea.miushop_cart.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ea.miushop_cart.domain.CartItem;

@Component
public class BatchJob {

	@Autowired
	private CartService cartService;
	@Autowired
	private CartItemService itemService;

	private LocalDate now = LocalDate.now();
	private List<CartItem> items = itemService.getAllItems();

	@Scheduled(cron = " 0 0 12 ? * SAT * ")
	public void deleteCartItems() {
		System.out.println("Deleting item from cart...");

		for (CartItem i : items) {
			if (ChronoUnit.DAYS.between(i.getCreatedDate(), now) > 15) {
				cartService.removeItem(i.getCartItemId());
			}
		}

	}

}

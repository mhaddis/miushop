package com.ea.miushop_cart.service.impl;

import com.ea.miushop.domain.Item;
import com.ea.miushop.domain.Order;
import com.ea.miushop_cart.repository.CartItemRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.ea.miushop.domain.User;
import com.ea.miushop_cart.domain.Cart;
import com.ea.miushop_cart.domain.CartItem;
//import com.ea.miushop_cart.emailservice.EmailService;
import com.ea.miushop_cart.repository.CartRepository;
import com.ea.miushop_cart.service.CartItemService;
import com.ea.miushop_cart.service.CartService;
import com.ea.miushop_cart.service.EmailSenderService;

import javax.mail.MessagingException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;

@Service
@Transactional
public class CartServiceImpl implements CartService {
	@Autowired
	CartService cartService;
	@Autowired
	private CartRepository cartRepository;
	@Autowired
	CartItemService itemService;
	@Autowired
	CartItemRepository cartItemRepository;
	@Autowired
	private ApplicationContext context;
	@Autowired
	EmailSenderService emailsender;
//	@Autowired
//	private Item item;
//	@Autowired
//	private Order order;

	@Override
	public Cart getCart(Long id) {
		return cartRepository.findById(id).get();
	}

	@Override
	public Cart createCart(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public Cart updateCart(Cart cart) {
		return cartRepository.save(cart);
	}

	@Override
	public Cart addToCart(CartItem cartItem, Long cartId) {
		Cart cart = cartRepository.findById(cartId).get();
		cart.addItem(cartItem);
		return cartRepository.save(cart);
	}

	@Override
	public List<CartItem> getAllItemsInCart(Long cartId) {
		Cart cart = cartRepository.findById(cartId).get();
		List<CartItem> itemList = cart.getItemList();
		return itemList;
	}

	@Override
//	public void checkOut(List<CartItem> cartItems) throws MessagingException {
	public void checkOut(List<CartItem> cartItems, User user) {
		Order order = new Order();
		order.setUser(user);
//		cartItems = cartItemRepository.findAll();

		for (CartItem cartItem : cartItems) {
			Item item = new Item();
			item.setProduct(cartItem.getProduct());
			System.out.println(cartItem.getQuantity());
			item.setQuantity(cartItem.getQuantity());
			order.getItems().add(item);
		}

		RabbitTemplate makeOrderTemplate = context.getBean("makeOrderTemplate", RabbitTemplate.class);
		makeOrderTemplate.convertAndSend("make.order", order);
		System.out.println("Order sent to make order queue");

		SimpleMailMessage mailMessage = new SimpleMailMessage();

		mailMessage.setTo(user.getEmail());
		mailMessage.setSubject("Order Confirmation!");
		mailMessage.setFrom("merryhaddis@gmail.com");
		mailMessage.setText("To confirm your account, please click here ");

		emailsender.sendEmail(mailMessage);

		cartItems.clear();
	}

	@Override
	public CartItem getItem(Long cartId, Long itemId) {
		CartItem cartItem = itemService.getCartItem(itemId);
		List<CartItem> itemList = cartService.getAllItemsInCart(cartId);
		for (CartItem i : itemList) {
			if (i.getCartItemId().equals(cartItem.getCartItemId())) {
				return cartItem;
			}
		}
		return null;
	}

	@Override
	public void removeItem(Long itemId) {
		Cart cart = new Cart();
		List<CartItem> cartItems = cart.getItemList();
		for (int i = 0; i < cartItems.size(); i++) {
			if (cartItems.get(i).getCartItemId() == itemId)
				cartItems.remove(i);
		}
	}

}

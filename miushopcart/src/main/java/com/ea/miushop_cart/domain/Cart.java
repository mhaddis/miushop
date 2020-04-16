package com.ea.miushop_cart.domain;

import com.ea.miushop.domain.User;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="CART")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartid;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<CartItem> itemList;

	@OneToOne
	@JoinColumn(name = "user_id")
	User user;

	private double totalPrice;

	public Long getCartId() {
		return cartid;
	}

	public void setCartId(Long cartid) {
		this.cartid = cartid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<CartItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<CartItem> itemList) {
		this.itemList = itemList;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void addItem(CartItem cartItem) {
		if (itemList.add(cartItem)) {
			cartItem.setCart(this);
		}
	}
}
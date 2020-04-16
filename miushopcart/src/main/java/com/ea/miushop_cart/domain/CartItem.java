package com.ea.miushop_cart.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import com.ea.miushop.domain.Product;

@Entity
@Table(name = "cart_items")
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cartitemId;
	private BigDecimal price;
	@OneToOne()
	@JoinColumn(name = "product_id")
	private Product product;

	@Max(3)
	private int quantity;
	private LocalDate createdDate;
	@ManyToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;

	public CartItem() {
		createdDate= LocalDate.now();
	}
	public Long getCartItemId() {
		return cartitemId;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setItemId(Long itemId) {
		this.cartitemId = itemId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public BigDecimal getPrice() {
		return price;
	}

}
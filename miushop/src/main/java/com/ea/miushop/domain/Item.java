package com.ea.miushop.domain;

import java.math.BigDecimal;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long itemId;
	
	private BigDecimal price;
	
	@OneToOne()
	@JoinColumn(name = "product_id")
	private Product product;

	private int quantity;

	private boolean bought = false;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public Item() {
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
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

	public boolean isBought() {
		return bought;
	}

	public void setBought(boolean bought) {
		this.bought = bought;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}

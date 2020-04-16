package com.ea.miushop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "inventory")
@Entity
public class Inventory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;
	
	@OneToOne
    @JoinColumn(name = "product_id", nullable = false)
	private Product product;

	@Column(nullable = false)
	private Integer quantity;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable ( name="inventory_movement", joinColumns={@JoinColumn(name="inventory_id")},
			inverseJoinColumns={ @JoinColumn(name="storage_movement_id", unique=true)} )
	private List<StorageMovement> movements = new ArrayList<StorageMovement>();

	public Inventory() {
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public List<StorageMovement> getMovements() {
		return movements;
	}

	public void setMovements(List<StorageMovement> movements) {
		this.movements = movements;
	}
}

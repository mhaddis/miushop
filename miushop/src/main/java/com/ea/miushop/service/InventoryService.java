package com.ea.miushop.service;

import java.util.List;

import com.ea.miushop.domain.Product;
import com.ea.miushop.domain.StorageMovement;
import org.springframework.stereotype.Service;

import com.ea.miushop.domain.Inventory;

@Service
public interface InventoryService {
	List<Inventory> getAllInventory();
    Inventory getInventory(Long id);
//    List<StorageMovement> getAllMovements(Long id);
    void enterInventory(Inventory inventory);
    void updateInventory(Inventory inventory);
    Integer getInventoryQuantity(Product product);
    Inventory getInventoryByProduct(Product product);
}

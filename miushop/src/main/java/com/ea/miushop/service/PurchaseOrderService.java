package com.ea.miushop.service;

import com.ea.miushop.domain.Product;
import com.ea.miushop.domain.PurchaseOrder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PurchaseOrderService {
    List<PurchaseOrder> getAllPurchaseOrders();
    PurchaseOrder getPurchaseOrder(Long id);
    void savePurchaseOrder(PurchaseOrder purchaseOrder);
    PurchaseOrder findByProduct(Product product);
}

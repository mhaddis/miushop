package com.ea.miushop.service.impl;

import com.ea.miushop.domain.Product;
import com.ea.miushop.domain.PurchaseOrder;
import com.ea.miushop.repository.PurchaseOrderRepository;
import com.ea.miushop.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {
    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepository.findAll();
    }

    @Override
    public PurchaseOrder getPurchaseOrder(Long id) {
        return purchaseOrderRepository.getOne(id);
    }

    @Override
    public void savePurchaseOrder(PurchaseOrder purchaseOrder) {
        purchaseOrderRepository.save(purchaseOrder);
    }

    @Override
    public PurchaseOrder findByProduct(Product product) {
        return purchaseOrderRepository.findByProduct(product);
    }
}

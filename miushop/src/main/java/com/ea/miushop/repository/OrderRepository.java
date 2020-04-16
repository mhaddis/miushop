package com.ea.miushop.repository;

import com.ea.miushop.domain.Order;
import com.ea.miushop.domain.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
    public Order findByPurchaseOrders(PurchaseOrder purchaseOrder);
}

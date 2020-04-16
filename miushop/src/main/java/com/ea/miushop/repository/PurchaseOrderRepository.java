package com.ea.miushop.repository;

import com.ea.miushop.domain.Product;
import com.ea.miushop.domain.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
    public PurchaseOrder findByProduct(Product product);
}

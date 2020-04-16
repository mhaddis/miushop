package com.ea.miushop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ea.miushop.domain.Order;

public interface PurchaserRepository extends JpaRepository<Order, Long>{

}

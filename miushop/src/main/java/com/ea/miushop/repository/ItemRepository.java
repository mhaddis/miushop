package com.ea.miushop.repository;

import com.ea.miushop.domain.Item;
import com.ea.miushop.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    public List<Item> findAllByOrder(Order order);
}

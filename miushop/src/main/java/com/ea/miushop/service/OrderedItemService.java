package com.ea.miushop.service;

import com.ea.miushop.domain.Item;
import com.ea.miushop.domain.Order;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public interface OrderedItemService {
    List<Item> getAllItems();
    Item getItem(Long id);
    void saveItem(Item item);
    List<Item> findAllByOrder(Order order);
}

package com.ea.miushop.controller;

import com.ea.miushop.domain.Order;
import com.ea.miushop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(value = "all")
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping(value = "{orderId}")
    public Order getOrderById(@PathVariable Long orderId){
        return orderService.getOrder(orderId);
    }

    @PostMapping(value = "new-order", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    public void makeOrder(@RequestBody Order order){
        orderService.makeOrder(order);
    }

    @PostMapping(value = "process-order/{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    public void processOrder(@PathVariable Long id){
        orderService.processOrder(id);
    }

    @PostMapping(value = "buy-order/{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
    public void buyOrder(@PathVariable Long id){
        orderService.buyOrder(id);
    }

}

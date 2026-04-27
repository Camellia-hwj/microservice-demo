package com.demo.orderservice.controller;

import com.demo.common.entity.Product;
import com.demo.common.feign.ProductClient;
import com.demo.orderservice.entity.Order;
import com.demo.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductClient productClient;

    @PostMapping
    public Order createOrder(@RequestParam("productId") Long productId,
                             @RequestParam("quantity") Integer quantity) {
        return orderService.createOrder(productId, quantity);
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable("id") Long id) {
        return orderService.getOrderById(id);
    }

    @GetMapping("/test/{id}")
    public Product testFeign(@PathVariable("id") Long id) {
        return productClient.getProductById(id);
    }
}
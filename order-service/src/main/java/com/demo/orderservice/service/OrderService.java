package com.demo.orderservice.service;

import com.demo.common.entity.Product;
import com.demo.common.feign.ProductClient;
import com.demo.orderservice.entity.Order;
import com.demo.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductClient productClient;

    public Order createOrder(Long productId, Integer quantity) {
        Product product = productClient.getProductById(productId);
        if (product == null) {
            throw new RuntimeException("商品不存在");
        }
        if (product.getStock() < quantity) {
            throw new RuntimeException("库存不足");
        }
        Order order = new Order();
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setTotalAmount(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
        order.setStatus("PENDING");
        return orderRepository.save(order);
    }

    // 新增：根据ID查询订单
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
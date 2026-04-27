package com.demo.orderservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNo;
    private Long productId;    // 商品ID（简化，只支持单个商品）
    private Integer quantity;
    private BigDecimal totalAmount;
    private String status;     // PENDING, PAID, CANCELLED
    private LocalDateTime createTime;

    @PrePersist
    protected void onCreate() {
        createTime = LocalDateTime.now();
        if (orderNo == null) {
            orderNo = "ORD" + System.currentTimeMillis();
        }
        if (status == null) {
            status = "PENDING";
        }
    }
}
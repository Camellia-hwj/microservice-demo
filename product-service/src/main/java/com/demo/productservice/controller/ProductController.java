package com.demo.productservice.controller;

import com.demo.productservice.entity.Product;
import com.demo.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        Optional<Product> product = productRepository.findById(id);
        return product.orElse(null);
    }

    // 为了测试，可以增加一个简单的列表接口
    @GetMapping
    public Iterable<Product> list() {
        return productRepository.findAll();
    }
}
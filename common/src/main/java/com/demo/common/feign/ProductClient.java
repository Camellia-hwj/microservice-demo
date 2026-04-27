package com.demo.common.feign;

import com.demo.common.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "product-service")   // name 必须与 product-service 的应用名一致
//public interface ProductClient {
//    @GetMapping("/api/products/{id}")
//    Product getProductById(@PathVariable("id") Long id);
//}
@FeignClient(name = "product-service", url = "http://localhost:8081")
public interface ProductClient {
    @GetMapping("/api/products/{id}")
    Product getProductById(@PathVariable("id") Long id);
}
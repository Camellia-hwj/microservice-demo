## 二、微服务商城 Demo README

```markdown
# 微服务商城 Demo

基于 Spring Cloud Alibaba + Nacos + Feign + Gateway 的微服务学习 Demo，模拟商品服务与订单服务之间的远程调用，验证服务注册与发现、声明式客户端、网关路由等核心组件。

## 模块说明

| 模块 | 端口 | 说明 |
|------|------|------|
| common | - | 公共模块（实体、Feign 接口） |
| product-service | 8081 | 商品服务，提供商品 CRUD 接口 |
| order-service | 8082 | 订单服务，通过 Feign 调用商品服务 |
| gateway | 8080 | Spring Cloud Gateway，统一入口和路由 |

## 技术栈

- Spring Boot 3.2.5
- Spring Cloud Alibaba 2023.0.1.0
- Nacos 2.3.2（服务注册与发现）
- OpenFeign（声明式服务调用）
- Spring Cloud Gateway（路由网关）
- MySQL 8.0

## 快速启动

### 环境要求
- JDK 17+
- Maven 3.8+
- MySQL 8.0+
- Nacos Server 2.3.2

### 1. 启动 Nacos Server
```bash
# 下载 Nacos 2.3.2 并解压
cd nacos/bin
# Windows 单机模式启动
startup.cmd -m standalone

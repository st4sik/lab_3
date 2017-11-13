package com.project.springboot.lab.jpa;

import com.project.springboot.lab.entity.OrderEntity;

import java.util.List;

public interface OrderRepository {
    List<OrderEntity> getAllOrders();

    OrderEntity getOrderById(int orderId);

    void addOrder(OrderEntity orderEntity);

    void updateOrder(OrderEntity orderEntity);

    void deleteOrder(int orderId);
}

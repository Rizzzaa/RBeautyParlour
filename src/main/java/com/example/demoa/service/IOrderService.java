package com.example.demoa.service;

import com.example.demoa.entity.Order;

import java.util.List;

public interface IOrderService {
    String addOrder(Order order);
    String updateOrder(Integer id, Order order);
    String deleteOrder(Integer id);
    Order readOrder(Integer id);
    List<Order> readAllOrder();
}

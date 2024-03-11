package com.example.demoa.serviceimplementation;

import com.example.demoa.entity.Order;
import com.example.demoa.exception.InvalidArgumentException;
import com.example.demoa.exception.OrderNotFoundException;
import com.example.demoa.repository.OrderRepository;
import com.example.demoa.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImp implements IOrderService {
    private OrderRepository orderRepository;
    @Autowired
    public OrderServiceImp(OrderRepository orderRepository){
        this.orderRepository=orderRepository;
    }

    @Override
    public String addOrder(Order order) {
        if(order != null) {
            orderRepository.save(order);
            return "Order successful";
        }else {
            throw new InvalidArgumentException("Provided info for adding order is null");
        }
    }

    @Override
    public String updateOrder(Integer id, Order order) {
        Order orderOfId = orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
        if(order != null){
            if(order.getNoOfItems() != null){
                orderOfId.setNoOfItems(order.getNoOfItems());
            }

    //      OrderDate is final

            if(order.getAppointmentDate() != null){
                orderOfId.setAppointmentDate(order.getAppointmentDate());
            }
            if(order.getStatus() != null){
                orderOfId.setStatus(order.getStatus());
            }
            if(order.getTotalCost() != null){
                orderOfId.setTotalCost(order.getTotalCost());
            }
            if(order.getEmployeeId() != null){
                orderOfId.setEmployeeId(order.getEmployeeId());
            }
            orderRepository.save(orderOfId);
            return "Order Updated";
        }else {
            throw new InvalidArgumentException("Provided info for updating order, is null");
        }
    }


    @Override
    public String deleteOrder(Integer id) {
        if(id != null) {
            orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
            orderRepository.deleteById(id);
            return "Order Deleted";
        }else{
            throw  new InvalidArgumentException("Provided info for deleting order, is null");
        }
    }


    @Override
    public Order readOrder(Integer id) {
        return orderRepository.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    @Override
    public List<Order> readAllOrder() {
        return new ArrayList<>(orderRepository.findAll());
    }
}

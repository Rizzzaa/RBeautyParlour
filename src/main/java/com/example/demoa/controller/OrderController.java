package com.example.demoa.controller;

import com.example.demoa.entity.Order;
import com.example.demoa.serviceimplementation.OrderServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/demoa")
public class OrderController {

    private OrderServiceImp orderServiceImp;
    @Autowired
    public OrderController(OrderServiceImp orderServiceImp) {
        this.orderServiceImp = orderServiceImp;
    }

    @PostMapping("/createOrder")
        public ResponseEntity<String> createOrder(@RequestBody Order order) {
            return new ResponseEntity<>(orderServiceImp.addOrder(order), HttpStatus.OK);
        }

        @PatchMapping("/updateOrder/{orderId}")
        public ResponseEntity<String> updateOrder(@PathVariable("orderId") Integer orderId, @RequestBody Order order){
            return new ResponseEntity<>(orderServiceImp.updateOrder(orderId, order), HttpStatus.OK);
        }

        @GetMapping("/readOrder/{orderId}")
        public ResponseEntity<Order> readOrder(@PathVariable("orderId") Integer orderId){
            return new ResponseEntity<>(orderServiceImp.readOrder(orderId), HttpStatus.OK);
        }

        @GetMapping("/readAllOrder")
        public List<Order> readAllOrder(){
            return orderServiceImp.readAllOrder();
        }

        @DeleteMapping("/deleteOrder/{orderId}")
        public ResponseEntity<String> deleteOrder(@PathVariable("orderId") Integer orderId){
            return new ResponseEntity<>(orderServiceImp.deleteOrder(orderId), HttpStatus.OK);
        }

    }


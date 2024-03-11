package com.example.demoa.exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message + " not found");
    }
    public OrderNotFoundException() {
        super("Order with this id is not found");
    }
}

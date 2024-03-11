package com.example.demoa.exception;

public class CartItemNotFoundException extends RuntimeException {
    public CartItemNotFoundException(String message) {
        super(message + " not found");
    }
    public CartItemNotFoundException() {
        super("Item with this id is not found");
    }
}


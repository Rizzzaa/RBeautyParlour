package com.example.demoa.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
    public CustomerNotFoundException() {
        super("Customer with id is not found");
    }
}

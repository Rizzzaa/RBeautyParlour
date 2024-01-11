package com.example.demoa.exception;

public class AdminNotFoundException extends RuntimeException {
    public AdminNotFoundException(String message) {
        super(message);
    }
    public AdminNotFoundException() {
        super("Admin with id is not found");
    }
}

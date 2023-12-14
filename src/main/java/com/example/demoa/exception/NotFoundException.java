package com.example.demoa.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message + " not found");
    }
    public NotFoundException() {
        super("Service with id is not found");
    }
}

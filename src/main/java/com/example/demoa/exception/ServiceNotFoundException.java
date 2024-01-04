package com.example.demoa.exception;

public class ServiceNotFoundException extends RuntimeException {
    public ServiceNotFoundException(String message) {
        super(message);
    }
    public ServiceNotFoundException() {
        super("Service with id is not found");
    }
}

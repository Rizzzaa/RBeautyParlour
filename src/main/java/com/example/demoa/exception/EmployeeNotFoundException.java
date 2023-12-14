package com.example.demoa.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String message) {
        super(message);
    }
    public EmployeeNotFoundException() {
        super("Employee with id is not found");
    }
}

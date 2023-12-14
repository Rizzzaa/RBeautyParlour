package com.example.demoa.exception;

public class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String message) {
        super(message);
    }
    public AlreadyExistsException() {
        super("Already Exists");
    }
}

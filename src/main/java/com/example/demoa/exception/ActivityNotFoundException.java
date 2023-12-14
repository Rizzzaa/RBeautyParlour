package com.example.demoa.exception;

public class ActivityNotFoundException extends RuntimeException {
    public ActivityNotFoundException(String message) {
        super(message);
    }
    public ActivityNotFoundException() {
        super("Activity with id is not found");
    }
}

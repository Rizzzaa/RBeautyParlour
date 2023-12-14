package com.example.demoa.exception;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(String message) {
        super(message);
    }
    public BookingNotFoundException() {
        super("Booking is not found");
    }
}

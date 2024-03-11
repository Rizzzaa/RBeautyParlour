package com.example.demoa.exception;

public class InvalidArgumentException extends RuntimeException{

    public InvalidArgumentException() {
        super("Try Valid Arguments");
    }
    public InvalidArgumentException(String s) {
        super(s);
    }
}

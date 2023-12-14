package com.example.demoa.exception;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException(String message) {
        super(message);
    }
    public CourseNotFoundException() {
        super("Course with this id is not found");
    }
}

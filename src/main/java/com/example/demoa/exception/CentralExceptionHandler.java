package com.example.demoa.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;

@RestControllerAdvice
public class CentralExceptionHandler {
    @ExceptionHandler(ServiceNotFoundException.class)
    public ResponseEntity<String> serviceNotFoundException(ServiceNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CartItemNotFoundException.class)
    public ResponseEntity<String> cartItemNotFoundException(CartItemNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<String> orderNotFoundException(OrderNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<String> courseNotFoundException(CourseNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> customerNotFoundException(UserNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<String> employeeNotFoundException(EmployeeNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<String> bookingNotFoundException(BookingNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(InvalidArgumentException.class)
    public ResponseEntity<String> invalidArgumentException(InvalidArgumentException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> methodArgumentNotValidException(MethodArgumentNotValidException e){
        return new ResponseEntity<>(e.getBindingResult().getFieldErrors().stream().map(x -> x.getDefaultMessage()).collect(Collectors.joining(",")), HttpStatus.BAD_REQUEST);
    }



}

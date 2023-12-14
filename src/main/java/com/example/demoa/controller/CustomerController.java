package com.example.demoa.controller;

import com.example.demoa.entity.Customer;
import com.example.demoa.serviceImplementation.CustomerServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/demoa")
public class CustomerController{

        @Autowired
        private CustomerServiceImp customerServiceImp;

        @PostMapping("/createCustomer")
        public ResponseEntity<String> createCustomer(@RequestBody Customer customer) throws IOException {
            return new ResponseEntity<>(customerServiceImp.add(customer), HttpStatus.OK);
        }

        @PatchMapping("/updateCustomer/{customerId}")
        public ResponseEntity<String> updateCustomer(@PathVariable("customerId") Integer customerId, @RequestBody Customer customer){
            return new ResponseEntity<>(customerServiceImp.update(customerId, customer), HttpStatus.OK);
        }

        @GetMapping("/readCustomer/{customerId}")
        public ResponseEntity<Customer> readCustomer(@PathVariable("customerId") Integer customerId){
            return new ResponseEntity<>(customerServiceImp.read(customerId), HttpStatus.OK);
        }

        @GetMapping("/readAllCustomer")
        public List<Customer> readAllCustomer(){
            return customerServiceImp.readAll();
        }

        @DeleteMapping("/deleteCustomer/{customerId}")
        public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") Integer customerId){
            return new ResponseEntity<>(customerServiceImp.delete(customerId), HttpStatus.OK);
        }

    }


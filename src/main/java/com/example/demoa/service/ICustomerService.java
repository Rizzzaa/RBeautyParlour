package com.example.demoa.service;

import com.example.demoa.entity.Customer;

import java.util.List;

public interface ICustomerService {
    public String add(Customer customer);
    public String update(Integer id, Customer customer);
    public String delete(Integer id);
    public Customer read(Integer id);
    public List<Customer> readAll();
}

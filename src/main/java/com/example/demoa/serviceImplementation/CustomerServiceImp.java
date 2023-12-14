package com.example.demoa.serviceImplementation;

import com.example.demoa.entity.Customer;
import com.example.demoa.exception.CustomerNotFoundException;
import com.example.demoa.repository.CustomerRepository;
import com.example.demoa.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImp implements ICustomerService {
    @Autowired
    private CustomerRepository iCustomerRepository;

    @Override
    public String add(Customer customer) {
        iCustomerRepository.save(customer);
        return "Customer added successfully";
    }

    @Override
    public String update(Integer id, Customer customer) {
        Customer customerOfId = iCustomerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
        if(customer.getCustomerEmail() != null){
            customerOfId.setCustomerEmail(customer.getCustomerEmail());
        }
        if(customer.getCustomerName() != null){
            customerOfId.setCustomerName(customer.getCustomerName());
        }
        if(customer.getCustomerPassword() != null){
            customerOfId.setCustomerPassword(customer.getCustomerPassword());
        }
//        if(customer.getCustomerRole() != null){
//            customerOfId.setCustomerRole(customer.getCustomerRole());
//        }
        iCustomerRepository.save(customerOfId);
        return "Customer Updated";
    }


    @Override
    public String delete(Integer id) {
        iCustomerRepository.findById(id).orElseThrow(()->new CustomerNotFoundException("Customer with id= "+id+" is not found"));
        iCustomerRepository.deleteById(id);
        return "Customer Deleted";
    }

    @Override
    public Customer read(Integer id) {
        return iCustomerRepository.findById(id).orElseThrow(CustomerNotFoundException::new);
    }


    @Override
    public List<Customer> readAll() {
        return new ArrayList<>(iCustomerRepository.findAll());
    }
}

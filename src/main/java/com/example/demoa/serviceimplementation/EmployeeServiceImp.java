package com.example.demoa.serviceimplementation;


import com.example.demoa.entity.admin.Employee;
import com.example.demoa.exception.EmployeeNotFoundException;
import com.example.demoa.exception.InvalidArgumentException;
import com.example.demoa.repository.EmployeeRepository;
import com.example.demoa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public String addEmployee(Employee employee) {
        if(employee != null) {
            employeeRepository.save(employee);
            return "Employee Added";
        }else {
            throw new InvalidArgumentException("Provided info for adding employee is null");
        }
    }

    @Override
    public String updateEmployee(Integer id, Employee employee) {
        if(employee != null) {
        Employee employeeOfId = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);

        if(employee.getEmployeeName() != null){
            employeeOfId.setEmployeeName(employee.getEmployeeName());
        }
        if(employee.getSpeciality() != null){
            employeeOfId.setSpeciality(employee.getSpeciality());
        }
        if(employee.getAvailability() != null){
            employeeOfId.setAvailability(employee.getAvailability());
        }
        if(employee.getSlot() != null){
            employeeOfId.setSlot(employee.getSlot());
        }
        employeeRepository.save(employeeOfId);
        return "Employee Updated";
    }else {
        throw new InvalidArgumentException("Provided info for updating employee is null");
    }
    }


    @Override
    public String deleteEmployee(Integer id) throws EmployeeNotFoundException{
        employeeRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Employee with id= " + id + " is not found"));
        employeeRepository.deleteById(id);
        return "Employee Deleted";
    }

    @Override
    public Employee readEmployee(Integer id) throws EmployeeNotFoundException{
        return employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
    }


    @Override
    public List<Employee> readAllEmployee() {
        return new ArrayList<>(employeeRepository.findAll());
    }
}

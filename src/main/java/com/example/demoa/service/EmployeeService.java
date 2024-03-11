package com.example.demoa.service;


import com.example.demoa.entity.admin.Employee;

import java.util.List;

public interface EmployeeService {
    String addEmployee(Employee employee);
    String updateEmployee(Integer id, Employee employee);
    String deleteEmployee(Integer id);
    Employee readEmployee(Integer id);
    List<Employee> readAllEmployee();

}

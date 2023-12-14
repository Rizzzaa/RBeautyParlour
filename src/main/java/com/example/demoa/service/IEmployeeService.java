package com.example.demoa.service;


import com.example.demoa.entity.Employee;
import com.example.demoa.enums.Category;

import java.util.List;

public interface IEmployeeService {
    public String addEmployee(Employee employee);
    public String updateEmployee(Integer id, Employee employee);
    public String deleteEmployee(Integer id);
    public Employee readEmployee(Integer id);
    public List<Employee> readAllEmployee();
    public List<Employee> readEmployeeBySpeciality(Category category);

}

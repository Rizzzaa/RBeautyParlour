package com.example.demoa.repository;


import com.example.demoa.entity.Employee;
import com.example.demoa.enums.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    public List<Employee> findBySpeciality(Category speciality);
}

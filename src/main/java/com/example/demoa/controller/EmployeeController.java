package com.example.demoa.controller;

import com.example.demoa.entity.Employee;
import com.example.demoa.enums.Category;
import com.example.demoa.serviceImplementation.EmployeeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/demoa")
public class EmployeeController {


    @Autowired
    private EmployeeServiceImp employeeServiceImp;


    @PostMapping("/createEmployee")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeServiceImp.addEmployee(employee), HttpStatus.OK);
    }

        @PatchMapping("/updateEmployee/{employeeId}")
        public ResponseEntity<String> updateEmployee(@PathVariable("employeeId") Integer employeeId, @RequestBody Employee employee){
            return new ResponseEntity<>(employeeServiceImp.updateEmployee(employeeId, employee), HttpStatus.OK);
        }

    @DeleteMapping("/deleteEmployee/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") Integer employeeId) {
        return new ResponseEntity<>(employeeServiceImp.deleteEmployee(employeeId), HttpStatus.OK);
    }

    @GetMapping(value = "/readEmployee/{employeeId}")
    public ResponseEntity<?> readEmployee(@PathVariable("employeeId") Integer employeeId) {
        return new ResponseEntity<>(employeeServiceImp.readEmployee(employeeId), HttpStatus.OK);
    }

    @GetMapping("/readEmployeeBySpeciality/{speciality}")
    public List<Employee> readBySpeciality(@PathVariable("speciality") Category speciality){
        return employeeServiceImp.readEmployeeBySpeciality(speciality);
    }

    @GetMapping("/readAllEmployee")
    public List<Employee> readAllCourse(){
            return employeeServiceImp.readAllEmployee();
        }

}

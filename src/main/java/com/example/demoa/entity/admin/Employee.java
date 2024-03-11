package com.example.demoa.entity.admin;

import com.example.demoa.enums.Availability;
import com.example.demoa.enums.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeId;
    private String employeeName;
    private Category speciality;
    private Availability availability;
    private LocalDate slot;

    public Employee() {
    }

    public Employee(String employeeName, Category speciality, Availability availability) {
        this.employeeName = employeeName;
        this.speciality = speciality;
        this.availability = availability;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Category getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Category speciality) {
        this.speciality = speciality;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

    public LocalDate getSlot() {
        return slot;
    }

    public void setSlot(LocalDate slot) {
        this.slot = slot;
    }
}

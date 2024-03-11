package com.example.demoa.entity;

import com.example.demoa.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer noOfItems;
    private final LocalDate orderDate = LocalDate.now();
    private LocalDate appointmentDate;
    private Status status;
    private Double totalCost;
    private Integer employeeId;

    public Integer getId() {
        return id;
    }

    public Order() {}
    public Order( Integer noOfItems, LocalDate appointmentDate, Status status, Double totalCost, Integer employeeId) {
        this.noOfItems = noOfItems;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.totalCost = totalCost;
        this.employeeId = employeeId;
    }

    public Order(Integer id, Integer noOfItems, LocalDate appointmentDate, Status status, Double totalCost, Integer employeeId) {
        this.id = id;
        this.noOfItems = noOfItems;
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.totalCost = totalCost;
        this.employeeId = employeeId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(Integer noOfItems) {
        this.noOfItems = noOfItems;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
}

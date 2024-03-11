package com.example.demoa.entity.user;

import com.example.demoa.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class CourseBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer courseId;
    private final LocalDate bookingDate = LocalDate.now();
    private LocalDate completionDate;

    private Status status;
    private LocalDate slot;
    private Integer employeeId;
    private Double totalCost;
    private Integer customerId;


    public CourseBooking() {
    }

    public CourseBooking(Integer courseId, LocalDate slot, Double totalCost) {
        this.courseId = courseId;
        this.slot = slot;
        this.totalCost = totalCost;
    }

    public CourseBooking(LocalDate completionDate, Status status, Integer employeeId, Double totalCost) {
        this.completionDate = completionDate;
        this.status = status;
        this.employeeId = employeeId;
        this.totalCost = totalCost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }


    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {

        this.completionDate = completionDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getSlot() {
        return slot;
    }

    public void setSlot(LocalDate slot) {
        this.slot = slot;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}

package com.example.demoa.entity.user;

import com.example.demoa.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ServiceBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    [ONE SERVICE BOOKING CAN HAVE MANY SERVIES]
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "serviceId")
    private Integer serviceId;
    private final LocalDate bookingDate = LocalDate.now();
    private LocalDate appointmentDate;
    private Status status;
    private Double totalCost;
    private Integer employeeId;
    private Integer customerId;

    public ServiceBooking() {
    }

    public ServiceBooking( LocalDate appointmentDate, Status status, Double totalCost, Integer employeeId, Integer customerId) {
        this.appointmentDate = appointmentDate;
        this.status = status;
        this.totalCost = totalCost;
        this.employeeId = employeeId;
        this.customerId = customerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
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

        System.currentTimeMillis();

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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}

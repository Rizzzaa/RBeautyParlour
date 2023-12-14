package com.example.demoa.entity;

import com.example.demoa.enums.Status;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class ServiceBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    [ONE ACTIVITY BOOKING CAN HAVE MANY ACTIVITIES]
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "serviceId")
    private Integer serviceId;
    private final LocalDate bookingDate = LocalDate.now();
    private LocalDate appointmentDate;
    private Status status;
    private Double totalCost;
    private Integer employeeId;
    private Integer customerId;

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

//    public void setBookingDate(LocalDate bookingDate) {
//        this.bookingDate = bookingDate;
//    }

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

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}

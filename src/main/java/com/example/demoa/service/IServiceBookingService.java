package com.example.demoa.service;


import com.example.demoa.entity.user.ServiceBooking;

import java.util.List;

public interface IServiceBookingService {
    String addServiceBooking(ServiceBooking serviceBooking);
    String updateServiceBooking(Integer id, ServiceBooking serviceBooking);
    String cancelServiceBooking(Integer id);
    ServiceBooking readServiceBooking(Integer id);
    List<ServiceBooking> readAllServiceBooking();

}

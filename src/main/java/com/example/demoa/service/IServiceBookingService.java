package com.example.demoa.service;


import com.example.demoa.entity.ServiceBooking;

import java.util.List;

public interface IServiceBookingService {
    public String addServiceBooking(ServiceBooking serviceBooking);
    public String updateServiceBooking(Integer id, ServiceBooking serviceBooking);
    public String cancelServiceBooking(Integer id);
//    public String deleteActivityBooking(Integer id);
    public ServiceBooking readServiceBooking(Integer id);
    public List<ServiceBooking> readAllServiceBooking();

}

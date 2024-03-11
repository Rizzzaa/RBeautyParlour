package com.example.demoa.service;

import com.example.demoa.entity.admin.Service;

import java.util.List;

public interface IServicesService {
    String addService(Service service);
    String updateService(Integer id, Service service);
    String deleteService(Integer id);
    Service readService(Integer id);
    List<Service> readAllService();

}

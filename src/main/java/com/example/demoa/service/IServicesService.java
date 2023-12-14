package com.example.demoa.service;

import com.example.demoa.entity.Service;

import java.util.List;

public interface IServicesService {
    public String addService(Service service);
    public String updateService(Integer id, Service service);
    public String deleteService(Integer id);
    public Service readService(Integer id);
    public List<Service> readAllService();

}

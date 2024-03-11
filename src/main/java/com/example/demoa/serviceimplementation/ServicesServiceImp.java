package com.example.demoa.serviceimplementation;

import com.example.demoa.entity.admin.Service;
import com.example.demoa.exception.InvalidArgumentException;
import com.example.demoa.exception.ServiceNotFoundException;
import com.example.demoa.repository.ServiceRepository;
import com.example.demoa.service.IServicesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ServicesServiceImp implements IServicesService {

    private ServiceRepository iServiceRepository;
    @Autowired
    public ServicesServiceImp(ServiceRepository iServiceRepository) {
        this.iServiceRepository = iServiceRepository;
    }

    @Override
    public String addService(Service service) {
        if(service !=null) {
            iServiceRepository.save(service);
            return "Service Added";
        }else{
            throw new InvalidArgumentException("Provided info for adding service is null");
        }
    }

    @Override
    public String updateService(Integer id, Service service){
        if(service !=null) {
        Service serviceOfId = iServiceRepository.findById(id).orElseThrow(ServiceNotFoundException::new);


        if(service.getServiceName() != null){
            serviceOfId.setServiceName(service.getServiceName());
        }

    //  UPDATE FOR COMPANY HERE

        if(service.getCategory() != null){
            serviceOfId.setCategory(service.getCategory());
        }
        if(service.getServiceCost() != null){
            serviceOfId.setServiceCost(service.getServiceCost());
        }

        iServiceRepository.save(serviceOfId);
        return "Service Updated";
    }else{
        throw new InvalidArgumentException("Provided info for updating service is null");
    }
    }

    @Override
    public String deleteService(Integer id) throws ServiceNotFoundException {
        iServiceRepository.findById(id).orElseThrow(()->new ServiceNotFoundException("Service with id= " + id + " is not found"));
        iServiceRepository.deleteById(id);
        return "Service Deleted";
    }

    @Override
    public Service readService(Integer id) throws ServiceNotFoundException {
        return iServiceRepository.findById(id).orElseThrow(ServiceNotFoundException::new);
    }


    @Override
    public List<Service> readAllService() {
        return new ArrayList<>(iServiceRepository.findAll());
    }


}

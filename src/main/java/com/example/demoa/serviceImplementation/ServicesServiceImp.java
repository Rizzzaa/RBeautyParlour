package com.example.demoa.serviceImplementation;

import com.example.demoa.entity.Service;
import com.example.demoa.exception.ServiceNotFoundException;
import com.example.demoa.repository.ServiceRepository;
import com.example.demoa.service.IServicesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Service
public class ServicesServiceImp implements IServicesService {
    @Autowired
    private ServiceRepository iServiceRepository;

    @Override
    public String addService(Service service) {
        iServiceRepository.save(service);
        return "Service added successfully";
    }

    @Override
    public String updateService(Integer id, Service service){
//        List<Service> activityList = new ArrayList<>(iServiceRepository.findAll());
        Service serviceOfId = iServiceRepository.findById(id).orElseThrow(ServiceNotFoundException::new);

//        if(service.getActivityName() != null){
//            int i=0;
//            while(i < activityList.size()){
//                if(!Objects.equals(activityList.get(i).getActivityName(), service.getActivityName())){
//                    i++;
//                    if(i == activityList.size()){
//                        serviceOfId.setActivityName(service.getActivityName());
//                    }
//                }else {
//                    throw new AlreadyExistsException(service.getActivityName());
//                }
//            }
//        }


        if(service.getServiceName() != null){
            serviceOfId.setServiceName(service.getServiceName());
        }
        if(service.getCategory() != null){
            serviceOfId.setCategory(service.getCategory());
        }
        if(service.getServiceCost() != null){
            serviceOfId.setServiceCost(service.getServiceCost());
        }

        iServiceRepository.save(serviceOfId);
        return "Service Updated";
    }


    @Override
    public String deleteService(Integer id) throws ServiceNotFoundException {
        iServiceRepository.findById(id).orElseThrow(()->new ServiceNotFoundException("Service with id= " + id + " is not found"));
        iServiceRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public Service readService(Integer id) throws ServiceNotFoundException {
        return iServiceRepository.findById(id).orElseThrow(ServiceNotFoundException::new);
    }


    @Override
    public List<Service> readAllService() {
        return new ArrayList<>(iServiceRepository.findAll());
    }


//    public Service readByName(String name){
//
//    }
}

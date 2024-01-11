package com.example.demoa.serviceimplementation;

import com.example.demoa.entity.ServiceBooking;
import com.example.demoa.enums.Status;
import com.example.demoa.exception.BookingNotFoundException;
import com.example.demoa.repository.ServiceBookingRepository;
import com.example.demoa.repository.ServiceRepository;
import com.example.demoa.service.IServiceBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceBookingServiceImp implements IServiceBookingService {

    ServiceBookingRepository serviceBookingRepository;

    ServiceRepository serviceRepository;
    @Autowired
    public ServiceBookingServiceImp(ServiceBookingRepository serviceBookingRepository) {
        this.serviceBookingRepository = serviceBookingRepository;
    }
    public ServiceBookingServiceImp(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public String addServiceBooking(ServiceBooking serviceBooking) {
        serviceBookingRepository.save(serviceBooking);
        return "Booked Service";
    }

    @Override
    public String updateServiceBooking(Integer id, ServiceBooking serviceBooking) {
        ServiceBooking serviceBookingOfId = serviceBookingRepository.findById(id).orElseThrow(BookingNotFoundException::new);
        if(serviceBooking.getServiceId() != null){
            serviceBookingOfId.setServiceId(serviceBooking.getServiceId());
        }

//        BOOKING DATE CANNOT BE UPDATED

        if(serviceBooking.getAppointmentDate() != null && serviceBooking.getAppointmentDate().isAfter(LocalDate.now())){
            serviceBookingOfId.setAppointmentDate(serviceBooking.getAppointmentDate());
        }
        if(serviceBooking.getStatus() == null){
            if(LocalDate.now().isAfter(serviceBooking.getBookingDate()) && LocalDate.now().isBefore(serviceBooking.getAppointmentDate())){
                serviceBookingOfId.setStatus(Status.BOOKED);

            }
            else if(LocalDate.now().isAfter(serviceBooking.getAppointmentDate())){
                serviceBookingOfId.setStatus(Status.SERVED);
            }
        }else{
            serviceBookingOfId.setStatus(serviceBooking.getStatus());
        }
        if(serviceBooking.getTotalCost() != null){
            serviceBookingOfId.setTotalCost(serviceBooking.getTotalCost());
        }
        if(serviceBooking.getEmployeeId() != null){
            serviceBookingOfId.setEmployeeId(serviceBooking.getEmployeeId());
        }
        if(serviceBooking.getCustomerId() != null){
            serviceBookingOfId.setCustomerId(serviceBooking.getCustomerId());
        }
        serviceBookingRepository.save(serviceBookingOfId);
        return "Booking Updated";
    }

    public String cancelServiceBooking(Integer id){
        ServiceBooking serviceBookingOfId = serviceBookingRepository.findById(id).orElseThrow(BookingNotFoundException::new);
        serviceBookingOfId.setStatus(Status.CANCELLED);
        serviceBookingRepository.save(serviceBookingOfId);
        return "Booking Cancelled";
    }

    @Override
    public ServiceBooking readServiceBooking(Integer id) {
        return serviceBookingRepository.findById(id).orElseThrow(BookingNotFoundException::new);
    }

    @Override
    public List<ServiceBooking> readAllServiceBooking() {
        return new ArrayList<>(serviceBookingRepository.findAll());
    }
}

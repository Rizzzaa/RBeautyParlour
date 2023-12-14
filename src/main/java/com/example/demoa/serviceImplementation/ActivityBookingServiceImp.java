package com.example.demoa.serviceImplementation;

import com.example.demoa.entity.Activity;
import com.example.demoa.entity.ActivityBooking;
import com.example.demoa.enums.Status;
import com.example.demoa.exception.ActivityNotFoundException;
import com.example.demoa.exception.BookingNotFoundException;
import com.example.demoa.exception.NotFoundException;
import com.example.demoa.repository.ActivityBookingRepository;
import com.example.demoa.repository.ActivityRepository;
import com.example.demoa.service.IActivityBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ActivityBookingServiceImp implements IActivityBookingService {
    @Autowired
    ActivityBookingRepository activityBookingRepository;
    @Autowired
    ActivityRepository activityRepository;


    @Override
    public String addActivityBooking(ActivityBooking activityBooking) {
//        Activity activityOfId = activityRepository.findById(activityBooking.getActivityId()).orElseThrow(() -> new NotFoundException("Activity"));
        activityBookingRepository.save(activityBooking);
        return "Booked Activity";
    }

    @Override
    public String updateActivityBooking(Integer id, ActivityBooking activityBooking) {
        ActivityBooking activityBookingOfId = activityBookingRepository.findById(id).orElseThrow(BookingNotFoundException::new);
        if(activityBooking.getActivityId() != null){
            activityBookingOfId.setActivityId(activityBooking.getActivityId());
        }

//        BOOKING DATE CANNOT BE UPDATED

        if(activityBooking.getAppointmentDate() != null && activityBooking.getAppointmentDate().isAfter(LocalDate.now())){
            activityBookingOfId.setAppointmentDate(activityBooking.getAppointmentDate());
        }
        if(activityBooking.getStatus() == null){
            if(LocalDate.now().isAfter(activityBooking.getBookingDate()) && LocalDate.now().isBefore(activityBooking.getAppointmentDate())){
                activityBookingOfId.setStatus(Status.BOOKED);

            }
            else if(LocalDate.now().isAfter(activityBooking.getAppointmentDate())){
                activityBookingOfId.setStatus(Status.SERVED);
            }
        }else{
            activityBookingOfId.setStatus(activityBooking.getStatus());
        }
        if(activityBooking.getTotalCost() != null){
            activityBookingOfId.setTotalCost(activityBooking.getTotalCost());
        }
        if(activityBooking.getEmployeeId() != null){
            activityBookingOfId.setEmployeeId(activityBooking.getEmployeeId());
        }
        if(activityBooking.getCustomerId() != null){
            activityBookingOfId.setCustomerId(activityBooking.getCustomerId());
        }
        activityBookingRepository.save(activityBookingOfId);
        return "Booking Updated";
    }

    public String cancelActivityBooking(Integer id){
        ActivityBooking activityBookingOfId = activityBookingRepository.findById(id).orElseThrow(BookingNotFoundException::new);
        activityBookingOfId.setStatus(Status.CANCELLED);
        activityBookingRepository.save(activityBookingOfId);
        return "Booking Cancelled";
    }

    @Override
    public ActivityBooking readActivityBooking(Integer id) {
        return activityBookingRepository.findById(id).orElseThrow(BookingNotFoundException::new);
    }

    @Override
    public List<ActivityBooking> readAllActivityBooking() {
        return new ArrayList<>(activityBookingRepository.findAll());
    }
}

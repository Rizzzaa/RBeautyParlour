package com.example.demoa.serviceimplementation;


import com.example.demoa.entity.Course;
import com.example.demoa.entity.CourseBooking;
import com.example.demoa.entity.Employee;
import com.example.demoa.enums.Availability;
import com.example.demoa.enums.Status;
import com.example.demoa.exception.BookingNotFoundException;
import com.example.demoa.repository.CourseBookingRepository;
import com.example.demoa.service.ICourseBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseBookingServiceImp implements ICourseBookingService {


    CourseBookingRepository courseBookingRepository;
    EmployeeServiceImp employeeServiceImp;
    CourseServiceImp courseServiceImp;


    @Autowired
    public CourseBookingServiceImp(CourseBookingRepository courseBookingRepository) {
        this.courseBookingRepository = courseBookingRepository;
    }

    public CourseBookingServiceImp(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }


    public CourseBookingServiceImp(CourseServiceImp courseServiceImp) {
        this.courseServiceImp = courseServiceImp;
    }




    @Override
    public String addCourseBooking(CourseBooking courseBooking) {

        Course course1 = courseServiceImp.read(courseBooking.getCourseId());
        List<Employee> employeeList = new ArrayList<>(employeeServiceImp.readAllEmployee());

//        COMPLETIONDATE SETTING
            courseBooking.setCompletionDate(courseBooking.getBookingDate().plusMonths(course1.getDuration()));

//        STATUS SETTING
            if(LocalDate.now().equals(courseBooking.getBookingDate()) || (LocalDate.now().isAfter(courseBooking.getBookingDate()) && LocalDate.now().isBefore(courseBooking.getCompletionDate()))){
                courseBooking.setStatus(Status.ENROLLED);
            }else if(LocalDate.now().isAfter(courseBooking.getCompletionDate())){
                courseBooking.setStatus(Status.COMPLETED);
            }else {
            courseBooking.setStatus(courseBooking.getStatus());
            }

//        SLOT, AVAILABILITY, EMPLOYEEID SETTING
        for (Employee value : employeeList) {
            if (value.getSpeciality() == course1.getCategory()) {
                if (value.getAvailability() == Availability.FREE) {
                    value.setSlot(courseBooking.getSlot());
                    value.setAvailability(Availability.BUSY);
                    courseBooking.setEmployeeId(value.getEmployeeId());
                    break;
                }else {
                    courseBookingRepository.save(courseBooking);
                    return "Course Enrolled! Will let you know the slots soon";
                }
            }
        }

//        YET TO DO CUSTOMERID

        courseBookingRepository.save(courseBooking);
        return "Booked Course";
    }

    @Override
    public String updateCourseBooking(Integer id, CourseBooking courseBooking) {
        CourseBooking courseBookingOfId = courseBookingRepository.findById(id).orElseThrow(BookingNotFoundException::new);

        if(courseBooking.getCourseId() != null){
            courseBookingOfId.setCourseId(courseBooking.getCourseId());
        }
        if(courseBooking.getCompletionDate() != null && courseBooking.getCompletionDate().isAfter(courseBooking.getBookingDate())){
            courseBookingOfId.setCompletionDate(courseBooking.getCompletionDate());
        }
        if(courseBooking.getStatus() == null){
            if(LocalDate.now().isAfter(courseBooking.getBookingDate()) && LocalDate.now().isBefore(courseBooking.getCompletionDate())){
                courseBookingOfId.setStatus(Status.ENROLLED);
            }
            else if(LocalDate.now().isAfter(courseBooking.getCompletionDate())){
                courseBookingOfId.setStatus(Status.COMPLETED);
            }
        }else {
            courseBookingOfId.setStatus(courseBooking.getStatus());
        }
        if(courseBooking.getEmployeeId() != null){
            courseBookingOfId.setEmployeeId(courseBooking.getEmployeeId());
        }
        if(courseBooking.getTotalCost() != null){
            courseBookingOfId.setTotalCost(courseBooking.getTotalCost());
        }
        if(courseBooking.getCustomerId() != null){
            courseBookingOfId.setCustomerId(courseBooking.getCustomerId());
        }
        courseBookingRepository.save(courseBookingOfId);

        return "Updated Booking";
    }

    @Override
    public String cancelCourseBooking(Integer id) {
        CourseBooking courseBookingOfId = courseBookingRepository.findById(id).orElseThrow(BookingNotFoundException::new);
        courseBookingOfId.setStatus(Status.CANCELLED);
        courseBookingRepository.save(courseBookingOfId);

        return "Booking Deleted";
    }

    @Override
    public CourseBooking readCourseBooking(Integer id) {
        return courseBookingRepository.findById(id).orElseThrow(BookingNotFoundException::new);
    }

    @Override
    public List<CourseBooking> readAllCourseBooking() {
        return new ArrayList<>(courseBookingRepository.findAll());
    }
}

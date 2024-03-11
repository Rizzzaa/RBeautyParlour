package com.example.demoa.serviceimplementation;


import com.example.demoa.entity.admin.Course;
import com.example.demoa.entity.user.CourseBooking;
import com.example.demoa.entity.admin.Employee;
import com.example.demoa.enums.Availability;
import com.example.demoa.enums.Status;
import com.example.demoa.exception.BookingNotFoundException;
import com.example.demoa.exception.InvalidArgumentException;
import com.example.demoa.repository.CourseBookingRepository;
import com.example.demoa.service.ICourseBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseBookingServiceImp implements ICourseBookingService {


    private CourseBookingRepository courseBookingRepository;
    private EmployeeServiceImp employeeServiceImp;
    private CourseServiceImp courseServiceImp;


    @Autowired
    public CourseBookingServiceImp(CourseBookingRepository courseBookingRepository, EmployeeServiceImp employeeServiceImp, CourseServiceImp courseServiceImp) {
        this.courseBookingRepository = courseBookingRepository;
        this.employeeServiceImp = employeeServiceImp;
        this.courseServiceImp = courseServiceImp;
    }


    @Override
    public String addCourseBooking(CourseBooking courseBooking) {
        if(courseBooking != null) {

            Course course1 = courseServiceImp.read(courseBooking.getCourseId());
            System.out.println(courseBooking.getCourseId());
            List<Employee> employeeList = new ArrayList<>(employeeServiceImp.readAllEmployee());

//        COMPLETIONDATE SETTING
            courseBooking.setCompletionDate(courseBooking.getBookingDate().plusMonths(course1.getDuration()));

//        STATUS SETTING
            if (LocalDate.now().equals(courseBooking.getBookingDate()) || (LocalDate.now().isAfter(courseBooking.getBookingDate()) && LocalDate.now().isBefore(courseBooking.getCompletionDate()))) {
                courseBooking.setStatus(Status.ENROLLED);
            } else if (LocalDate.now().isAfter(courseBooking.getCompletionDate())) {
                courseBooking.setStatus(Status.COMPLETED);
            } else {
                courseBooking.setStatus(courseBooking.getStatus());
            }

//        SLOT, AVAILABILITY, EMPLOYEEID OF EMPLOYEE SETTING
            for (Employee value : employeeList) {
                if (value.getSpeciality() == course1.getCategory()) {
                    if (value.getAvailability() == Availability.FREE) {
                        value.setSlot(courseBooking.getSlot());
                        value.setAvailability(Availability.BUSY);
                        courseBooking.setEmployeeId(value.getEmployeeId());
                        break;
                    } else {
                        courseBookingRepository.save(courseBooking);
                        return "Course Enrolled! Will let you know the slots soon";
                    }
                }
            }

//        YET TO DO CUSTOMERID

            courseBookingRepository.save(courseBooking);
            return "Course Booked";

        }else {
            throw new InvalidArgumentException("Provided info for adding employee is null");
        }
    }

    @Override
    public String updateCourseBooking(Integer id, CourseBooking courseBooking) {
        if(courseBooking != null) {
        CourseBooking courseBookingOfId = courseBookingRepository.findById(id).orElseThrow(BookingNotFoundException::new);

        if (courseBooking.getCourseId() != null) {
            courseBookingOfId.setCourseId(courseBooking.getCourseId());
        }
        if (courseBooking.getCompletionDate() != null && courseBooking.getCompletionDate().isAfter(courseBooking.getBookingDate())) {
            courseBookingOfId.setCompletionDate(courseBooking.getCompletionDate());
        }
        if (courseBooking.getStatus() == null) {
            if (LocalDate.now().isAfter(courseBooking.getBookingDate()) && LocalDate.now().isBefore(courseBooking.getCompletionDate())) {
                courseBookingOfId.setStatus(Status.ENROLLED);
            } else if (LocalDate.now().isAfter(courseBooking.getCompletionDate())) {
                courseBookingOfId.setStatus(Status.COMPLETED);
            }
        } else {
            courseBookingOfId.setStatus(courseBooking.getStatus());
        }
        if (courseBooking.getEmployeeId() != null) {
            courseBookingOfId.setEmployeeId(courseBooking.getEmployeeId());
        }
        if (courseBooking.getTotalCost() != null) {
            courseBookingOfId.setTotalCost(courseBooking.getTotalCost());
        }
        if (courseBooking.getCustomerId() != null) {
            courseBookingOfId.setCustomerId(courseBooking.getCustomerId());
        }
        courseBookingRepository.save(courseBookingOfId);

        return "Booking Updated";
    }else {
        throw new InvalidArgumentException("Provided info for adding employee is null");
    }
    }

    @Override
    public String cancelCourseBooking(Integer id) {
        CourseBooking courseBookingOfId = courseBookingRepository.findById(id).orElseThrow(BookingNotFoundException::new);
        courseBookingOfId.setStatus(Status.CANCELLED);
        courseBookingRepository.save(courseBookingOfId);

        return "Booking Canceled";
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

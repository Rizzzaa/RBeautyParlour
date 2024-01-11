package com.example.demoa.service;

import com.example.demoa.entity.CourseBooking;

import java.util.List;

public interface ICourseBookingService {
    String addCourseBooking(CourseBooking courseBooking);
    String updateCourseBooking(Integer id, CourseBooking courseBooking);
    String cancelCourseBooking(Integer id);
    CourseBooking readCourseBooking(Integer id);
    List<CourseBooking> readAllCourseBooking();

}

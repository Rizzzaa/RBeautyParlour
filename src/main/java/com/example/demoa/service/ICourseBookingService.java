package com.example.demoa.service;

import com.example.demoa.entity.CourseBooking;

import java.util.List;

public interface ICourseBookingService {
    public String addCourseBooking(CourseBooking courseBooking);
    public String updateCourseBooking(Integer id, CourseBooking courseBooking);
    public String cancelCourseBooking(Integer id);
    public CourseBooking readCourseBooking(Integer id);
    public List<CourseBooking> readAllCourseBooking();

}

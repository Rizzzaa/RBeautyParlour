package com.example.demoa.controller;


import com.example.demoa.entity.CourseBooking;
import com.example.demoa.serviceimplementation.CourseBookingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/demoa")
public class CourseBookingController {


    private CourseBookingServiceImp courseBookingServiceImp;

    @Autowired
    public CourseBookingController(CourseBookingServiceImp courseBookingServiceImp) {
        this.courseBookingServiceImp = courseBookingServiceImp;
    }

    @PostMapping("/createCourseBooking")
    public ResponseEntity<String> createCourseBooking(@RequestBody CourseBooking courseBooking) {
        return new ResponseEntity<>(courseBookingServiceImp.addCourseBooking(courseBooking), HttpStatus.OK);
    }

    @PatchMapping("/updateCourseBooking/{bookingId}")
    public ResponseEntity<String> updateCourseBooking(@PathVariable("bookingId") Integer bookingId, @RequestBody CourseBooking courseBooking){
        return new ResponseEntity<>(courseBookingServiceImp.updateCourseBooking(bookingId, courseBooking), HttpStatus.OK);
    }

    @PatchMapping("/cancelCourseBooking/{bookingId}")
    public ResponseEntity<String> cancelCourseBooking(@PathVariable("bookingId") Integer bookingId) {
        return new ResponseEntity<>(courseBookingServiceImp.cancelCourseBooking(bookingId), HttpStatus.OK);
    }

    @GetMapping("/readCourseBooking/{bookingId}")
    public ResponseEntity<CourseBooking> readCourseBooking(@PathVariable("bookingId") Integer bookingId){
        return new ResponseEntity<>(courseBookingServiceImp.readCourseBooking(bookingId), HttpStatus.OK);
    }

    @GetMapping("/readAllCourseBooking")
    public List<CourseBooking> readAllCourseBooking(){
        return courseBookingServiceImp.readAllCourseBooking();
    }


}

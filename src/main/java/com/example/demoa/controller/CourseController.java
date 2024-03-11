package com.example.demoa.controller;

import com.example.demoa.entity.admin.Course;
import com.example.demoa.serviceimplementation.CourseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/demoa")
public class CourseController {



    private CourseServiceImp courseServiceImp;
    @Autowired
    public CourseController(CourseServiceImp courseServiceImp) {
        this.courseServiceImp = courseServiceImp;
    }


    @PostMapping("/createCourse")
    public ResponseEntity<String> createCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseServiceImp.add(course), HttpStatus.OK);
    }

        @PatchMapping("/updateCourse/{courseId}")
        public ResponseEntity<String> updateCourse(@PathVariable("courseId") Integer courseId, @RequestBody Course course){
            return new ResponseEntity<>(courseServiceImp.update(courseId, course), HttpStatus.OK);
        }

@DeleteMapping("/deleteCourse/{courseId}")
public ResponseEntity<String> deleteCourse(@PathVariable("courseId") Integer courseId) {
    return new ResponseEntity<>(courseServiceImp.delete(courseId), HttpStatus.OK);
}

    @GetMapping(value = "/readCourse/{courseId}")
    public ResponseEntity<Course> readCourse(@PathVariable("courseId") Integer courseId) {
        return new ResponseEntity<>(courseServiceImp.read(courseId), HttpStatus.OK);
    }

    @GetMapping("/readAllCourse")
    public List<Course> readAllCourse(){
            return courseServiceImp.readAll();
        }


}

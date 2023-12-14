package com.example.demoa.controller;

import com.example.demoa.entity.Course;
import com.example.demoa.entity.ImageUploadResponse;
import com.example.demoa.serviceImplementation.CourseServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/demoa")
public class CourseController {


    @Autowired
    private CourseServiceImp courseServiceImp;


    @PostMapping("/createCourse")
    public ResponseEntity<String> createCourse(@RequestBody Course course){
//        courseServiceImp.uploadImage(file);
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
    public ResponseEntity<?> readCourse(@PathVariable("courseId") Integer courseId) {
        return new ResponseEntity<>(courseServiceImp.read(courseId), HttpStatus.OK);
    }

    @GetMapping("/readAllCourse")
    public List<Course> readAllCourse(){
            return courseServiceImp.readAll();
        }

    @PostMapping(value = "/uploadImage", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ImageUploadResponse> uploadImage(@RequestParam ("courseImage") MultipartFile file)  throws IOException{
        ImageUploadResponse response = courseServiceImp.uploadImage(file);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping(value = "/{name}",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getImageByName(@PathVariable("name") String name) {
        byte[] image = courseServiceImp.getImage(name);
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(image);
    }

}

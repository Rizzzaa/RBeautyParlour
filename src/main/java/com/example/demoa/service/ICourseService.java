package com.example.demoa.service;

import com.example.demoa.entity.Course;
import com.example.demoa.entity.ImageUploadResponse;
import org.springframework.web.multipart.MultipartFile;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public interface ICourseService {
    public String add(Course course);
    public String update(Integer id, Course course);
    public String delete(Integer id);
    public Course read(Integer id);
    public List<Course> readAll();
    ImageUploadResponse uploadImage(MultipartFile file) throws IOException;
}

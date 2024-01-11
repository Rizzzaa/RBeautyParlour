package com.example.demoa.service;

import com.example.demoa.entity.Course;
import java.util.List;

public interface ICourseService {
    String add(Course course);
    String update(Integer id, Course course);
    String delete(Integer id);
    Course read(Integer id);
    List<Course> readAll();
}

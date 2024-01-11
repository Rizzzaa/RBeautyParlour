package com.example.demoa.serviceimplementation;

import com.example.demoa.entity.Course;
import com.example.demoa.exception.CourseNotFoundException;
import com.example.demoa.repository.CourseRepository;
import com.example.demoa.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceImp implements ICourseService {

    private CourseRepository iCourseRepository;
    @Autowired
    public CourseServiceImp(CourseRepository iCourseRepository) {
        this.iCourseRepository = iCourseRepository;
    }


    @Override
    public String add(Course course){
        iCourseRepository.save(course);
        return "Course added successfully";
    }

    @Override
    public String update(Integer id, Course course) {
        Course courseOfId = iCourseRepository.findById(id).orElseThrow(CourseNotFoundException::new);
        if(course.getCourseName() != null){
            courseOfId.setCourseName(course.getCourseName());
        }
        if(course.getDescription() != null){
            courseOfId.setDescription(course.getDescription());
        }
        if(course.getDuration() != null){
            courseOfId.setDuration(course.getDuration());
        }
        if(course.getLevel() != null){
            courseOfId.setLevel(course.getLevel());
        }
        if(course.getCategory() != null){
            courseOfId.setCategory(course.getCategory());
        }
        if(course.getCourseCost() != null){
            courseOfId.setCourseCost(course.getCourseCost());
        }

        iCourseRepository.save(courseOfId);
        return "Course Updated";
    }


    @Override
    public String delete(Integer id){
        iCourseRepository.findById(id).orElseThrow(()->new CourseNotFoundException("Course with id= "+id+" is not found"));
        iCourseRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public Course read(Integer id) {
        return iCourseRepository.findById(id).orElseThrow(CourseNotFoundException::new);
    }


    @Override
    public List<Course> readAll() {
        return new ArrayList<>(iCourseRepository.findAll());
    }

}

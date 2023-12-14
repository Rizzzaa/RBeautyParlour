package com.example.demoa.serviceImplementation;

import com.example.demoa.entity.Course;
import com.example.demoa.entity.CourseImage;
import com.example.demoa.entity.ImageUploadResponse;
import com.example.demoa.exception.CourseNotFoundException;
import com.example.demoa.repository.CourseImageRepository;
import com.example.demoa.repository.CourseRepository;
import com.example.demoa.service.ICourseService;
import com.example.demoa.util.CourseImageUtility;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImp implements ICourseService {
    @Autowired
    private CourseRepository iCourseRepository;

    @Autowired
    private CourseImageRepository iCourseImageRepository;

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
//        Optional<CourseImage> dbImage = iCourseImageRepository.findById(id);
//        CourseImageUtility.decompressImage(dbImage.get().getImageData());
        return iCourseRepository.findById(id).orElseThrow(CourseNotFoundException::new);
    }


    @Override
    public List<Course> readAll() {
        List<Course> courseList=new ArrayList<Course>();
        courseList.addAll(iCourseRepository.findAll());
        return courseList;
    }

    @Override
    public ImageUploadResponse uploadImage(MultipartFile file) throws IOException {
        iCourseImageRepository.save(CourseImage.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(CourseImageUtility.compressImage(file.getBytes()))
                .build());
        return new ImageUploadResponse("Image uploaded: " + file.getOriginalFilename());
    }
    
    @Transactional
    public byte[] getImage(String name) {
        Optional<CourseImage> dbImage = iCourseImageRepository.findByName(name);
        return CourseImageUtility.decompressImage(dbImage.get().getImageData());
    }
}

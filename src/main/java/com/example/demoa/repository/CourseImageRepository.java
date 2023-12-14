package com.example.demoa.repository;

//import com.example.demoa.entity.Course;
import com.example.demoa.entity.CourseImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
public interface CourseImageRepository extends JpaRepository<CourseImage, Integer> {
    Optional<CourseImage> findByName(String fileName);
}


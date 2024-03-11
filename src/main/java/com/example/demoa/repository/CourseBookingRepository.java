package com.example.demoa.repository;

import com.example.demoa.entity.user.CourseBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseBookingRepository extends JpaRepository<CourseBooking, Integer> {
}

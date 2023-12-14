package com.example.demoa.repository;

import com.example.demoa.entity.ActivityBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityBookingRepository extends JpaRepository<ActivityBooking, Integer> {
}

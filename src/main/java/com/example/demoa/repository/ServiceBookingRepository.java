package com.example.demoa.repository;

import com.example.demoa.entity.user.ServiceBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceBookingRepository extends JpaRepository<ServiceBooking, Integer> {
}

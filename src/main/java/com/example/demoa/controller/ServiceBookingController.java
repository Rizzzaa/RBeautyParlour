package com.example.demoa.controller;


import com.example.demoa.entity.ServiceBooking;
import com.example.demoa.serviceImplementation.ServiceBookingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/demoa")
public class ServiceBookingController {

    @Autowired
    private ServiceBookingServiceImp serviceBookingServiceImp;

    @PostMapping("/createServiceBooking")
    public ResponseEntity<String> createServiceBooking(@RequestBody ServiceBooking serviceBooking) {
        return new ResponseEntity<>(serviceBookingServiceImp.addServiceBooking(serviceBooking), HttpStatus.OK);
    }

    @PatchMapping("/updateServiceBooking/{bookingId}")
    public ResponseEntity<String> updateServiceBooking(@PathVariable("bookingId") Integer bookingId, @RequestBody ServiceBooking serviceBooking){
        return new ResponseEntity<>(serviceBookingServiceImp.updateServiceBooking(bookingId, serviceBooking), HttpStatus.OK);
    }

    @PatchMapping("/cancelServiceBooking/{bookingId}")
    public ResponseEntity<String> cancelServiceBooking(@PathVariable("bookingId") Integer bookingId) {
        return new ResponseEntity<>(serviceBookingServiceImp.cancelServiceBooking(bookingId), HttpStatus.OK);
    }

    @GetMapping("/readServiceBooking/{bookingId}")
    public ResponseEntity<ServiceBooking> readServiceBooking(@PathVariable("bookingId") Integer bookingId){
        return new ResponseEntity<>(serviceBookingServiceImp.readServiceBooking(bookingId), HttpStatus.OK);
    }

    @GetMapping("/readAllServiceBooking")
    public List<ServiceBooking> readAllServiceBooking(){
        return serviceBookingServiceImp.readAllServiceBooking();
    }


}

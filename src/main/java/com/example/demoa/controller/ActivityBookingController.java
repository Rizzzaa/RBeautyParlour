package com.example.demoa.controller;


import com.example.demoa.entity.ActivityBooking;
import com.example.demoa.serviceImplementation.ActivityBookingServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/demoa")
public class ActivityBookingController {

    @Autowired
    private ActivityBookingServiceImp activityBookingServiceImp;

    @PostMapping("/createActivityBooking")
    public ResponseEntity<String> createActivityBooking(@RequestBody ActivityBooking activityBooking) {
        return new ResponseEntity<>(activityBookingServiceImp.addActivityBooking(activityBooking), HttpStatus.OK);
    }

    @PatchMapping("/updateActivityBooking/{bookingId}")
    public ResponseEntity<String> updateActivityBooking(@PathVariable("bookingId") Integer bookingId, @RequestBody ActivityBooking activityBooking){
        return new ResponseEntity<>(activityBookingServiceImp.updateActivityBooking(bookingId, activityBooking), HttpStatus.OK);
    }

    @PatchMapping("/cancelActivityBooking/{bookingId}")
    public ResponseEntity<String> cancelActivityBooking(@PathVariable("bookingId") Integer bookingId) {
        return new ResponseEntity<>(activityBookingServiceImp.cancelActivityBooking(bookingId), HttpStatus.OK);
    }

    @GetMapping("/readActivityBooking/{bookingId}")
    public ResponseEntity<ActivityBooking> readActivityBooking(@PathVariable("bookingId") Integer bookingId){
        return new ResponseEntity<>(activityBookingServiceImp.readActivityBooking(bookingId), HttpStatus.OK);
    }

    @GetMapping("/readAllActivityBooking")
    public List<ActivityBooking> readAllActivityBooking(){
        return activityBookingServiceImp.readAllActivityBooking();
    }


}

package com.example.demoa.service;


import com.example.demoa.entity.ActivityBooking;

import java.util.List;

public interface IActivityBookingService {
    public String addActivityBooking(ActivityBooking activityBooking);
    public String updateActivityBooking(Integer id, ActivityBooking activityBooking);
    public String cancelActivityBooking(Integer id);
//    public String deleteActivityBooking(Integer id);
    public ActivityBooking readActivityBooking(Integer id);
    public List<ActivityBooking> readAllActivityBooking();

}

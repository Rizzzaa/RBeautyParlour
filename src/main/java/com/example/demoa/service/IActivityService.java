package com.example.demoa.service;

import com.example.demoa.entity.Activity;
import com.example.demoa.exception.AlreadyExistsException;
import java.util.List;

public interface IActivityService {
    public String addActivity(Activity activity);
    public String updateActivity(Integer id, Activity activity);
    public String deleteActivity(Integer id);
    public Activity readActivity(Integer id);
    public List<Activity> readAllActivity();

}

package com.example.demoa.serviceImplementation;

import com.example.demoa.entity.Activity;
import com.example.demoa.exception.ActivityNotFoundException;
import com.example.demoa.exception.AlreadyExistsException;
import com.example.demoa.repository.ActivityRepository;
import com.example.demoa.service.IActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ActivityServiceImp implements IActivityService {
    @Autowired
    private ActivityRepository iActivityRepository;

    @Override
    public String addActivity(Activity activity) {
        iActivityRepository.save(activity);
        return "Activity added successfully";
    }

    @Override
    public String updateActivity(Integer id, Activity activity){
//        List<Activity> activityList = new ArrayList<>(iActivityRepository.findAll());
        Activity activityOfId = iActivityRepository.findById(id).orElseThrow(ActivityNotFoundException::new);

//        if(activity.getActivityName() != null){
//            int i=0;
//            while(i < activityList.size()){
//                if(!Objects.equals(activityList.get(i).getActivityName(), activity.getActivityName())){
//                    i++;
//                    if(i == activityList.size()){
//                        activityOfId.setActivityName(activity.getActivityName());
//                    }
//                }else {
//                    throw new AlreadyExistsException(activity.getActivityName());
//                }
//            }
//        }


        if(activity.getActivityName() != null){
            activityOfId.setActivityName(activity.getActivityName());
        }
        if(activity.getCategory() != null){
            activityOfId.setCategory(activity.getCategory());
        }
        if(activity.getActivityCost() != null){
            activityOfId.setActivityCost(activity.getActivityCost());
        }

        iActivityRepository.save(activityOfId);
        return "Activity Updated";
    }


    @Override
    public String deleteActivity(Integer id) throws ActivityNotFoundException{
        iActivityRepository.findById(id).orElseThrow(()->new ActivityNotFoundException("Activity with id= " + id + " is not found"));
        iActivityRepository.deleteById(id);
        return "Deleted";
    }

    @Override
    public Activity readActivity(Integer id) throws ActivityNotFoundException{
        return iActivityRepository.findById(id).orElseThrow(ActivityNotFoundException::new);
    }


    @Override
    public List<Activity> readAllActivity() {
        return new ArrayList<>(iActivityRepository.findAll());
    }


//    public Activity readByName(String name){
//
//    }
}

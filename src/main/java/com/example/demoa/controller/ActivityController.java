package com.example.demoa.controller;

import com.example.demoa.entity.Activity;
import com.example.demoa.serviceImplementation.ActivityServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/demoa")
public class ActivityController {

        @Autowired
        private ActivityServiceImp activityServiceImp;

        @PostMapping("/createActivity")
        public ResponseEntity<String> createActivity(@RequestBody Activity activity) {
            return new ResponseEntity<>(activityServiceImp.addActivity(activity), HttpStatus.OK);
        }

        @PatchMapping("/updateActivity/{activityId}")
        public ResponseEntity<String> updateActivity(@PathVariable("activityId") Integer activityId, @RequestBody Activity activity){
            return new ResponseEntity<>(activityServiceImp.updateActivity(activityId, activity), HttpStatus.OK);
        }

        @DeleteMapping("/deleteActivity/{activityId}")
        public ResponseEntity<String> deleteActivity(@PathVariable("activityId") Integer activityId) {
            return new ResponseEntity<>(activityServiceImp.deleteActivity(activityId), HttpStatus.OK);
        }

        @GetMapping("/readActivity/{activityId}")
        public ResponseEntity<Activity> readActivity(@PathVariable("activityId") Integer activityId){
            return new ResponseEntity<>(activityServiceImp.readActivity(activityId), HttpStatus.OK);
        }

        @GetMapping("/readAllActivity")
        public List<Activity> readAllActivity(){
            return activityServiceImp.readAllActivity();
        }

}

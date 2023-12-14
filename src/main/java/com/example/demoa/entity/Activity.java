package com.example.demoa.entity;

import com.example.demoa.enums.Category;
import jakarta.persistence.*;

@Entity

public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activityId;
    private String activityName;
    private Category category;
    private Double activityCost ;


//    private Integer customerId;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getActivityCost() {
        return activityCost;
    }

    public void setActivityCost(Double activityCost) {
        this.activityCost = activityCost;
    }

//    public Integer getCustomerId() {
//        return customerId;
//    }
//
//    public void setCustomerId(Integer customerId) {
//        this.customerId = customerId;
//    }
}

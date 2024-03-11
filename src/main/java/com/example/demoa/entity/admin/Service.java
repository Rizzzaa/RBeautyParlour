package com.example.demoa.entity.admin;

import com.example.demoa.enums.Category;
import com.example.demoa.enums.Company;
import jakarta.persistence.*;

@Entity

public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer serviceId;
    private String serviceName;
    private Company company;
    private Category category;
    private Double serviceCost;

    public Service() {
    }

    public Service(String serviceName, Company company, Category category, Double serviceCost) {
        this.serviceName = serviceName;
        this.company = company;
        this.category = category;
        this.serviceCost = serviceCost;
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getServiceCost() {
        return serviceCost;
    }

    public void setServiceCost(Double serviceCost) {
        this.serviceCost = serviceCost;
    }


}

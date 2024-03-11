package com.example.demoa.entity.user;

import com.example.demoa.enums.Category;
import com.example.demoa.enums.Company;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String itemName;
    private Company company;
    private Category category;
    private Double itemCost;

    public Cart() {
    }

    public Cart(Integer id, String itemName, Company company, Category category, Double itemCost) {
        this.id = id;
        this.itemName = itemName;
        this.company = company;
        this.category = category;
        this.itemCost = itemCost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public Double getItemCost() {
        return itemCost;
    }

    public void setItemCost(Double itemCost) {
        this.itemCost = itemCost;
    }
}

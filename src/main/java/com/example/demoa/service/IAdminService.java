package com.example.demoa.service;

import com.example.demoa.entity.Admin;

import java.util.List;

public interface IAdminService {
    String addAdmin(Admin admin);
    String updateAdmin(Integer id, Admin admin);
    String deleteAdmin(Integer id);
    Admin readAdmin(Integer id);
    List<Admin> readAllAdmin();

}

package com.example.demoa.serviceimplementation;

import com.example.demoa.entity.Admin;
import com.example.demoa.exception.AdminNotFoundException;
import com.example.demoa.repository.AdminRepository;
import com.example.demoa.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class AdminServiceImp implements IAdminService{

    private AdminRepository adminRepository;

    @Autowired
    public AdminServiceImp(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    @Override
    public String addAdmin(Admin admin) {
        adminRepository.save(admin);
        return "Admin Saved";
    }

    @Override
    public String updateAdmin(Integer id, Admin admin) {
        Admin adminOfId = adminRepository.findById(id).orElseThrow(AdminNotFoundException::new);
        if(admin.getAdminEmail() != null){
            adminOfId.setAdminEmail(admin.getAdminEmail());
        }
        if(admin.getAdminName() != null){
            adminOfId.setAdminName(admin.getAdminName());
        }
        if(admin.getAdminPassword() != null){
            adminOfId.setAdminPassword(admin.getAdminPassword());
        }
        if(admin.getAdminRole() != null){
            adminOfId.setAdminRole(admin.getAdminRole());
        }
        adminRepository.save(adminOfId);
        return "Admin Updated";
    }

    @Override
    public String deleteAdmin(Integer id) {
        adminRepository.findById(id).orElseThrow(AdminNotFoundException::new);
        adminRepository.deleteById(id);
        return "Admin Deleted";
    }

    @Override
    public Admin readAdmin(Integer id) {
        return adminRepository.findById(id).orElseThrow(AdminNotFoundException::new);
    }

    @Override
    public List<Admin> readAllAdmin() {
        return new ArrayList<>(adminRepository.findAll());
    }
}

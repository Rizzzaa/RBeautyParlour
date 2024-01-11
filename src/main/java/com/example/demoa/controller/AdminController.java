package com.example.demoa.controller;

import com.example.demoa.entity.Admin;
import com.example.demoa.serviceimplementation.AdminServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/demoa")
public class AdminController {
    private AdminServiceImp adminServiceImp;

    @Autowired
    public AdminController(AdminServiceImp adminServiceImp) {
        this.adminServiceImp = adminServiceImp;
    }

    @PostMapping("/createAdmin")
    public ResponseEntity<String> createAdmin(@RequestBody Admin admin){
        return new ResponseEntity<>(adminServiceImp.addAdmin(admin), HttpStatus.OK);
    }

    @PatchMapping("/updateAdmin/{adminId}")
    public ResponseEntity<String> updateAdmin(@PathVariable("adminId") Integer adminId, @RequestBody Admin admin){
        return new ResponseEntity<>(adminServiceImp.updateAdmin(adminId, admin), HttpStatus.OK);
    }

    @DeleteMapping("/deleteAdmin/{adminId}")
    public ResponseEntity<String> deleteAdmin(@PathVariable("adminId") Integer adminId){
        return new ResponseEntity<>(adminServiceImp.deleteAdmin(adminId), HttpStatus.OK);

    }
    @GetMapping("/readAdmin/{adminId}")
    public ResponseEntity<Admin> readAdmin(@PathVariable("adminId") Integer adminId){
        return new ResponseEntity<>(adminServiceImp.readAdmin(adminId),HttpStatus.OK);

    }
    @GetMapping("/readAllAdmin")
    public List<Admin> readAllAdmin(){
        return adminServiceImp.readAllAdmin();

    }
}

package com.example.demoa.controller;

import com.example.demoa.entity.User;
import com.example.demoa.serviceimplementation.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/demoa")
public class UserController {

        private UserServiceImp userServiceImp;
    @Autowired
    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @PostMapping("/createUser")
        public ResponseEntity<String> createUser(@RequestBody User user) {
            return new ResponseEntity<>(userServiceImp.add(user), HttpStatus.OK);
        }

        @PatchMapping("/updateUser/{userId}")
        public ResponseEntity<String> updateUser(@PathVariable("userId") Integer userId, @RequestBody User user){
            return new ResponseEntity<>(userServiceImp.update(userId, user), HttpStatus.OK);
        }

        @GetMapping("/readUser/{userId}")
        public ResponseEntity<User> readUser(@PathVariable("userId") Integer userId){
            return new ResponseEntity<>(userServiceImp.read(userId), HttpStatus.OK);
        }

        @GetMapping("/readAllUser")
        public List<User> readAllUser(){
            return userServiceImp.readAll();
        }

        @DeleteMapping("/deleteUser/{userId}")
        public ResponseEntity<String> deleteUser(@PathVariable("userId") Integer userId){
            return new ResponseEntity<>(userServiceImp.delete(userId), HttpStatus.OK);
        }

    }


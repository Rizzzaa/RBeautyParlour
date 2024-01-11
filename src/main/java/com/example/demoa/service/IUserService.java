package com.example.demoa.service;

import com.example.demoa.entity.User;

import java.util.List;

public interface IUserService {
    String add(User user);
    String update(Integer id, User user);
    String delete(Integer id);
    User read(Integer id);
    List<User> readAll();
}

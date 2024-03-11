package com.example.demoa.serviceimplementation;

import com.example.demoa.entity.User;
import com.example.demoa.exception.InvalidArgumentException;
import com.example.demoa.exception.UserNotFoundException;
import com.example.demoa.repository.UserRepository;
import com.example.demoa.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImp implements IUserService {

    private UserRepository iUserRepository;

    @Autowired
    public UserServiceImp(UserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public String add(User user) {
        if(user != null) {
            iUserRepository.save(user);
            return "User added successfully";
        }else {
            throw new InvalidArgumentException("Provided info for adding user is null");
        }
    }


    @Override
    public String update(Integer id, User user) {
        if(user != null) {
        User userOfId = iUserRepository.findById(id).orElseThrow(UserNotFoundException::new);
        if(user.getEmail() != null){
            userOfId.setEmail(user.getEmail());
        }
        if(user.getUserName() != null){
            userOfId.setUserName(user.getUserName());
        }
        if(user.getPassword() != null){
            userOfId.setPassword(user.getPassword());
        }
        if(user.getRole() != null){
            userOfId.setRole(user.getRole());
        }
        iUserRepository.save(userOfId);
        return "User Updated";
    }else {
        throw new InvalidArgumentException("Provided info for updating user is null");
    }
    }



    @Override
    public String delete(Integer id) {
        iUserRepository.findById(id).orElseThrow(()->new UserNotFoundException("Customer with id= "+id+" is not found"));
        iUserRepository.deleteById(id);
        return "User Deleted";
    }

    @Override
    public User read(Integer id) {
        return iUserRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }


    @Override
    public List<User> readAll() {
        return new ArrayList<>(iUserRepository.findAll());
    }
}

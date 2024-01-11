package com.example.demoa.serviceimplementation;

import com.example.demoa.entity.User;
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
        iUserRepository.save(user);
        return "Customer added successfully";
    }

    @Override
    public String update(Integer id, User user) {
        User userOfId = iUserRepository.findById(id).orElseThrow(UserNotFoundException::new);
        if(user.getUserEmail() != null){
            userOfId.setUserEmail(user.getUserEmail());
        }
        if(user.getUserName() != null){
            userOfId.setUserName(user.getUserName());
        }
        if(user.getPassword() != null){
            userOfId.setPassword(user.getPassword());
        }
        if(user.getUserRole() != null){
            userOfId.setUserRole(user.getUserRole());
        }
        iUserRepository.save(userOfId);
        return "Customer Updated";
    }


    @Override
    public String delete(Integer id) {
        iUserRepository.findById(id).orElseThrow(()->new UserNotFoundException("Customer with id= "+id+" is not found"));
        iUserRepository.deleteById(id);
        return "Deleted";
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

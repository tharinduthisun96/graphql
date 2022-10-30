package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.UserInput;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Integer id);


    User updateUser(UserInput user);

    User saveUser(UserInput user);

    Integer deleteUser(Integer id);
}

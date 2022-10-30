package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.dto.UserInput;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Integer id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found with id:" + id));
    }

    public User saveUser(UserInput user) {
        User newUser = User.builder().name(user.getName()).surname(user.getSurname())
                .age(user.getAge()).build();
        return userRepository.save(newUser);
    }

    public User updateUser( UserInput user) {
        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        existingUser.setName(user.getName());
        existingUser.setSurname(user.getSurname());
        existingUser.setAge(user.getAge());

        return userRepository.save(existingUser);
    }

    public Integer deleteUser(Integer id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        userRepository.delete(existingUser);

        return id;
    }
}

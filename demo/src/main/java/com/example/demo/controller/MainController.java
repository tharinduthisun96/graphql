package com.example.demo.controller;

import com.example.demo.domain.Order;
import com.example.demo.domain.User;
import com.example.demo.dto.UserInput;
import com.example.demo.service.OrderService;
import com.example.demo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.BatchMapping;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;
import java.util.Map;

@Controller
@AllArgsConstructor
public class MainController {
    private UserService userService;
    private OrderService orderService;

    @QueryMapping
    public List<User> users(){
        return userService.getAllUsers();
    }

    @BatchMapping
    public Map<User,List<Order>> orders(List<User> users){
        return orderService.getCustomersOrder(users);
    }

    @QueryMapping
    public User getUserById(@Argument @NotNull Integer id) {
        return userService.getUserById(id);
    }

    @MutationMapping
    public User newUser(@Argument @Valid UserInput user) {
        return userService.saveUser(user);
    }

    @MutationMapping
    public User updateUser(@Argument @Valid UserInput user) {
        return userService.updateUser(user);
    }

    @MutationMapping
    public Integer deleteUser(@Argument @NotNull @Positive Integer id) {
        return userService.deleteUser(id);
    }
}

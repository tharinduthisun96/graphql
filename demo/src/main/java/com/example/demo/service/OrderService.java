package com.example.demo.service;

import com.example.demo.domain.Order;
import com.example.demo.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface OrderService {
    Map<User,List<Order>> getCustomersOrder(List<User> users);
}

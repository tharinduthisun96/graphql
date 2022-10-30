package com.example.demo.service;

import com.example.demo.custom.UserOrderData;
import com.example.demo.domain.Order;
import com.example.demo.domain.User;
import com.example.demo.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderServiceImpl implements OrderService{
    private OrderRepository orderRepository;

    public Map<User, List<Order>> getCustomersOrder(List<User> users) {
        List<Integer> userIds =  users.stream().map(user-> user.getId()).collect(Collectors.toList());

        List<UserOrderData> userOrderData = orderRepository.findUserAndOrderData(userIds);

        Map<User, List<Order>> User_ListorderMap = userOrderData.stream()
                .collect(
                        Collectors
                                .groupingBy(
                                        userOrder -> User.builder().id(userOrder.getUserId()).name(userOrder.getName())
                                                .surname(userOrder.getSurname()).age(userOrder.getAge()).build(),
                                        Collectors.mapping(userOrder -> {

                                            Order order = null;
                                            if (userOrder.getQuantity() != null) {
                                                order = Order.builder().id(userOrder.getOrderId()).quantity(userOrder.getQuantity())
                                                        .totalPrice(userOrder.getTotalPrice())
                                                        .build();
                                            }
                                            return order;

                                        }, Collectors.toList())));

        return User_ListorderMap;
    }
}

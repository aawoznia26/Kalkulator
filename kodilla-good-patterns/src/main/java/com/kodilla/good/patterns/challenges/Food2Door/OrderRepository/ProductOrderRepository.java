package com.kodilla.good.patterns.challenges.Food2Door.OrderRepository;

import com.kodilla.good.patterns.challenges.Food2Door.Order.Order;
import com.kodilla.good.patterns.challenges.Food2Door.User;

import java.util.SortedMap;
import java.util.TreeMap;

public class ProductOrderRepository {

    SortedMap<Order, User> productOrderRepository = new TreeMap<>();

    public void addOrderToRepository(Order order, User user) {
        productOrderRepository.put(order, user);

    }
    public int getLastBasketId(){
        int lastBasketId= 0;
        if (productOrderRepository.size()>0) lastBasketId = productOrderRepository.lastKey().getOrderId();
        return lastBasketId;
    }
}

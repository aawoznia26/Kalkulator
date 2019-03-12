package com.kodilla.good.patterns.challenges.Food2Door.orderrepository;

import com.kodilla.good.patterns.challenges.Food2Door.order.Order;
import com.kodilla.good.patterns.challenges.Food2Door.User;

import java.util.SortedMap;
import java.util.TreeMap;

public class InMemoryOrderRepository {

    private SortedMap<Order, User> inMemoryOrderRepository = new TreeMap<>();

    public void addOrderToRepository(Order order, User user) {
        inMemoryOrderRepository.put(order, user);

    }

    public int assignOrderId() {
        int lastOrderId = 0;
        if (inMemoryOrderRepository.size() > 0) lastOrderId = inMemoryOrderRepository.lastKey().getOrderId();
        return lastOrderId + 1;
    }
}

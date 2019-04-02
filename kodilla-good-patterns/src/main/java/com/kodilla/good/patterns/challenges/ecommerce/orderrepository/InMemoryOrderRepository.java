package com.kodilla.good.patterns.challenges.ecommerce.orderrepository;

import com.kodilla.good.patterns.challenges.ecommerce.order.Basket;
import com.kodilla.good.patterns.challenges.ecommerce.User;

import java.util.SortedMap;
import java.util.TreeMap;

public class InMemoryOrderRepository implements OrderRepository {

    private SortedMap<Basket, User> inMemoryOrderRepository = new TreeMap<>();

    public void addBasketToRepository(Basket basket, User user) {
        inMemoryOrderRepository.put(basket, user);

    }

    private int assignOrderId() {
        int lastOrderId = 0;
        if (inMemoryOrderRepository.size() > 0) lastOrderId = inMemoryOrderRepository.lastKey().getBasketId();
        return lastOrderId + 1;
    }
}


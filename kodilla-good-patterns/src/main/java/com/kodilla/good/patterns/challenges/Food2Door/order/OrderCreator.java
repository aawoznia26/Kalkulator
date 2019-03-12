package com.kodilla.good.patterns.challenges.Food2Door.order;

import com.kodilla.good.patterns.challenges.Food2Door.Product;
import com.kodilla.good.patterns.challenges.Food2Door.orderrepository.InMemoryOrderRepository;

import java.time.Instant;
import java.util.Map;

public class OrderCreator {

    private InMemoryOrderRepository inMemoryOrderRepository;

    public OrderCreator(InMemoryOrderRepository inMemoryOrderRepository) {
        this.inMemoryOrderRepository = inMemoryOrderRepository;
    }

    public Order createOrder(Map<Product, Integer> orderedProduct, double promotion, Delivery delivery) {
        int orderId = inMemoryOrderRepository.assignOrderId();
        Instant orderDateAndTime = Instant.now();
        double finalPrice = 0;
        for (Map.Entry<Product, Integer> entry : orderedProduct.entrySet()) {
            finalPrice += entry.getKey().getPrice() * entry.getValue();
        }

        if (finalPrice - promotion < 0) {
            finalPrice = 0.1;
        } else {
            finalPrice = finalPrice - promotion;
        }

        return new Order(orderId, orderedProduct, orderDateAndTime, promotion, finalPrice, delivery);

    }

}

package com.kodilla.good.patterns.challenges.Food2Door.Order;

import com.kodilla.good.patterns.challenges.Food2Door.Order.Order;
import com.kodilla.good.patterns.challenges.Food2Door.Product;
import com.kodilla.good.patterns.challenges.Food2Door.ProductOrderRepository;

import java.time.LocalDateTime;
import java.util.Map;

public class OrderCreator {

    ProductOrderRepository productOrderRepository = new ProductOrderRepository();


    public Order createOrder(Map<Product, Integer> orderedProduct, double promotion, String delivery) {
        int orderId = productOrderRepository.getLastBasketId() + 1;
        LocalDateTime orderDateAndTime = LocalDateTime.now();
        double finalPrice = 0;
        for (Map.Entry<Product,Integer> entry :orderedProduct.entrySet()) {
            finalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        finalPrice = finalPrice - promotion;

        Order order = new Order(orderId, orderedProduct, orderDateAndTime, promotion, finalPrice, delivery);
        return order;

    }

}

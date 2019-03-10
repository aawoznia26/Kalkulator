package com.kodilla.good.patterns.challenges.Food2Door;

import com.kodilla.good.patterns.challenges.Food2Door.Order.OrderCreator;
import com.kodilla.good.patterns.challenges.Food2Door.Order.OrderProcessor;

import java.util.HashMap;
import java.util.Map;

public class Food2DoorApp {
    public static void main(String[] args) {
        Map<Product, Integer> orderedProduct = new HashMap<>();
        orderedProduct.put(new Product(1736, "Jabłko Antonówka", 1.8, 12), 7);
        orderedProduct.put(new Product(12, "Sałata", 3, 142), 2);
        orderedProduct.put(new Product(87, "Burak", 2.5, 76), 3);
        double promotion = 28.00;
        String delivery = "FedEx";

        User user = new User("Krystyna", "Wrotnowska", "Podskarbińskiego 98/21",
                "hbnsn@o2.pl", "873-281-318");


        OrderProcessor orderProcessor = new OrderProcessor();
        orderProcessor.processOrder(new OrderCreator().createOrder(orderedProduct, promotion, delivery), user);

    }
}

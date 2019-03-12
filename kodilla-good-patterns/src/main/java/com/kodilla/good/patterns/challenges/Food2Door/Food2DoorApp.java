package com.kodilla.good.patterns.challenges.Food2Door;

import com.kodilla.good.patterns.challenges.Food2Door.informationservice.EmailConfirmationSender;
import com.kodilla.good.patterns.challenges.Food2Door.informationservice.InformationService;
import com.kodilla.good.patterns.challenges.Food2Door.order.Delivery;
import com.kodilla.good.patterns.challenges.Food2Door.order.Order;
import com.kodilla.good.patterns.challenges.Food2Door.order.OrderCreator;
import com.kodilla.good.patterns.challenges.Food2Door.order.OrderProcessor;
import com.kodilla.good.patterns.challenges.Food2Door.orderrepository.InMemoryOrderRepository;

import java.util.HashMap;
import java.util.Map;

public class Food2DoorApp {
    public static void main(String[] args) {
        Map<Product, Integer> orderedProduct = new HashMap<>();
        orderedProduct.put(new Product(1736, "Jabłko Antonówka", 1.8, 12), 7);
        orderedProduct.put(new Product(12, "Sałata", 3, 142), 2);
        orderedProduct.put(new Product(87, "Burak", 2.5, 76), 3);
        double promotion = 1228.00;
        Delivery delivery = Delivery.GLS;

        User user = new User("Krystyna", "Wrotnowska", "Podskarbińskiego 98/21",
                "hbnsn@o2.pl", "873-281-318");

        InMemoryOrderRepository inMemoryOrderRepository = new InMemoryOrderRepository();

        OrderCreator orderCreator = new OrderCreator(inMemoryOrderRepository);
        Order order = orderCreator.createOrder(orderedProduct, promotion, delivery);

        OrderProcessor orderProcessor = new OrderProcessor();
        boolean result = orderProcessor.processOrder(order, user);

        inMemoryOrderRepository.addOrderToRepository(order, user);

        InformationService informationService = new EmailConfirmationSender();
        informationService.inform(user, order, result);

    }
}

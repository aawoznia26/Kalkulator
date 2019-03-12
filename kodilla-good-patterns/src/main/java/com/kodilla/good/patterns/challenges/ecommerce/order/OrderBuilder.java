package com.kodilla.good.patterns.challenges.ecommerce.order;


import com.kodilla.good.patterns.challenges.ecommerce.Product;
import com.kodilla.good.patterns.challenges.ecommerce.User;
import com.kodilla.good.patterns.challenges.ecommerce.orderrepository.InMemoryOrderRepository;

import java.time.Instant;
import java.util.Map;

public class OrderBuilder {

    private InMemoryOrderRepository inMemoryOrderRepository;

    public OrderBuilder(InMemoryOrderRepository inMemoryOrderRepository) {
        this.inMemoryOrderRepository = inMemoryOrderRepository;
    }

    public Basket buildBasket(OrderRequest orderRequest) {
        int basketId = inMemoryOrderRepository.assignOrderId();
        Map<Product, Integer> orderedProduct = orderRequest.getOrderedProduct();
        double promotion = orderRequest.getPromotion();
        Delivery delivery = orderRequest.getDelivery();
        User user = orderRequest.getUser();
        Instant orderDateAndTime = orderRequest.getOrderDateAndTime();
        double finalPrice = 0;
        for (Map.Entry<Product, Integer> entry : orderedProduct.entrySet()) {
            finalPrice += entry.getKey().getPrice() * entry.getValue();
        }

        if (finalPrice - promotion < 0) {
            finalPrice = 0.1;
        } else {
            finalPrice = finalPrice - promotion;
        }

        Basket basket = new Basket(basketId, orderedProduct, orderDateAndTime, finalPrice, promotion, delivery);
        return basket;
    }
}

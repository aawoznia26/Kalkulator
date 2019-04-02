package com.kodilla.good.patterns.challenges.ecommerce.order;

import com.kodilla.good.patterns.challenges.ecommerce.Product;
import com.kodilla.good.patterns.challenges.ecommerce.User;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


public class BasketServiceImpl implements BasketService {

    private AtomicInteger baskerIdGenerator = new AtomicInteger();

    @Override
    public Basket buildBasket(OrderRequest orderRequest) {
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

        return new Basket(baskerIdGenerator.incrementAndGet(), orderedProduct, orderDateAndTime, finalPrice, promotion, delivery);
    }
}

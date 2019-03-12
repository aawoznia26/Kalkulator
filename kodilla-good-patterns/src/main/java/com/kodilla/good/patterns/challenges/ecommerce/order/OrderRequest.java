package com.kodilla.good.patterns.challenges.ecommerce.order;

import com.kodilla.good.patterns.challenges.ecommerce.Product;
import com.kodilla.good.patterns.challenges.ecommerce.User;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class OrderRequest {
    private User user;
    private Map<Product, Integer> orderedProduct = new HashMap<>();
    private Instant orderDateAndTime;
    private double promotion;
    private Delivery delivery;

    public OrderRequest(User user, Map<Product, Integer> orderedProduct, Instant orderDateAndTime,
                        double promotion, Delivery delivery) {
        this.user = user;
        this.orderedProduct = orderedProduct;
        this.orderDateAndTime = orderDateAndTime;
        this.promotion = promotion;
        this.delivery = delivery;
    }

    public User getUser() {
        return user;
    }

    public Map<Product, Integer> getOrderedProduct() {
        return orderedProduct;
    }

    public Instant getOrderDateAndTime() {
        return orderDateAndTime;
    }

    public double getPromotion() {
        return promotion;
    }

    public Delivery getDelivery() {
        return delivery;
    }

}

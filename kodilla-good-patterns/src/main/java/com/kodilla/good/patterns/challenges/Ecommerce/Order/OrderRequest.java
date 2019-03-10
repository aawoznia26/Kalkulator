package com.kodilla.good.patterns.challenges.Ecommerce.Order;

import com.kodilla.good.patterns.challenges.Ecommerce.Product;
import com.kodilla.good.patterns.challenges.Ecommerce.User;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class OrderRequest {
    private User user;
    private Map<Product,Integer> orderedProduct = new HashMap<>();
    private LocalDateTime orderDateAndTime;
    private double promotion;
    private String delivery;

    public OrderRequest(User user, Map<Product, Integer> orderedProduct, LocalDateTime orderDateAndTime,
                        double promotion, String delivery) {
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

    public LocalDateTime getOrderDateAndTime() {
        return orderDateAndTime;
    }

    public double getPromotion() {
        return promotion;
    }

    public String getDelivery() {
        return delivery;
    }

}

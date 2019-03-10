package com.kodilla.good.patterns.challenges.Food2Door.Order;

import com.kodilla.good.patterns.challenges.Food2Door.Product;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Order implements Comparable<Order>{
    private int orderId;
    private Map<Product, Integer> orderedProduct = new HashMap<>();
    private LocalDateTime orderDateAndTime;
    private double promotion;
    private double finalPrice;
    private String delivery;

    public Order(int orderId, Map<Product, Integer> orderedProduct, LocalDateTime orderDateAndTime,
                 double promotion, double finalPrice, String delivery) {
        this.orderId = orderId;
        this.orderedProduct = orderedProduct;
        this.orderDateAndTime = orderDateAndTime;
        this.promotion = promotion;
        this.finalPrice = finalPrice;
        this.delivery = delivery;
    }

    public int getOrderId() {
        return orderId;
    }

    public Map<Product, Integer> getOrderedProduct() {
        return orderedProduct;
    }

    @Override
    public int compareTo(Order o) {
        return (int)(this.orderId - o.getOrderId());
    }
}

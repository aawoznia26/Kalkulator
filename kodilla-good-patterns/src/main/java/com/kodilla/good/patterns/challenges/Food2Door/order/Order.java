package com.kodilla.good.patterns.challenges.Food2Door.order;

import com.kodilla.good.patterns.challenges.Food2Door.Product;
import com.kodilla.good.patterns.challenges.Food2Door.ProductOrderResult;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Order implements Comparable<Order> {

    private int orderId;
    private Map<Product, ProductOrderResult> orderedProduct = new HashMap<>();
    private Instant orderDateAndTime;
    private double promotion;
    private double finalPrice;
    private Delivery delivery;

    public Order(int orderId, Map<Product, ProductOrderResult> orderedProduct, Instant orderDateAndTime,
                 double promotion, double finalPrice, Delivery delivery) {
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

    public Map<Product, ProductOrderResult> getOrderedProduct() {
        return orderedProduct;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    @Override
    public int compareTo(Order o) {
        return (int) (this.orderId - o.getOrderId());
    }

    @Override
    public String toString() {
        String product = orderedProduct.entrySet().stream().map(entry -> " " + entry.getKey().toString() + " " + entry.getValue() + " sztuk")
                .collect(Collectors.joining(", "));
        return product;
    }
}

package com.kodilla.good.patterns.challenges.ecommerce.order;

import com.kodilla.good.patterns.challenges.ecommerce.Product;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Basket implements Comparable<Basket> {
    private int basketId;
    private Map<Product, Integer> orderedProduct = new HashMap<>();
    private Instant orderDateAndTime;
    private double finalPrice;
    private Delivery delivery;

    public Basket(int basketId, Map<Product, Integer> orderedProduct, Instant orderDateAndTime, double finalPrice,
                  double promotion, Delivery delivery) {
        this.basketId = basketId;
        this.orderedProduct = orderedProduct;
        this.orderDateAndTime = orderDateAndTime;
        this.finalPrice = finalPrice;
        this.delivery = delivery;
    }

    public int getBasketId() {
        return basketId;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public Map<Product, Integer> getOrderedProduct() {
        return orderedProduct;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    @Override
    public String toString() {
        String product = orderedProduct.entrySet().stream().map(entry -> " " + entry.getKey().toString() + " " + entry.getValue() + " pieces")
                .collect(Collectors.joining(", "));
        return product;
    }

    public int compareTo(Basket o) {
        return (int) (this.basketId - o.getBasketId());
    }


}

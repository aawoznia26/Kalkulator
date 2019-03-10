package com.kodilla.good.patterns.challenges.Ecommerce.Order;

import com.kodilla.good.patterns.challenges.Ecommerce.Product;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Basket {
    private int basketId;
    private Map<Product, Integer> orderedProduct = new HashMap<>();
    private LocalDateTime orderDateAndTime;
    private double finalPrice;
    private String delivery;

    public Basket(int basketId, Map<Product, Integer> orderedProduct, LocalDateTime orderDateAndTime, double finalPrice,
                  double promotion, String delivery) {
        this.basketId = basketId;
        this.orderedProduct = orderedProduct;
        this.orderDateAndTime = orderDateAndTime;
        this.finalPrice = finalPrice;
        this.delivery = delivery;
    }

    public int getBasketId() {
        return basketId;
    }

    public String getDelivery() {
        return delivery;
    }

    public Map<Product, Integer> getOrderedProduct() {
        return orderedProduct;
    }

    @Override
    public String toString() {
        String product = null;
        for (Map.Entry<Product, Integer> entry : orderedProduct.entrySet()) {
            product = entry.getKey().toString();
        }
        return product;
    }
}

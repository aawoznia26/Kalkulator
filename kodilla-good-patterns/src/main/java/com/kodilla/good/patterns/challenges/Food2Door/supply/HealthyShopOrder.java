package com.kodilla.good.patterns.challenges.Food2Door.supply;

import com.kodilla.good.patterns.challenges.Food2Door.Product;

public class HealthyShopOrder {

    private Product product;
    private int quantity;

    public HealthyShopOrder(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}

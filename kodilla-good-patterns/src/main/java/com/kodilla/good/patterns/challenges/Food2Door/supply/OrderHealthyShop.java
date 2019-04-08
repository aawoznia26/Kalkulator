package com.kodilla.good.patterns.challenges.Food2Door.supply;

import com.kodilla.good.patterns.challenges.Food2Door.Product;

public class OrderHealthyShop implements OrderSupplier {

    public int getId() {
        return 76;
    }

    public boolean process(Product product, int quantity) {

        HealthyShopOrder healthyShopOrder = new HealthyShopOrder(product, quantity);
        return false;

    }
}
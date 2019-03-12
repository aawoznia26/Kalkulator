package com.kodilla.good.patterns.challenges.Food2Door.supply;

import com.kodilla.good.patterns.challenges.Food2Door.Product;

public class OrderFromHealthyShop implements OrderFromSupplier {

    public boolean process(Product product, int quantity) {

        HealthyShopOrder healthyShopOrder = new HealthyShopOrder(product, quantity);
        System.out.println("true HealthyShop");
        return true;

    }
}

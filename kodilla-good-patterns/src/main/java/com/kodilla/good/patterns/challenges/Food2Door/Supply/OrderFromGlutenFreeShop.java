package com.kodilla.good.patterns.challenges.Food2Door.Supply;

import com.kodilla.good.patterns.challenges.Food2Door.Product;

public class OrderFromGlutenFreeShop implements OrderFromSupplier {

    public boolean process(Product product, int quantity){
        int productId = product.getProductId();
        String deliveryPoint = "Central Food2Door Warehouse, Kwiatowa 5, 01-828 Krosno";

        GlutenFreeShopOrder glutenFreeShopOrder = new GlutenFreeShopOrder(productId, quantity, deliveryPoint);
        System.out.println("true GlutenFreeShop");
        return true;

    }
}
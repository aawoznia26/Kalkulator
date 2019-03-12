package com.kodilla.good.patterns.challenges.Food2Door.supply;

public class GlutenFreeShopOrder {

    private int productID;
    private int quantity;
    private String deliveryPoint;

    public GlutenFreeShopOrder(int productID, int quantity, String deliveryPoint) {
        this.productID = productID;
        this.quantity = quantity;
        this.deliveryPoint = deliveryPoint;
    }
}

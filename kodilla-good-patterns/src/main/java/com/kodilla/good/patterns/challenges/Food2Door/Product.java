package com.kodilla.good.patterns.challenges.Food2Door;

public class Product {

    private int productId;
    private String productName;
    private double price;
    private int supplierId;

    public Product(int productId, String productName, double price, int supplierId) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.supplierId = supplierId;
    }

    public double getPrice() {
        return price;
    }

    public int getProductId() {
        return productId;
    }

    public int getSupplierId() {
        return supplierId;
    }
}

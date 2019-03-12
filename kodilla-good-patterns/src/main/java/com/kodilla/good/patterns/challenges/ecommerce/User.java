package com.kodilla.good.patterns.challenges.ecommerce;

public class User {
    private String name;
    private String billingAddress;
    private String deliveryAddress;
    private String email;
    private String phone;

    public User(String name, String billingAddress, String deliveryAddress, String email, String phone) {
        this.name = name;
        this.billingAddress = billingAddress;
        this.deliveryAddress = deliveryAddress;
        this.email = email;
        this.phone = phone;
    }
}

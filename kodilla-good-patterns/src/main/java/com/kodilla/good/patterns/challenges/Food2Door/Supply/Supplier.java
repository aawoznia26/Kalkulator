package com.kodilla.good.patterns.challenges.Food2Door.Supply;

public class Supplier {

    private int supplierId;
    private String supplierName;
    private String billingAddress;
    private int taxNumber;
    private String email;
    private String phone;

    public Supplier(String name, String billingAddress, int taxNumber, String email, String phone) {
        this.supplierName = supplierName;
        this.billingAddress = billingAddress;
        this.taxNumber = taxNumber;
        this.email = email;
        this.phone = phone;
    }
}

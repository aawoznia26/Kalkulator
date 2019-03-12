package com.kodilla.good.patterns.challenges.Food2Door.supply;

import java.util.ArrayList;
import java.util.List;

public class Supplier {

    private int supplierId;
    private String supplierName;
    private String billingAddress;
    private int taxNumber;
    private String email;
    private String phone;


    public Supplier(int supplierId, String name, String billingAddress, int taxNumber, String email, String phone) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.billingAddress = billingAddress;
        this.taxNumber = taxNumber;
        this.email = email;
        this.phone = phone;
    }

    public int getSupplierId() {
        return supplierId;
    }

}

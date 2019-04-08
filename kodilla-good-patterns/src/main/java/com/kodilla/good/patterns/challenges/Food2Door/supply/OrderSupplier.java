package com.kodilla.good.patterns.challenges.Food2Door.supply;

import com.kodilla.good.patterns.challenges.Food2Door.Product;

public interface OrderSupplier {

    int getId();

    boolean process(Product product, int quantity);


}
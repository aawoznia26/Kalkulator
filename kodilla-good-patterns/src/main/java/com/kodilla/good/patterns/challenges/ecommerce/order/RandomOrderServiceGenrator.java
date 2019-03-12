package com.kodilla.good.patterns.challenges.ecommerce.order;

import java.util.Random;

public class RandomOrderServiceGenrator implements OrderService {

    public boolean order(Basket basket) {
        Random generator = new Random();
        return generator.nextBoolean();
    }
}

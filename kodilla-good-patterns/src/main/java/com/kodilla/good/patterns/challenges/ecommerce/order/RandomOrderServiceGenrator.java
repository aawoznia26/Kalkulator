package com.kodilla.good.patterns.challenges.ecommerce.order;

import java.util.Random;

public class RandomOrderServiceGenrator implements OrderService {

    private final Random generator = new Random();

    public boolean order(Basket basket) {
        return generator.nextBoolean();
    }
}

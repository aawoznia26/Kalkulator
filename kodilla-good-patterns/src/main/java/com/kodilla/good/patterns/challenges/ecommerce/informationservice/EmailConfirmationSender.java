package com.kodilla.good.patterns.challenges.ecommerce.informationservice;

import com.kodilla.good.patterns.challenges.ecommerce.order.Basket;
import com.kodilla.good.patterns.challenges.ecommerce.User;

public class EmailConfirmationSender implements InformationService {

    public void inform(User user, Basket basket, boolean result) {
        if (result) {
            System.out.println("Your basket number is " + basket.getBasketId() + " and contans:"
                    + basket.toString() + ". It will be delivered by " + basket.getDelivery() + ".");
        } else {
            System.out.println("Unfortunately your order " + basket.getBasketId() + " cannot be processed. " +
                    "Try again later.");
        }

    }
}

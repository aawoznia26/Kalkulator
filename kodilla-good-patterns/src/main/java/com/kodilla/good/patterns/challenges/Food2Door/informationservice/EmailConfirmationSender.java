package com.kodilla.good.patterns.challenges.Food2Door.informationservice;

import com.kodilla.good.patterns.challenges.Food2Door.User;
import com.kodilla.good.patterns.challenges.Food2Door.order.Order;

public class EmailConfirmationSender implements InformationService {

    public void inform(User user, Order order, boolean result) {
        if (result) {
            System.out.println("Your order number is " + order.getOrderId() + " and contans:"
                    + order.toString() + ". It will be delivered by " + order.getDelivery() + ".");
        } else {
            System.out.println("Unfortunately your order number " + order.getOrderId() + " cannot be processed. " +
                    "Try again later.");
        }

    }
}

package com.kodilla.good.patterns.challenges.Ecommerce.InformationService;

import com.kodilla.good.patterns.challenges.Ecommerce.Order.Basket;
import com.kodilla.good.patterns.challenges.Ecommerce.User;

public class InformationSender implements InformationService {

    public void inform(User user, Basket basket){
        System.out.println("Your basket number is " + basket.getBasketId() + " and contans:"
                + basket.getOrderedProduct().toString() + " It will be delivered by " + basket.getDelivery());
    }
}

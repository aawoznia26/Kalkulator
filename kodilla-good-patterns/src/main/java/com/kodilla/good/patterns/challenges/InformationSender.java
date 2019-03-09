package com.kodilla.good.patterns.challenges;

public class InformationSender implements InformationService {

    public void inform(User user, Basket basket){
        System.out.println("Your basket number is " + basket.getBasketId() + " and contans:"
                + basket.getOrderedProduct().toString() + " It will be delivered by " + basket.getDelivery());
    }
}

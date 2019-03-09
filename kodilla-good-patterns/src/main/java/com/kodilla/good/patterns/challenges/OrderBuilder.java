package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.util.Map;

public class OrderBuilder {
    ProductOrderRepository productOrderRepository = new ProductOrderRepository();

    public Basket buildBasket(OrderRequest orderRequest){
        int basketId = productOrderRepository.getLastBasketId() + 1;
        Map<Product,Integer> orderedProduct = orderRequest.getOrderedProduct();
        double promotion = orderRequest.getPromotion();
        String delivery = orderRequest.getDelivery();
        User user = orderRequest.getUser();
        LocalDateTime orderDateAndTime = orderRequest.getOrderDateAndTime();
        double finalPrice = 0;
        for (Map.Entry<Product,Integer> entry :orderedProduct.entrySet()) {
            finalPrice += entry.getKey().getPrice() * entry.getValue();
        }
        finalPrice = finalPrice - promotion;
        Basket basket = new Basket(basketId, orderedProduct, orderDateAndTime, finalPrice, promotion, delivery);
        return basket;
    }
}

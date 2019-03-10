package com.kodilla.good.patterns.challenges.Ecommerce.OrderRepository;

import com.kodilla.good.patterns.challenges.Ecommerce.Order.Basket;

import java.util.ArrayDeque;

class ProductOrderRepository implements OrderRepository {

    ArrayDeque<Basket> productOrderRepository = new ArrayDeque<Basket>();

    @Override
    public void addBasketToRepository(Basket basket) {

        productOrderRepository.offer(basket);
    }
    public int getLastBasketId(){
        int lastBasketId= 0;
        if (productOrderRepository.size()>0){
            lastBasketId = productOrderRepository.getLast().getBasketId();
        }
        return lastBasketId;
    }
}

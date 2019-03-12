package com.kodilla.good.patterns.challenges.ecommerce.orderrepository;

import com.kodilla.good.patterns.challenges.ecommerce.User;
import com.kodilla.good.patterns.challenges.ecommerce.order.Basket;

public interface OrderRepository {

    void addBasketToRepository(Basket basket, User user);

}

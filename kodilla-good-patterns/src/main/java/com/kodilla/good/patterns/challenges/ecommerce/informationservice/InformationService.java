package com.kodilla.good.patterns.challenges.ecommerce.informationservice;

import com.kodilla.good.patterns.challenges.ecommerce.order.Basket;
import com.kodilla.good.patterns.challenges.ecommerce.User;

public interface InformationService {
    void inform(User user, Basket basket, boolean result);
}

package com.kodilla.good.patterns.challenges.Ecommerce.InformationService;

import com.kodilla.good.patterns.challenges.Ecommerce.Order.Basket;
import com.kodilla.good.patterns.challenges.Ecommerce.User;

public interface InformationService {
    void inform(User user, Basket basket);
}

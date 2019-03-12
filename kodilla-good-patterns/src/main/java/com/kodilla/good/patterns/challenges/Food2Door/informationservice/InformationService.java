package com.kodilla.good.patterns.challenges.Food2Door.informationservice;

import com.kodilla.good.patterns.challenges.Food2Door.User;
import com.kodilla.good.patterns.challenges.Food2Door.order.Order;

public interface InformationService {
    void inform(User user, Order order, boolean result);
}

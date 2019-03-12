package com.kodilla.good.patterns.challenges.Food2Door.order;

import com.kodilla.good.patterns.challenges.Food2Door.Product;
import com.kodilla.good.patterns.challenges.Food2Door.informationservice.InformationService;
import com.kodilla.good.patterns.challenges.Food2Door.orderrepository.InMemoryOrderRepository;
import com.kodilla.good.patterns.challenges.Food2Door.supply.*;
import com.kodilla.good.patterns.challenges.Food2Door.User;

public class OrderProcessor {


    public boolean processOrder(Order order, User user) {

        boolean result = order.getOrderedProduct().entrySet().stream()
                .allMatch(entry -> orderFromSupplier(entry.getKey().getSupplierId(), entry.getKey(), entry.getValue()));
        return result;
    }

    public boolean orderFromSupplier(int supplierId, Product product, int quantity) {

        boolean orderFromSupplier = false;

        switch (supplierId) {
            case 12:
                OrderFromSupplier orderFromExtraFoodShop = new OrderFromExtraFoodShop();
                orderFromSupplier = orderFromExtraFoodShop.process(product, quantity);
                break;
            case 142:
                OrderFromGlutenFreeShop orderFromGlutenFreeShop = new OrderFromGlutenFreeShop();
                orderFromSupplier = orderFromGlutenFreeShop.process(product, quantity);
                break;
            case 76:
                OrderFromHealthyShop orderFromHealthyShop = new OrderFromHealthyShop();
                orderFromSupplier = orderFromHealthyShop.process(product, quantity);
                break;
        }

        return orderFromSupplier;
    }

}

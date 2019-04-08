package com.kodilla.good.patterns.challenges.Food2Door.informationservice;

import com.kodilla.good.patterns.challenges.Food2Door.Product;
import com.kodilla.good.patterns.challenges.Food2Door.ProductOrderResult;
import com.kodilla.good.patterns.challenges.Food2Door.User;
import com.kodilla.good.patterns.challenges.Food2Door.order.Order;

import java.util.Map;

public class EmailConfirmationSender implements InformationService {

    public void inform(User user, Order order) {
        System.out.println("Właśnie złożyłeś zamówienie" + order.getOrderId() +
                ". Z opcją dostawy " + order.getDelivery() + ".");

        Map<Product, ProductOrderResult> orderedProducts = order.getOrderedProduct();
        for (Map.Entry<Product, ProductOrderResult> entry : orderedProducts.entrySet()) {
            boolean result = entry.getValue().isResult();
            System.out.println("Zamówienie na " + entry.getKey() + " " + entry.getValue().getPieces() + " szt."
                    + ((result) ? " zostało dodane." : " nie może być realizowane."));
        }


    }
}

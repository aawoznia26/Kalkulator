package com.kodilla.good.patterns.challenges.Food2Door.Order;

import com.kodilla.good.patterns.challenges.Food2Door.Product;
import com.kodilla.good.patterns.challenges.Food2Door.OrderRepository.ProductOrderRepository;
import com.kodilla.good.patterns.challenges.Food2Door.Supply.OrderFromExtraFoodShop;
import com.kodilla.good.patterns.challenges.Food2Door.Supply.OrderFromGlutenFreeShop;
import com.kodilla.good.patterns.challenges.Food2Door.Supply.OrderFromHealthyShop;
import com.kodilla.good.patterns.challenges.Food2Door.User;

public class OrderProcessor {

    ProductOrderRepository productOrderRepository = new ProductOrderRepository();

    public void processOrder(Order order, User user) {

        order.getOrderedProduct().entrySet().stream()
            .forEach(entry -> orderFromSupplier(entry.getKey().getSupplierId(), entry.getKey(), entry.getValue()));

        productOrderRepository.addOrderToRepository(order, user);

    }

    public boolean orderFromSupplier(int supplierId, Product product, int quantity) {

        boolean orderFromSupplier = false;

        switch (supplierId) {
            case 12:
                OrderFromExtraFoodShop orderFromExtraFoodShop = new OrderFromExtraFoodShop();
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

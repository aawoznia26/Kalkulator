package com.kodilla.good.patterns.challenges.Food2Door.order;

import com.kodilla.good.patterns.challenges.Food2Door.Product;
import com.kodilla.good.patterns.challenges.Food2Door.informationservice.InformationService;
import com.kodilla.good.patterns.challenges.Food2Door.orderrepository.InMemoryOrderRepository;
import com.kodilla.good.patterns.challenges.Food2Door.supply.*;
import com.kodilla.good.patterns.challenges.Food2Door.User;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderProcessor {

    private Map<Integer, OrderSupplier> supplierMap;

    public OrderProcessor(List<OrderSupplier> suppliers) {
        supplierMap = suppliers.stream()
                .collect(Collectors.toMap(OrderSupplier::getId, Function.identity()));
    }

    public void processOrder(Order order) {

        order.getOrderedProduct().entrySet().stream()
                .forEach(entry -> entry.getValue()
                        .setResult(orderFromSupplier(entry.getKey(), entry.getValue().getPieces())))
        ;

    }

    public boolean orderFromSupplier(Product product, int quantity) {
        OrderSupplier orderSupplier = supplierMap.get(product.getSupplierId());
        if (orderSupplier != null) {
            return orderSupplier.process(product, quantity);
        } else {
            return false;
        }

    }

}

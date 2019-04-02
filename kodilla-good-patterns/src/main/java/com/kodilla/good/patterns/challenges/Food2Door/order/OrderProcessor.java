package com.kodilla.good.patterns.challenges.Food2Door.order;

import com.kodilla.good.patterns.challenges.Food2Door.Product;
import com.kodilla.good.patterns.challenges.Food2Door.supply.OrderSupplier;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OrderProcessor {

    private Map<Integer, OrderSupplier> suppliersMap;

    public OrderProcessor(List<OrderSupplier> suppliers) {
        suppliersMap = suppliers.stream().collect(Collectors.toMap(OrderSupplier::getId, Function.identity()));
    }

    public boolean processOrder(Order order) {
        return order.getOrderedProduct().entrySet().stream()
                .allMatch(entry -> orderFromSupplier(entry.getKey(), entry.getValue()));
    }

    public boolean orderFromSupplier(Product product, int quantity) {
        final OrderSupplier orderSupplier = suppliersMap.get(product.getSupplierId());
        if (orderSupplier != null) {
            return orderSupplier.process(product, quantity);
        } else {
            return false;
        }
    }

}

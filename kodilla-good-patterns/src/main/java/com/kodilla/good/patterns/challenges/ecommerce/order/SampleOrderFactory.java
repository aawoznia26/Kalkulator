package com.kodilla.good.patterns.challenges.ecommerce.order;

import com.kodilla.good.patterns.challenges.ecommerce.Product;
import com.kodilla.good.patterns.challenges.ecommerce.User;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

public class SampleOrderFactory {

    public OrderRequest newOrderRequest() {
        User user = new User("Magda", "Kurowicka 67, 03-284 Gdańsk", "Kurowicka 67, 03-284 Gdańsk",
                "magdackaoed@gmail.com", "627-378-337");
        Map<Product, Integer> orderedProduct = new HashMap<>();
        orderedProduct.put(new Product("Vizir", 16.09), 4);
        orderedProduct.put(new Product("adidas LITE RACER REBORN", 87.67), 1);
        Instant orderDateAndTime = Instant.now();
        double promotion = 334.76;
        Delivery delivery = Delivery.KEX;

        return new OrderRequest(user, orderedProduct, orderDateAndTime, promotion, delivery);
    }

}

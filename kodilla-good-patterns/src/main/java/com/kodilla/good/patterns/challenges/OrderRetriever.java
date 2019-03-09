package com.kodilla.good.patterns.challenges;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class OrderRetriever {

    public OrderRequest newOrderRequest() {
        User user = new User("Magda", "Kurowicka 67, 03-284 Gdańsk", "Kurowicka 67, 03-284 Gdańsk",
                "magdackaoed@gmail.com", "627-378-337");
        Map<Product,Integer> orderedProduct = new HashMap<>();
        orderedProduct.put(new Product("Vizir", 16.09), 4);
        orderedProduct.put(new Product("adidas LITE RACER REBORN", 287.67), 1);
        LocalDateTime orderDateAndTime = LocalDateTime.of(2019, 3, 9, 12, 36);
        double promotion = 34.76;
        String delivery = "DPD";

        return new OrderRequest(user, orderedProduct, orderDateAndTime, promotion, delivery);
    }

}

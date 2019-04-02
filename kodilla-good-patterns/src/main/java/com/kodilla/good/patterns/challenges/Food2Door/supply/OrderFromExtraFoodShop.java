package com.kodilla.good.patterns.challenges.Food2Door.supply;

import com.kodilla.good.patterns.challenges.Food2Door.Product;

public class OrderFromExtraFoodShop implements OrderSupplier {

    @Override
    public int getId() {
        return 12;
    }

    public boolean process(Product product, int quantity) {
        int productId = product.getProductId();

        ExtraFoodShopOrder extraFoodShopOrder = new ExtraFoodShopOrder(productId, quantity);
        System.out.println("false ExtraFoodShop");
        return true;

    }
}

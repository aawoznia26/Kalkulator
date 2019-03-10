package com.kodilla.good.patterns.challenges.Ecommerce;

import com.kodilla.good.patterns.challenges.Ecommerce.Order.OrderProcessor;
import com.kodilla.good.patterns.challenges.Ecommerce.Order.OrderRequest;
import com.kodilla.good.patterns.challenges.Ecommerce.Order.OrderRetriever;
import com.kodilla.good.patterns.challenges.Ecommerce.Order.ProductOrderService;
import com.kodilla.good.patterns.challenges.Ecommerce.OrderRepository.ProductOrderRepository;

public class OrderApplication {
    public static void main(String[] args){
        OrderRetriever orderRetriever = new OrderRetriever();
        OrderRequest orderRequest = orderRetriever.newOrderRequest();

        OrderProcessor orderProcessor = new OrderProcessor(new InformationSender(),
                new ProductOrderRepository(), new ProductOrderService());
        orderProcessor.process(orderRequest);

    }

}

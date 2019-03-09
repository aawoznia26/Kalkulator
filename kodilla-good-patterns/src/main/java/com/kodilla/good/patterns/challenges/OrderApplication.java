package com.kodilla.good.patterns.challenges;

public class OrderApplication {
    public static void main(String[] args){
        OrderRetriever orderRetriever = new OrderRetriever();
        OrderRequest orderRequest = orderRetriever.newOrderRequest();

        OrderProcessor orderProcessor = new OrderProcessor(new InformationSender(),
                new ProductOrderRepository(), new ProductOrderService());
        orderProcessor.process(orderRequest);

    }

}

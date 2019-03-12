package com.kodilla.good.patterns.challenges.ecommerce;

import com.kodilla.good.patterns.challenges.ecommerce.informationservice.EmailConfirmationSender;
import com.kodilla.good.patterns.challenges.ecommerce.informationservice.InformationService;
import com.kodilla.good.patterns.challenges.ecommerce.order.OrderProcessor;
import com.kodilla.good.patterns.challenges.ecommerce.order.OrderRequest;
import com.kodilla.good.patterns.challenges.ecommerce.order.SampleOrderFactory;
import com.kodilla.good.patterns.challenges.ecommerce.order.RandomOrderServiceGenrator;
import com.kodilla.good.patterns.challenges.ecommerce.orderrepository.InMemoryOrderRepository;


public class OrderApplication {
    public static void main(String[] args) {
        InformationService informationService = new EmailConfirmationSender();
        InMemoryOrderRepository inMemoryOrderRepository = new InMemoryOrderRepository();
        RandomOrderServiceGenrator randomOrderServiceGenrator = new RandomOrderServiceGenrator();
        SampleOrderFactory sampleOrderFactory = new SampleOrderFactory();
        OrderRequest orderRequest = sampleOrderFactory.newOrderRequest();


        OrderProcessor orderProcessor = new OrderProcessor(informationService, inMemoryOrderRepository,
                randomOrderServiceGenrator, orderRequest);
        orderProcessor.process(orderRequest);

    }

}

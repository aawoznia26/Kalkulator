package com.kodilla.good.patterns.challenges.ecommerce;

import com.kodilla.good.patterns.challenges.ecommerce.informationservice.EmailConfirmationSender;
import com.kodilla.good.patterns.challenges.ecommerce.informationservice.InformationService;
import com.kodilla.good.patterns.challenges.ecommerce.order.BasketService;
import com.kodilla.good.patterns.challenges.ecommerce.order.BasketServiceImpl;
import com.kodilla.good.patterns.challenges.ecommerce.order.OrderProcessor;
import com.kodilla.good.patterns.challenges.ecommerce.order.OrderRequest;
import com.kodilla.good.patterns.challenges.ecommerce.order.OrderService;
import com.kodilla.good.patterns.challenges.ecommerce.order.RandomOrderServiceGenrator;
import com.kodilla.good.patterns.challenges.ecommerce.order.SampleOrderFactory;
import com.kodilla.good.patterns.challenges.ecommerce.orderrepository.InMemoryOrderRepository;
import com.kodilla.good.patterns.challenges.ecommerce.orderrepository.OrderRepository;


public class OrderApplication {
    public static void main(String[] args) {
        InformationService informationService = new EmailConfirmationSender();
        OrderRepository orderRepository = new InMemoryOrderRepository();

        OrderService orderService = new RandomOrderServiceGenrator();

        OrderRequest orderRequest = SampleOrderFactory.newOrderRequest();

        BasketService basketService = new BasketServiceImpl();


        OrderProcessor orderProcessor = new OrderProcessor(
                informationService,
                orderRepository,
                basketService,
                orderService
        );
        orderProcessor.process(orderRequest);

    }

}

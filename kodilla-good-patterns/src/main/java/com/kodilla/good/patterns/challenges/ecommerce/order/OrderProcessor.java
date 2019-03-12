package com.kodilla.good.patterns.challenges.ecommerce.order;

import com.kodilla.good.patterns.challenges.ecommerce.informationservice.InformationService;
import com.kodilla.good.patterns.challenges.ecommerce.orderrepository.InMemoryOrderRepository;
import com.kodilla.good.patterns.challenges.ecommerce.orderrepository.OrderRepository;

public class OrderProcessor {
    private InformationService informationService;
    private InMemoryOrderRepository inMemoryOrderRepository;
    private RandomOrderServiceGenrator randomOrderServiceGenrator;
    private OrderRequest orderRequest;


    public OrderProcessor(InformationService informationService, InMemoryOrderRepository inMemoryOrderRepository,
                          RandomOrderServiceGenrator randomOrderServiceGenrator,
                          OrderRequest orderRequest) {
        this.informationService = informationService;
        this.inMemoryOrderRepository = inMemoryOrderRepository;
        this.randomOrderServiceGenrator = randomOrderServiceGenrator;
        this.orderRequest = orderRequest;

    }

    public boolean process(final OrderRequest orderRequest) {
        OrderBuilder orderBuilder = new OrderBuilder(inMemoryOrderRepository);
        Basket basket = orderBuilder.buildBasket(orderRequest);
        boolean isOrdered = randomOrderServiceGenrator.order(basket);

        if (isOrdered) {
            inMemoryOrderRepository.addBasketToRepository(basket, orderRequest.getUser());
            informationService.inform(orderRequest.getUser(), basket, isOrdered);
            return true;
        } else {
            informationService.inform(orderRequest.getUser(), basket, isOrdered);
            return false;
        }
    }
}

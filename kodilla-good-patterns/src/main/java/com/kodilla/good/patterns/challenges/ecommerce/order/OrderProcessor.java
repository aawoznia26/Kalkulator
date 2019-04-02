package com.kodilla.good.patterns.challenges.ecommerce.order;

import com.kodilla.good.patterns.challenges.ecommerce.informationservice.InformationService;
import com.kodilla.good.patterns.challenges.ecommerce.orderrepository.InMemoryOrderRepository;
import com.kodilla.good.patterns.challenges.ecommerce.orderrepository.OrderRepository;

public class OrderProcessor {
    private InformationService informationService;
    private OrderRepository orderRepository;
    private BasketService basketService;
    private OrderService orderService;


    public OrderProcessor(InformationService informationService,
                          OrderRepository orderRepository,
                          BasketService basketService,
                          OrderService orderService) {
        this.informationService = informationService;
        this.orderRepository = orderRepository;
        this.basketService = basketService;
        this.orderService = orderService;

    }

    public boolean process(final OrderRequest orderRequest) {
        Basket basket = basketService.buildBasket(orderRequest);

        boolean isOrdered = orderService.order(basket);

        if (isOrdered) {
            orderRepository.addBasketToRepository(basket, orderRequest.getUser());
            informationService.inform(orderRequest.getUser(), basket, true);
            return true;
        } else {
            informationService.inform(orderRequest.getUser(), basket, false);
            return false;
        }
    }
}

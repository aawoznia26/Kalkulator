package com.kodilla.good.patterns.challenges.Ecommerce.Order;

import com.kodilla.good.patterns.challenges.Ecommerce.InformationService.InformationService;
import com.kodilla.good.patterns.challenges.Ecommerce.OrderRepository.OrderRepository;

public class OrderProcessor {
    private InformationService informationService;
    private OrderRepository orderRepository;
    private ProductOrderService productOrderService;
    private OrderRequest orderRequest;

    public OrderProcessor(InformationService informationService,
                          OrderRepository orderRepository, ProductOrderService productOrderService) {
        this.informationService = informationService;
        this.orderRepository = orderRepository;
        this.productOrderService = productOrderService;
        this.orderRequest = orderRequest;
    }


    public boolean process(final OrderRequest orderRequest) {
        OrderBuilder orderBuilder = new OrderBuilder();
        Basket basket = orderBuilder.buildBasket(orderRequest);
        boolean isOrdered = productOrderService.order(basket);

        if(isOrdered) {
            informationService.inform(orderRequest.getUser(), basket);
            orderRepository.addBasketToRepository(basket);
            return true;
        } else {
            return false;
        }
    }
}

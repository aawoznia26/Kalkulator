package com.kodilla.patterns2.decorator.pizza;

import java.math.BigDecimal;

public class NeighbourPromotionDecorator extends AbstractPizzaOrderDecorator {

    public NeighbourPromotionDecorator(PizzaOrder pizzaOrder) {
        super(pizzaOrder);
    }

    @Override
    public BigDecimal getCost(){
        return super.getCost().multiply(new BigDecimal(0.75));
    };

    @Override
    public String getDescription(){
        return super.getDescription() + " with 25% discount for neighbours";
    };
}

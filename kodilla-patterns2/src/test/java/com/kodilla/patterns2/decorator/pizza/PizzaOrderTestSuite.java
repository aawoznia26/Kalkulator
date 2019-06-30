package com.kodilla.patterns2.decorator.pizza;

import com.kodilla.patterns2.decorator.taxiportal.*;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

public class PizzaOrderTestSuite {

    @Test
    public void testPizzaDoubleCheesePepperoni(){

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new DoubleCheeseDecorator(pizzaOrder);
        pizzaOrder = new PepperoniDecorator(pizzaOrder);

        //When
        BigDecimal theCost = pizzaOrder.getCost();
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals(new BigDecimal(20), theCost);
        assertEquals("Pizza with cheese and tomato sauce + double cheese + pepperoni", description);
    }

    @Test
    public void testPizzaRucolaDrink(){

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new RucolaDecorator(pizzaOrder);
        pizzaOrder = new DrinkDecorator(pizzaOrder);

        //When
        BigDecimal theCost = pizzaOrder.getCost();
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals(new BigDecimal(26), theCost);
        assertEquals("Pizza with cheese and tomato sauce + rucola 1 liter drink", description);
    }

    @Test
    public void testPizzaRucolaDoubleCheeseNeighbour(){

        //Given
        PizzaOrder pizzaOrder = new BasicPizzaOrder();
        pizzaOrder = new RucolaDecorator(pizzaOrder);
        pizzaOrder = new DoubleCheeseDecorator(pizzaOrder);
        pizzaOrder = new NeighbourPromotionDecorator(pizzaOrder);

        //When
        BigDecimal theCost = pizzaOrder.getCost();
        String description = pizzaOrder.getDescription();

        //Then
        assertEquals(new BigDecimal(15.00).ROUND_UNNECESSARY, theCost.ROUND_UNNECESSARY);
        assertEquals("Pizza with cheese and tomato sauce + rucola + double cheese with 25% discount for neighbours", description);;
    }

}

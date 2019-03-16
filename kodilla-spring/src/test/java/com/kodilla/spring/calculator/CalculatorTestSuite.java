package com.kodilla.spring.calculator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class CalculatorTestSuite {
    @Test
    public void testCalculations() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        int a = 7;
        int b = 4;
        //When
        double c = calculator.add(a, b);
        double d = calculator.sub(a, b);
        double e = calculator.mul(a, b);
        double f = calculator.div(a, b);

        double[] expected = {11, 3, 28, 1.75};
        double[] counted = {c, d, e,f};
        //Then
        Assert.assertArrayEquals(expected, counted, 0.01);
    }

}

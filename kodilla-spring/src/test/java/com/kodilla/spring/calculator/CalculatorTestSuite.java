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
    public void testAdd() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        int a = 7;
        int b = 4;
        //When
        double c = calculator.add(a, b);
        //Then
        Assert.assertEquals(11,c, 0.01);
    }

    @Test
    public void testSub() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        int a = 7;
        int b = 4;
        //When
        double d = calculator.sub(a, b);
        //Then
        Assert.assertEquals(3, d, 0.01);
    }

    @Test
    public void testMul() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        int a = 7;
        int b = 4;
        //When
        double e = calculator.mul(a, b);
        //Then
        Assert.assertEquals(28, e, 0.01);
    }

    @Test
    public void testDiv() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        Calculator calculator = context.getBean(Calculator.class);
        int a = 7;
        int b = 4;
        //When
        double f = calculator.div(a, b);
        //Then
        Assert.assertEquals(1.75, f, 0.01);
    }

}

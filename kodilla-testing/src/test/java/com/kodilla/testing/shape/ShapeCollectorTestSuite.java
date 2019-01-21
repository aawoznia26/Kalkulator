package com.kodilla.testing.shape;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.util.ArrayList;
import java.util.List;


public class ShapeCollectorTestSuite {

    @Rule
    public TestWatcher watcherStarting = new TestWatcher() {
        @Override
        protected void starting(Description description) {
            System.out.println("Starting test: " + description.getMethodName());
        }
    };

    @Rule
    public TestWatcher watcherFinished = new TestWatcher() {
        @Override
        protected void finished(Description description) {
            System.out.println("Finished test: " + description.getMethodName());
        }
    };

    @Test
    public void testAddFigure() {
        //Given
        Circle circle1 = new Circle(5.76);
        ShapeCollector shapeCollector = new ShapeCollector();
        //When
        shapeCollector.addFigure(circle1);
        //Then
        Assert.assertEquals(shapeCollector.listSize(),1);
    }

    @Test
    public void testRemoveNotExistingFigure() {
        //Given
        Circle circle1 = new Circle(5.76);
        ShapeCollector shapeCollector = new ShapeCollector();

        //When
        boolean result = shapeCollector.removeFigure(circle1);
        //Then
        Assert.assertFalse(result);
    }

    @Test
    public void testGetFigure() {
        //Given
        Circle circle1 = new Circle(5.76);
        ShapeCollector shapeCollector = new ShapeCollector();

        //When
        shapeCollector.addFigure(circle1);
        Shape result = shapeCollector.getFigure(0);
        //Then
        Assert.assertEquals(circle1, result);
    }

    @Test
    public void testShowFigures() {
        //Given
        Circle circle1 = new Circle(5.76);
        Triangle triangle1 = new Triangle(3.98, 7.9);
        ShapeCollector shapeCollector = new ShapeCollector();
        List<Shape> expected = new ArrayList<Shape>();

        //When
        shapeCollector.addFigure(circle1);
        shapeCollector.addFigure(triangle1);
        expected.add(circle1);
        expected.add(triangle1);
        List<Shape> result = shapeCollector.showFigures();

        //Then
        Assert.assertEquals(expected, result);
    }
}

package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void testCreatingPaintingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        boolean ifExecuted = taskFactory.executeTask(KindOfTask.PAINTING);

        //Then
        Assert.assertTrue(ifExecuted);
    }

    @Test
    public void testCreatingShoppingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        boolean ifExecuted = taskFactory.executeTask(KindOfTask.SHOPPING);

        //Then
        Assert.assertTrue(ifExecuted);
    }

    @Test
    public void testCreatingDrivingTask(){
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        boolean ifExecuted = taskFactory.executeTask(KindOfTask.DRIVING);

        //Then
        Assert.assertTrue(ifExecuted);
    }
}

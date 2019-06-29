package com.kodilla.patterns.factory.tasks;

import org.junit.Assert;
import org.junit.Test;

public class TaskFactoryTestSuite {

    @Test
    public void testCreatingPaintingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task task = taskFactory.executeTask(KindOfTask.PAINTING);
        boolean ifExecuted = task.executeTask();

        //Then
        Assert.assertTrue(ifExecuted);
    }

    @Test
    public void testCreatingShoppingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task task = taskFactory.executeTask(KindOfTask.SHOPPING);
        boolean ifExecuted = task.executeTask();

        //Then
        Assert.assertTrue(ifExecuted);
    }

    @Test
    public void testCreatingDrivingTask() {
        //Given
        TaskFactory taskFactory = new TaskFactory();
        //When
        Task task = taskFactory.executeTask(KindOfTask.DRIVING);
        boolean ifExecuted = task.executeTask();

        //Then
        Assert.assertTrue(ifExecuted);
    }
}

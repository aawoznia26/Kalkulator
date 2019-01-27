package com.kodilla.stream.array;

import org.junit.Assert;
import org.junit.Test;

import static com.kodilla.stream.array.ArrayOperations.getAverage;

public class ArrayOperationsTestSuite {
    @Test

    public void testGetAverage(){
        //Given
        int[] numbers ={4,3,2,4};
        //When
        double calculatedResult = getAverage(numbers);
        double expectedResult = 3.25;
        //Then
        Assert.assertEquals(expectedResult,calculatedResult, 0.01);


    }
}

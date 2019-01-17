package com.kodilla.testing.collection;

import javafx.beans.binding.When;
import org.junit.Assert;
import org.junit.Test;
import com.kodilla.testing.collection.OddNumbersExterminator;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {


    @Test
    public void testOddNumbersExterminatorEmptyList(){
        //Given
        List<Integer> normalList = new ArrayList<Integer>();

        List<Integer> expectedResult = new ArrayList<Integer>();

        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        ArrayList<Integer> result = oddNumbersExterminator.exterminate((ArrayList<Integer>) normalList);
        //Then
        Assert.assertEquals(expectedResult,result);

    }

    @Test
    public void testOddNumbersExterminatorNormalList(){
        //Given
        List<Integer> normalList = new ArrayList<Integer>();
        normalList.add(7);
        normalList.add(34);
        normalList.add(214);
        normalList.add(93);

        List<Integer> expectedResult = new ArrayList<Integer>();
        expectedResult.add(34);
        expectedResult.add(214);

        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        ArrayList<Integer> result = oddNumbersExterminator.exterminate((ArrayList<Integer>) normalList);
        //Then
        Assert.assertEquals(expectedResult,result);

    }
}

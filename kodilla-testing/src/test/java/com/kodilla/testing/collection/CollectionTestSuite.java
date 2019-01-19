package com.kodilla.testing.collection;

import javafx.beans.binding.When;
import org.junit.*;
import com.kodilla.testing.collection.OddNumbersExterminator;
import org.junit.rules.MethodRule;
import org.junit.rules.TestWatcher;
import org.junit.rules.TestWatchman;
import org.junit.runner.Description;
import org.junit.runners.model.FrameworkMethod;

import java.util.ArrayList;
import java.util.List;

public class CollectionTestSuite {

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
            System.out.println("Starting test: " + description.getMethodName());
        }
    };

    @Test
    public void testOddNumbersExterminatorEmptyList(){


        //Given
        List<Integer> normalList = new ArrayList<Integer>();

        List<Integer> expectedResult = new ArrayList<Integer>();

        OddNumbersExterminator oddNumbersExterminator = new OddNumbersExterminator();
        //When
        ArrayList<Integer> result = oddNumbersExterminator.exterminate((ArrayList<Integer>) normalList);
        //Then
        if(result.size()==0) {
        };

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

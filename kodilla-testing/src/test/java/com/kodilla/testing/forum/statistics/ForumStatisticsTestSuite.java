package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.Infinity;
import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {

    @Test
    public void test0Posts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users = new ArrayList<String>();
        for(int i =0; i<100; i++) {
            users.add("a");
        }
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(1000);

        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        double[] expected = {100.0, 1000.0, 1000.0, 10.0, 10.0, 1.0 };

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        double[] statistics = calculateStatistics.showStatistics();

        //Then
        Assert.assertArrayEquals(expected, statistics,0.005);

    }

    @Test
    public void test1000Posts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users = new ArrayList<String>();
        for(int i =0; i<100; i++) {
            users.add("a");
        }
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(1000);

        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        double[] expected = {100.0, 1000.0, 1000.0, 10.0, 10.0, 1.0 };

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        double[] statistics = calculateStatistics.showStatistics();

        //Then
        Assert.assertArrayEquals(expected, statistics,0.005);

    }

    @Test
    public void test0Coments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users = new ArrayList<String>();
        for(int i =0; i<100; i++) {
            users.add("a");
        }
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(0);

        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        double[] expected = {100.0, 1000.0, 0.0, 10.0, 0.0, 0.0 };

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        double[] statistics = calculateStatistics.showStatistics();

        //Then
        Assert.assertArrayEquals(expected, statistics,0.005);

    }

    @Test
    public void testLessCommentsThanPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users = new ArrayList<String>();
        for(int i =0; i<100; i++) {
            users.add("a");
        }
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(354);

        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        double[] expected = {100.0, 1000.0, 354.0, 10.0, 3.54, 0.35 };

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        double[] statistics = calculateStatistics.showStatistics();

        //Then
        Assert.assertArrayEquals(expected, statistics,0.005);

    }

    @Test
    public void testMoreCommentsThanPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users = new ArrayList<String>();
        for(int i =0; i<100; i++) {
            users.add("a");
        }
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(4700);

        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        double[] expected = {100.0, 1000.0, 4700.0, 10.00, 47.00, 4.7 };

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        double[] statistics = calculateStatistics.showStatistics();

        //Then
        Assert.assertArrayEquals(expected, statistics,0.005);

    }

    @Test
    public void test0Users() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users = new ArrayList<String>();

        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(1000);

        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        double[] expected = {0.0, 1000.0, 1000.0, Infinity, Infinity, 1.0 };

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        double[] statistics = calculateStatistics.showStatistics();

        //Then
        Assert.assertArrayEquals(expected, statistics,0.005);

    }

    @Test
    public void test100Users() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> users = new ArrayList<String>();
        for(int i =0; i<100; i++) {
            users.add("a");
        }
        when(statisticsMock.usersNames()).thenReturn(users);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(1000);

        CalculateStatistics calculateStatistics = new CalculateStatistics(statisticsMock);
        double[] expected = {100.0, 1000.0, 1000.0, 10.0, 10.0, 1.0 };

        //When
        calculateStatistics.calculateAdvStatistics(statisticsMock);
        double[] statistics = calculateStatistics.showStatistics();

        //Then
        Assert.assertArrayEquals(expected, statistics,0.005);


    }

}

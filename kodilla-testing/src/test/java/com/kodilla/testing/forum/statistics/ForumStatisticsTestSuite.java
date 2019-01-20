package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ForumStatisticsTestSuite {

    @Test
    public void testCounts() {
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
        Assert.assertArrayEquals(expected, statistics,0.00);

    }

}

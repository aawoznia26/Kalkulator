package com.kodilla.patterns.singleton;

import org.junit.Assert;
import org.junit.Test;

public class LoggerTestSuite {

    @Test
    public void testGettingLastLog() {
        //Given
        //When
        String log = "This is the last log";
        Logger.getInstance().log(log);
        //Then
        Assert.assertEquals("This is the last log", Logger.getInstance().getLastLog());
    }


}

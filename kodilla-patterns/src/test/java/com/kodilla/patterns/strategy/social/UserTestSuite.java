package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publisher.SnapchatPublisher;
import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {

    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User millenials = new Millenials("Piotrek");
        User generationY = new YGeneration("Franek");
        User generationZ = new ZGeneration("Maciek");
        //When
        String millenialsDefaultPublisher = millenials.sharePost();
        String generationYDefaultPublisher = generationY.sharePost();
        String generationZDefaultPublisher = generationZ.sharePost();
        //Then
        Assert.assertEquals("Facebook", millenialsDefaultPublisher);
        Assert.assertEquals("Twitter", generationYDefaultPublisher);
        Assert.assertEquals("Snapchat", generationZDefaultPublisher);

    }

    @Test()
    public void testIndividualSharingStrategy() {
        //Given
        User millenials = new Millenials("Piotrek");
        //When
        String millenialsDefaultPublisher = millenials.sharePost();
        millenials.setSocialPublisher(new SnapchatPublisher());
        String millenialsSetPublisher = millenials.sharePost();
        //Then
        Assert.assertEquals("Facebook", millenialsDefaultPublisher);
        Assert.assertEquals("Snapchat", millenialsSetPublisher);


    }
}

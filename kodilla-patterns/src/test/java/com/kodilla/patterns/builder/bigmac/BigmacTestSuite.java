package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {

    @Test
    public void testBuildingBigmac() {

        //Given
        Bigmac bigmac = new Bigmac.BurgerBuilder(Bun.SESAME, 2)
                .ingredient(Ingredients.JALAPENO)
                .sauce(Sauce.CLASSIC)
                .ingredient(Ingredients.ONION)
                .ingredient(Ingredients.PICKLE)
                .build();

        //When
        int howManyIngredients = bigmac.getIngrediens().size();

        //Then
        Assert.assertEquals(3,howManyIngredients);

    }

}

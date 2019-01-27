package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {

    @Test
    public void testGetPeopleQuantity(){

        //Given
        BigDecimal peopleQuantity1 = new BigDecimal(48958159);
        BigDecimal peopleQuantity2 = new BigDecimal(38476269);
        BigDecimal peopleQuantity3 = new BigDecimal(39570125);
        BigDecimal peopleQuantity4 = new BigDecimal(21529967);
        BigDecimal peopleQuantity5 = new BigDecimal(31304016);
        BigDecimal peopleQuantity6 = new BigDecimal(96160163);
        BigDecimal peopleQuantity7 = new BigDecimal(326625791);
        BigDecimal peopleQuantity8 = new BigDecimal(207353391);
        BigDecimal peopleQuantity9 = new BigDecimal(190632261);
        BigDecimal peopleQuantity10 = new BigDecimal(1281935911);

        Country spain = new Country("Hiszpania", peopleQuantity1);
        Country poland = new Country("Polska", peopleQuantity2);
        Country uganda = new Country("Uganda", peopleQuantity3);
        Country romania = new Country("Rumunia", peopleQuantity4);
        Country venezuela = new Country("Wenezuela", peopleQuantity5);
        Country vietnam = new Country("Wietnam", peopleQuantity6);
        Country usa = new Country("Stany Zjednoczone", peopleQuantity7);
        Country brazyl = new Country("Brazylia", peopleQuantity8);
        Country nigeria = new Country("Nigeria", peopleQuantity9);
        Country india = new Country("Indie", peopleQuantity10);

        Continent europe = new Continent("Europa");
        Continent asia = new Continent("Azja");
        Continent africa = new Continent("Afryka");
        Continent northAmerica = new Continent("Ameryka Południowa");
        Continent southAmerica = new Continent("Ameryka Północna");


        //When
        World world = new World();
        world.addContinent(europe);
        world.addContinent(asia);
        world.addContinent(africa);
        world.addContinent(northAmerica);
        world.addContinent(southAmerica);

        europe.addCountry(spain);
        europe.addCountry(poland);
        europe.addCountry(romania);
        africa.addCountry(uganda);
        africa.addCountry(nigeria);
        northAmerica.addCountry(venezuela);
        northAmerica.addCountry(brazyl);
        asia.addCountry(vietnam);
        asia.addCountry(india);
        southAmerica.addCountry(usa);

        BigDecimal worldPeopleSum = world.getPeopleQuantity();

        //Then
        BigDecimal expectedResult = new BigDecimal("2282546053");
        Assert.assertEquals(expectedResult, worldPeopleSum);
    }

}

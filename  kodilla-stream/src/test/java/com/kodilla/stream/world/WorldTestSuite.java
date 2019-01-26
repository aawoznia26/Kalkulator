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

        Country country1 = new Country("Hiszpania", peopleQuantity1);
        Country country2 = new Country("Polska", peopleQuantity2);
        Country country3 = new Country("Uganda", peopleQuantity3);
        Country country4 = new Country("Rumunia", peopleQuantity4);
        Country country5 = new Country("Wenezuela", peopleQuantity5);
        Country country6 = new Country("Wietnam", peopleQuantity6);
        Country country7 = new Country("Stany Zjednoczone", peopleQuantity7);
        Country country8 = new Country("Brazylia", peopleQuantity8);
        Country country9 = new Country("Nigeria", peopleQuantity9);
        Country country10 = new Country("Indie", peopleQuantity10);

        Continent continent1 = new Continent("Europa");
        Continent continent2 = new Continent("Azja");
        Continent continent3 = new Continent("Afryka");
        Continent continent4 = new Continent("Ameryka Południowa");
        Continent continent5 = new Continent("Ameryka Północna");


        //When
        World world = new World();
        world.addContinent(continent1);
        world.addContinent(continent2);
        world.addContinent(continent3);
        world.addContinent(continent4);
        world.addContinent(continent5);

        continent1.addCountry(country1);
        continent1.addCountry(country2);
        continent1.addCountry(country4);
        continent3.addCountry(country3);
        continent3.addCountry(country9);
        continent4.addCountry(country5);
        continent4.addCountry(country8);
        continent2.addCountry(country6);
        continent2.addCountry(country10);
        continent5.addCountry(country7);

        BigDecimal worldPeopleSum = world.getPeopleQuantity();

        //Then
        BigDecimal expectedResult = new BigDecimal("2282546053");
        Assert.assertEquals(expectedResult, worldPeopleSum);
    }

}

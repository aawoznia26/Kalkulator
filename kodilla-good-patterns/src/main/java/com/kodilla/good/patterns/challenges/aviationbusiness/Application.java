package com.kodilla.good.patterns.challenges.aviationbusiness;

import com.kodilla.good.patterns.challenges.aviationbusiness.informationservice.InformationService;
import com.kodilla.good.patterns.challenges.aviationbusiness.informationservice.ResultDisplayer;
import com.kodilla.good.patterns.challenges.aviationbusiness.repository.InMemoryFlightRepository;
import com.kodilla.good.patterns.challenges.aviationbusiness.search.DesiredSearch;
import com.kodilla.good.patterns.challenges.aviationbusiness.search.FlightFinder;
import com.kodilla.good.patterns.challenges.aviationbusiness.search.SearchProcessor;

import java.util.List;

public class Application {


    public static void main(String args[]) {

        InMemoryFlightRepository inMemoryFlightRepository = new InMemoryFlightRepository();
        FlightFinder flightFinder = new FlightFinder(inMemoryFlightRepository);


        SearchProcessor searchProcessor = new SearchProcessor(flightFinder);
        DesiredSearch desiredSearch = DesiredSearch.DIRECT;
        List<Flight> searchResult = searchProcessor.search(desiredSearch, "Lisbona", "Madryt");
        InformationService informationService = new ResultDisplayer(searchResult, inMemoryFlightRepository);


    }

}

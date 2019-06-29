package com.kodilla.good.patterns.challenges.aviationbusiness.informationservice;

import com.kodilla.good.patterns.challenges.aviationbusiness.Flight;
import com.kodilla.good.patterns.challenges.aviationbusiness.repository.InMemoryFlightRepository;
import com.kodilla.good.patterns.challenges.aviationbusiness.search.DesiredSearch;

import java.util.List;

public class ResultDisplayer implements InformationService {
    private List<Flight> searchResult;
    private InMemoryFlightRepository inMemoryFlightRepository;

    public ResultDisplayer(List<Flight> searchResult, InMemoryFlightRepository inMemoryFlightRepository) {
        this.searchResult = searchResult;
        this.inMemoryFlightRepository = inMemoryFlightRepository;
    }

    public void inform() {
        System.out.println("Loty jakie dla Ciebie znaleźliśmy:");

        for (Flight flight : searchResult) {
            System.out.println(flight);
            inMemoryFlightRepository.getFlightsWithAttributesStream()
                    .filter(k -> k.getKey().equals(flight))
                    .flatMap(v -> v.getValue().stream())
                    .forEach(a -> System.out.println(" z liniami " + a.getAirlines() + ". Koszt podróży: " + a.getCost() + " zł. Czas lotu: " + a.getDuration().toString().substring(2)));
        }
    }

}

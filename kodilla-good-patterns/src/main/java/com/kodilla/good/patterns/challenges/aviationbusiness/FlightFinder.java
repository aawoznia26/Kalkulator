package com.kodilla.good.patterns.challenges.aviationbusiness;

import com.kodilla.good.patterns.challenges.aviationbusiness.repository.InMemoryFlightRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class FlightFinder {

    public Map<Departure, Destination> findAllFlightsToDestinationAirport(String destinationAirport, InMemoryFlightRepository inMemoryFlightRepository) {

        Map<Departure, Destination> result = null;
        final Map<Departure, Destination> collect = inMemoryFlightRepository.getFlightMap().entrySet().stream()
                .filter(entry -> entry.getValue().stream().anyMatch(v -> v.equals(destinationAirport)))
                .collect(toMap(k -> k.getKey(), v -> v.getValue().stream().filter(h -> h.equals(destinationAirport))
                        .findAny().get()));


        return result;

    }



    public List<Destination> findAllFlightsFromDepartureAirport(String departureAirport, InMemoryFlightRepository inMemoryFlightRepository) {

        List<Destination> result = inMemoryFlightRepository.getFlightMap().get(departureAirport);
        return result;
    }

}

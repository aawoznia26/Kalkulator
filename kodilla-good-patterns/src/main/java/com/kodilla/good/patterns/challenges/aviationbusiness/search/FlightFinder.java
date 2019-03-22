package com.kodilla.good.patterns.challenges.aviationbusiness.search;

import com.kodilla.good.patterns.challenges.aviationbusiness.Flight;
import com.kodilla.good.patterns.challenges.aviationbusiness.repository.InMemoryFlightRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

public class FlightFinder {

    private InMemoryFlightRepository inMemoryFlightRepository;

    public FlightFinder(InMemoryFlightRepository inMemoryFlightRepository) {
        this.inMemoryFlightRepository = inMemoryFlightRepository;
    }

    public List<Flight> findAllFlightsToArrivalAirport(String arrivalAirport) {

        List<Flight> result = inMemoryFlightRepository.getFlights()
                .filter(k -> k.getArrivalAirport().equals(arrivalAirport))
                .collect(toList());
        return result;
    }


    public List<Flight> findAllFlightsFromDepartureAirport(String departureAirport) {

        List<Flight> result = inMemoryFlightRepository.getFlights()
                .filter(k -> k.getDepartureAirport().equals(departureAirport))
                .collect(toList());
        return result;
    }

    public List<Flight> findOnlyDirectFlight(Flight flight) {

        List<Flight> result = new ArrayList<>();
        if (inMemoryFlightRepository.isFlightPossible(flight)) {
            result.add(flight);
        }
        return result;
    }


    public List<Flight> findFilght(Flight flight) {

        String searchDepartureAirport = flight.getDepartureAirport();
        String searchArrivalAirport = flight.getArrivalAirport();
        List<Flight> result = new ArrayList<>();

        boolean isDeparturePossible = findAllFlightsFromDepartureAirport(searchDepartureAirport).size() > 0;
        boolean isArrivalPossible = findAllFlightsToArrivalAirport(searchArrivalAirport).size() > 0;
        boolean isDirectFlightPossible = findOnlyDirectFlight(flight).size() > 0;

        if (isDeparturePossible && isArrivalPossible && isDirectFlightPossible) {
            result.add(flight);
            return result;
        } else {
            List<Flight> flightsFromDepartureAirport = inMemoryFlightRepository.getFlights()
                    .filter(s -> s.getDepartureAirport().equals(searchDepartureAirport))
                    .collect(toList());

            List<Flight> indiresctFlights = flightsFromDepartureAirport.stream()
                    .map(d -> findFilght(new Flight(d.getArrivalAirport(), searchArrivalAirport)))
                    .flatMap(d -> d.stream())
                    .collect(toList());

            result = Stream.concat(flightsFromDepartureAirport.stream(), indiresctFlights.stream())
                    .collect(Collectors.toList());

            for (int i = 1; i < result.size(); i++) {
                String airport = result.get(i - 1).getArrivalAirport();
                String nextDepartureAirport = result.get(i).getDepartureAirport();
                if (!airport.equals(nextDepartureAirport)) {
                    result.remove(i - 1);
                }
            }
            return result;
        }
    }

}




package com.kodilla.good.patterns.challenges.aviationbusiness.repository;

import com.kodilla.good.patterns.challenges.aviationbusiness.Flight;
import com.kodilla.good.patterns.challenges.aviationbusiness.FlightAttributes;

import java.time.Duration;
import java.util.*;
import java.util.stream.Stream;

public class InMemoryFlightRepository implements FlightRepository {

    private Map<Flight, List<FlightAttributes>> flightMap = new HashMap<>();

    public InMemoryFlightRepository() {

        Flight flight1 = new Flight("Paryż", "Lisbona");
        Flight flight2 = new Flight("Lwów", "Warszawa-Modlin");
        Flight flight3 = new Flight("Berlin", "Gdańsk");
        Flight flight4 = new Flight("Lisbona", "Madryt");
        Flight flight5 = new Flight("Rzym", "Paryż");
        Flight flight6 = new Flight("Paryż", "Berlin");
        Flight flight7 = new Flight("Madryt", "Gdańsk");

        FlightAttributes flightAttribute1 = new FlightAttributes("KLM", 453.76, Duration.ofMinutes(561));
        FlightAttributes flightAttribute2 = new FlightAttributes("Wizz Air", 1233, Duration.ofMinutes(432));
        FlightAttributes flightAttribute3 = new FlightAttributes("PL LOT", 234.90, Duration.ofMinutes(125));
        FlightAttributes flightAttribute4 = new FlightAttributes("Lufthansa", 100, Duration.ofMinutes(345));
        FlightAttributes flightAttribute5 = new FlightAttributes("Rayanair", 234.32, Duration.ofMinutes(87));
        FlightAttributes flightAttribute6 = new FlightAttributes("Lufthansa", 335.22, Duration.ofMinutes(234));
        FlightAttributes flightAttribute7 = new FlightAttributes("easyJet", 1234, Duration.ofMinutes(186));

        flightMap.put(flight1, Arrays.asList(flightAttribute2, flightAttribute6, flightAttribute7));
        flightMap.put(flight2, Arrays.asList(flightAttribute1, flightAttribute3, flightAttribute4));
        flightMap.put(flight3, Arrays.asList(flightAttribute1));
        flightMap.put(flight4, Arrays.asList(flightAttribute5, flightAttribute6));
        flightMap.put(flight5, Arrays.asList(flightAttribute3, flightAttribute4, flightAttribute6, flightAttribute7));
        flightMap.put(flight6, Arrays.asList(flightAttribute2, flightAttribute4, flightAttribute6));
        flightMap.put(flight7, Arrays.asList(flightAttribute3));

    }

    public Map<Flight, List<FlightAttributes>> getFlightMap() {
        return flightMap;
    }

    public void addFlightToRepository(Flight flight, FlightAttributes flightAttributes) {
        if (flightMap.get(flight) == null) {
            flightMap.put(flight, new ArrayList<>());
        }
        final List<FlightAttributes> theFlightAttributes = flightMap.get(flight);
        theFlightAttributes.add(flightAttributes);

    }

    public Stream<Flight> getFlights() {
        Stream<Flight> flightStream = flightMap.entrySet().stream()
                .map(s -> s.getKey());
        return flightStream;
    }

    public Stream<Map.Entry<Flight, List<FlightAttributes>>> getFlightsWithAttributesStream() {
        Stream<Map.Entry<Flight, List<FlightAttributes>>> flightsWithAttributes = flightMap.entrySet().stream();
        return flightsWithAttributes;
    }

    public boolean isFlightPossible(Flight flight) {
        boolean ifFlightIsPossible = flightMap.containsKey(flight);
        return ifFlightIsPossible;

    }

}

package com.kodilla.good.patterns.challenges.aviationbusiness.repository;

import com.kodilla.good.patterns.challenges.aviationbusiness.Departure;
import com.kodilla.good.patterns.challenges.aviationbusiness.Destination;

import java.util.*;

public class InMemoryFlightRepository implements FlightRepository{

    private Map<Departure, List<Destination>> flightMap = new HashMap<>();

    public InMemoryFlightRepository() {

        Destination destination1 = new Destination("Paryż", "KLM", 568.98);
        Destination destination2 = new Destination("Lwów", "Wizz Air", 568.98);
        Destination destination3 = new Destination("Kraków", "PL LOT", 568.98);
        Destination destination4 = new Destination("Lisbona", "Lufthansa", 568.98);
        Destination destination5 = new Destination("Rzym", "Rayanair", 568.98);
        Destination destination6 = new Destination("Londyn", "Lufthansa", 568.98);
        Destination destination7 = new Destination("Neapol", "easyJet", 568.98);

        Departure departure1 = new Departure("Ovda");
        Departure departure2 = new Departure("Warszawa-Modlin");
        Departure departure3 = new Departure("Lwów");
        Departure departure4 = new Departure("Madryt");
        Departure departure5 = new Departure("Paryż");
        Departure departure6 = new Departure("Gdańsk");
        Departure departure7 = new Departure("Neapol");

        flightMap.put(departure1, Arrays.asList(destination2, destination6, destination7));
        flightMap.put(departure2, Arrays.asList(destination1, destination3, destination4));
        flightMap.put(departure3, Arrays.asList(destination1));
        flightMap.put(departure4, Arrays.asList(destination5, destination6));
        flightMap.put(departure5, Arrays.asList(destination3, destination4, destination6, destination7));
        flightMap.put(departure6, Arrays.asList(destination2, destination4, destination6));
        flightMap.put(departure7, Arrays.asList(destination3));

    }

    public Map<Departure, List<Destination>> getFlightMap() {
        return flightMap;
    }

    public void addFlightToRepository(Departure departure, Destination destination) {
        if (flightMap.get(departure) == null) {
            flightMap.put(departure, new ArrayList<>());
        }
        final List<Destination> destinations = flightMap.get(departure);
        destinations.add(destination);

    }


}

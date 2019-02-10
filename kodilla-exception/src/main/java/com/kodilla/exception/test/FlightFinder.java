package com.kodilla.exception.test;

import java.util.*;

public class FlightFinder {

    public boolean findFilght(Flight flight, Map<String, List<String>> flightMap) throws Exception {
        String searchDepartureAirport = flight.getDepartureAirport();
        String searchArrivalAirport = flight.getArrivalAirport();

        boolean isDirectFlightPossible = flightMap.get(searchDepartureAirport).contains(searchArrivalAirport);
        if (isDirectFlightPossible) {
            return true;
        } else {
            for (String theAirport : flightMap.get(searchDepartureAirport)) {
                if (findFilght(new Flight(theAirport, searchArrivalAirport), flightMap)) {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String args[]) throws Exception {

        FlightFinder flightFinder = new FlightFinder();
        Flight flight1 = new Flight("Madryt", "Londyn");

        Map<String, List<String>> flightMap = new HashMap<>();
        flightMap.put("Warszawa-Modlin", Arrays.asList("Paryż", "Londyn", "Kraków"));
        flightMap.put("Ovda", Arrays.asList("Mińsk", "Londyn", "Neapol"));
        flightMap.put("Oslo-Torp", Arrays.asList("Rzym", "Lisbona", "Lwów"));
        flightMap.put("Lwów", Arrays.asList("Oslo-Torp", "Londyn", "Lisbona"));
        flightMap.put("Madryt", Arrays.asList("Warszawa-Modlin", "Gdańsk"));
        try {
            boolean result = flightFinder.findFilght(flight1, flightMap);
            System.out.println(result);
        } catch (NullPointerException e) {
            System.out.println("Wyszukiwany lot nie istnieje");
        } finally {
            System.out.println("Wyszukiwanie zakończone");
        }
    }
}

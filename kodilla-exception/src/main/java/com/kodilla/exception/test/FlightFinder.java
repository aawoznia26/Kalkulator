package com.kodilla.exception.test;

import java.util.*;

import static java.util.stream.Collectors.toList;

public class FlightFinder {

    public boolean findFilght(Flight flight, Map<String, List<String>> flightMap) throws Exception {
        String searchDepartureAirport = flight.getDepartureAirport();
        String searchArrivalAirport = flight.getArrivalAirport();
        boolean isDeparturePossible = false;
        boolean isArrivalPossible = false;


        try {
            isDeparturePossible = flightMap.containsKey(searchDepartureAirport);

        } catch (NullPointerException e) {
            System.out.println("Wylot niemożliwy");
            return false;
        }
        isArrivalPossible = checkArrival(flightMap, searchArrivalAirport);

        if (isDeparturePossible && isArrivalPossible) {
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

        }
        return false;
    }


    public boolean checkArrival(Map<String, List<String>> flightMap, String searchArrivalAirport) {

        List<String> result = flightMap.entrySet().stream()
                .flatMap(x -> x.getValue().stream())
                .filter(a -> a.equals(searchArrivalAirport))
                .collect(toList());
        if (result.size() > 0) {
            return true;
        }
        return false;
    }


    public static void main(String args[]) throws Exception {

        FlightFinder flightFinder = new FlightFinder();
        Flight flight1 = new Flight("Ovda", "Warszawa-Modlin");

        Map<String, List<String>> flightMap = new HashMap<>();
        flightMap.put("Warszawa-Modlin", Arrays.asList("Paryż", "Lwów", "Kraków"));
        flightMap.put("Ovda", Arrays.asList("Mińsk", "Londyn", "Neapol"));
        flightMap.put("Oslo-Torp", Arrays.asList("Rzym", "Lisbona", "Lwów"));
        flightMap.put("Lwów", Arrays.asList("Oslo-Torp", "Londyn", "Lisbona"));
        flightMap.put("Madryt", Arrays.asList("Paryż", "Warszawa-Modlin", "Gdańsk"));

        boolean result = flightFinder.findFilght(flight1, flightMap);
        System.out.println(result);

    }
}

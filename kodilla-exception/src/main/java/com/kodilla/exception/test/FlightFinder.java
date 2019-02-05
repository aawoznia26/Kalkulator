package com.kodilla.exception.test;

import java.util.*;

import static java.util.stream.Collectors.*;

public class FlightFinder {

    public boolean isFlightPossible(Flight flight, Map<String, List<String>> flightMap) throws RouteNotFoundException {
        boolean isFlightPossible = false;
        try{
            String searchDepartureAirport = flight.getDepartureAirport();
            String searchArrivalAirport = flight.getArrivalAirport();

            boolean isDeparturePossible = flightMap.containsKey(searchDepartureAirport);

            List<String> result = flightMap.entrySet().stream()
                    .flatMap(x -> x.getValue().stream())
                    .filter(a -> a.equals(searchArrivalAirport))
                    .collect(toList());
            if (isDeparturePossible && (result.size()!=0)) {
                isFlightPossible = true;
            }

        } catch (NullPointerException e){

        }
        System.out.println("Czy lot jest możliwy? " + isFlightPossible);
        return isFlightPossible;
    }

    public boolean findFilght(Flight flight, Map<String, List<String>> flightMap) throws RouteNotFoundException {
        boolean isFlightFound = false;

        try{
            String searchDepartureAirport = flight.getDepartureAirport();
            String searchArrivalAirport = flight.getArrivalAirport();

            boolean isDirectFlightPossible = flightMap.get(searchDepartureAirport).contains(searchArrivalAirport);

            if(isDirectFlightPossible){
                isFlightFound = true;
            }else{
                List<String> newAirportList = flightMap.get(searchDepartureAirport);
                for (String theAirport : newAirportList) {
                    Flight indirectFlight = new Flight(theAirport, searchArrivalAirport);
                    findFilght(indirectFlight, flightMap);
                }
            }

        } catch (NullPointerException e){

        }
        System.out.println("Czy zanleziono lot? " + isFlightFound);
        return isFlightFound;
    }


    public static void main(String args[]){

        FlightFinder flightFinder = new FlightFinder();
        Flight flight1 = new Flight("Madryt", "Londyn");

        Map<String, List<String>> flightMap1 = new HashMap<>();
        flightMap1.put("Warszawa-Modlin", Arrays.asList("Oslo-Torp", "Londyn", "Lwów"));
        flightMap1.put("Ovda", Arrays.asList("Mińsk", "Londyn", "Neapol"));
        flightMap1.put("Oslo-Torp", Arrays.asList("Rzym", "Lisbona", "Lwów"));
        flightMap1.put("Lwów", Arrays.asList("Oslo-Torp", "Londyn", "Lisbona"));
        flightMap1.put("Madryt", Arrays.asList("Warszawa-Modlin", "Lwów", "Helsinki"));

        try{
            if(flightFinder.isFlightPossible(flight1, flightMap1)) {
                flightFinder.findFilght(flight1, flightMap1);
            }
        } catch (RouteNotFoundException e) {
            System.out.println("Wyszukiwany lot nie istnieje");
        } finally {
            System.out.println("Wyszukiwanie zakończone");
        }
    }
}

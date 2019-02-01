package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightFinder {

    public boolean findFilght(Flight flight) throws RouteNotFoundException{
        Map<String, Boolean> flightMap= new HashMap<>();

        flightMap.put("Warszawa-Modlin", true);
        flightMap.put("Ovda", true);
        flightMap.put("Oslo-Torp", false);
        flightMap.put("Lwów", true);
        flightMap.put("Madryt", false);

        try {
            boolean isTheFlightFound =  flightMap.get(flight.getArrivalAirport());
            return isTheFlightFound;
        } catch (NullPointerException e){
            throw new RouteNotFoundException();
        }

    }

    public static void main(String args[]){

        FlightFinder flightFinder = new FlightFinder();
        Flight flight1 = new Flight("Turyn", "Barcelona");

        try{
            flightFinder.findFilght(flight1);
        } catch (RouteNotFoundException e) {
            System.out.println("Lotnisko docelowe nie istnieje");
        } finally {
            System.out.println("Wyszukiwanie zakończone");
        }
    }
}

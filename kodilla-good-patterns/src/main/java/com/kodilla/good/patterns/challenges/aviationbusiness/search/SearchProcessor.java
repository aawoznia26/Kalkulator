package com.kodilla.good.patterns.challenges.aviationbusiness.search;

import com.kodilla.good.patterns.challenges.aviationbusiness.Flight;
import com.kodilla.good.patterns.challenges.aviationbusiness.informationservice.ResultDisplayer;
import com.kodilla.good.patterns.challenges.aviationbusiness.repository.InMemoryFlightRepository;

import java.util.List;

public class SearchProcessor {

    private FlightFinder flightFinder;
    private InMemoryFlightRepository inMemoryFlightRepository = new InMemoryFlightRepository();

    public SearchProcessor(FlightFinder flightFinder) {
        this.flightFinder = flightFinder;
    }

    public List<Flight> search(DesiredSearch desiredSearch, String departureAirport, String arrivalAirport) {
        List<Flight> result = null;

        switch (desiredSearch) {
            case DEPARTURE:
                result = flightFinder.findAllFlightsFromDepartureAirport(departureAirport);
                break;
            case ARRIVAL:
                result = flightFinder.findAllFlightsToArrivalAirport(arrivalAirport);
                break;
            case DIRECT:
                result = flightFinder.findOnlyDirectFlight(new Flight(departureAirport, arrivalAirport));
                break;
            case ALLCONECTIONS:
                result = flightFinder.findFilght(new Flight(departureAirport, arrivalAirport));
                break;
        }
        ResultDisplayer resultDisplayer = new ResultDisplayer(result, inMemoryFlightRepository);
        resultDisplayer.inform();
        return result;
    }

}

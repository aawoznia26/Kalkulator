package com.kodilla.good.patterns.challenges.aviationbusiness.repository;

import com.kodilla.good.patterns.challenges.aviationbusiness.Flight;
import com.kodilla.good.patterns.challenges.aviationbusiness.FlightAttributes;

public interface FlightRepository {

    void addFlightToRepository(Flight flight, FlightAttributes flightAtributes);
}

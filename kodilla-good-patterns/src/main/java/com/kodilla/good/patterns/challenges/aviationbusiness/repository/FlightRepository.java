package com.kodilla.good.patterns.challenges.aviationbusiness.repository;

import com.kodilla.good.patterns.challenges.aviationbusiness.Departure;
import com.kodilla.good.patterns.challenges.aviationbusiness.Destination;

public interface FlightRepository {

        void addFlightToRepository(Departure departure, Destination destination);
}

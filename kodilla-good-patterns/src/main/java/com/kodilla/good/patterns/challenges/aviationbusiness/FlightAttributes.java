package com.kodilla.good.patterns.challenges.aviationbusiness;

import java.time.Duration;

public class FlightAttributes {
    private String airlines;
    private double cost;
    private Duration duration;

    public FlightAttributes(String airlines, double cost, Duration duration) {
        this.airlines = airlines;
        this.cost = cost;
        this.duration = duration;
    }

    public String getAirlines() {
        return airlines;
    }

    public double getCost() {
        return cost;
    }

    public Duration getDuration() {
        return duration;
    }
}

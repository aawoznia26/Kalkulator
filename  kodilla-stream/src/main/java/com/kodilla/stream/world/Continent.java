package com.kodilla.stream.world;

import java.util.HashSet;
import java.util.Set;

public final class Continent {
    private final String name;
    private final Set<Country> countrySet = new HashSet<>();

    public Continent(final String name) {
        this.name = name;

    }

    public Set<Country> getCountrys() {
        return countrySet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Continent)) return false;

        Continent continent = (Continent) o;

        return name.equals(continent.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public void addCountry(Country country) {
        countrySet.add(country);
    }
}

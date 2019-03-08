package com.kodilla.good.patterns.challenges;

import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class App {
    public static void main(String[] args) {
        String translations = MovieStore.getMovies().entrySet().stream()
                .flatMap(movieList -> movieList.getValue().stream())
                .collect(Collectors.joining("!"));
        System.out.println(translations);

    }
}

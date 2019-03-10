package com.kodilla.good.patterns.challenges.MovieStore;

import com.kodilla.good.patterns.challenges.MovieStore.MovieStore;

import java.util.stream.Collectors;

public class MovieStoreApp {
    public static void main(String[] args) {
        String translations = MovieStore.getMovies().entrySet().stream()
                .flatMap(movieList -> movieList.getValue().stream())
                .collect(Collectors.joining("!"));
        System.out.println(translations);

    }
}

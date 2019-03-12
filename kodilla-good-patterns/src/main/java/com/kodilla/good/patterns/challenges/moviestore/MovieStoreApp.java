package com.kodilla.good.patterns.challenges.moviestore;

import java.util.stream.Collectors;

public class MovieStoreApp {
    public static void main(String[] args) {
        String translations = MovieStore.getMovies().entrySet().stream()
                .flatMap(movieList -> movieList.getValue().stream())
                .collect(Collectors.joining("!"));
        System.out.println(translations);

    }
}

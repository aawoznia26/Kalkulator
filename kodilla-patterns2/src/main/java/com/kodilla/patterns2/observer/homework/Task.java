package com.kodilla.patterns2.observer.homework;

public class Task {

    private final int number;
    private final String description;

    public Task(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public int getNumber() {
        return number;
    }

    public String getDescription() {
        return description;
    }
}

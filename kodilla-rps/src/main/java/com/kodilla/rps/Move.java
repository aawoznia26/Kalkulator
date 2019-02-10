package com.kodilla.rps;

public enum Move {
    STONE("kamień"), PAPER("papier"), SCISSORS("nożyce");

    private String translation;

    Move(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}

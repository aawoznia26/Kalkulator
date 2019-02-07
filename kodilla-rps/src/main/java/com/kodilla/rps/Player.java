package com.kodilla.rps;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public Rps.Move drawMove() {
        Random generator = new Random();
        final Rps.Move[] moves = Rps.Move.values();
        return moves[generator.nextInt(3)];
    }

    public Rps.Move getMove() throws java.lang.Exception{

        try {
            Scanner moveScanner = new Scanner(System.in);
            final Rps.Move[]moves = Rps.Move.values();
            return moves[moveScanner.nextInt()-1];

        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Ten ruch jest niedozwolony! Spróbuj ponownie.");
            Scanner moveScanner = new Scanner(System.in);
            final Rps.Move[]moves = Rps.Move.values();
            return moves[moveScanner.nextInt()-1];

        } catch (InputMismatchException e){
            System.out.println("Wprowadź 1 - kamień, 2 - papier, 3 - nożyce");
            Scanner moveScanner = new Scanner(System.in);
            final Rps.Move[]moves = Rps.Move.values();
            return moves[moveScanner.nextInt()-1];

        }

    }

}

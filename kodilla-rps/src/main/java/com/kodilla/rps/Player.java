package com.kodilla.rps;

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


    public String drawMove() {
        Random generator = new Random();
        int result = generator.nextInt(3);
        String rpsMove;
        if(result == 0){
            rpsMove = "kamień";
        } else if (result == 1){
            rpsMove = "papier";
        } else {
            rpsMove = "nożyce";
        }
        return rpsMove;
    }

    public String getMove() {
        Scanner moveScanner = new Scanner(System.in);
        int result = moveScanner.nextInt();
        String rpsMove = null;
        if(result == 1){
            rpsMove = "kamień";
        } else if (result == 2){
            rpsMove = "papier";
        } else if (result == 3){
            rpsMove = "nożyce";
        }
        return rpsMove;
    }

}

package com.kodilla.rps;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RpsRunner {

    public static void main(String[] args) throws java.lang.Exception{

        System.out.println("Podaj nazwę gracza");
        Scanner nameScanner = new Scanner(System.in);
        String playerName = nameScanner.next();

        System.out.println("Do ilu wygranych rund gramy?");

        int wonRunds = scanWonRounds();

        System.out.println("Zasady obsługi gry. Wciśnij:");
        System.out.println("1, aby zagrać \"kamień\",");
        System.out.println("2, aby zagrać \"papier\", ");
        System.out.println("3, aby zagrać \"nożyce\", ");

        Player player = new Player(playerName);
        Player computer = new Player("komputer");

        Rps rps = new Rps();
        rps.playRps(player, computer, wonRunds);
    }


    public static int scanWonRounds() {
        int wonRunds;
        try {
            Scanner wonRundsScanner = new Scanner(System.in);
            wonRunds = wonRundsScanner.nextInt();

        } catch (InputMismatchException e){
            System.out.println("Wprowadź liczbę całkowitą");
            Scanner wonRundsScanner = new Scanner(System.in);
            wonRunds = wonRundsScanner.nextInt();
        }
        return wonRunds;
    }

}

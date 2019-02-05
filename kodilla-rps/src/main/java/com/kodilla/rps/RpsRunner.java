package com.kodilla.rps;

import java.util.Scanner;

public class RpsRunner {

    public static void main(String[] args){

        System.out.println("Podaj nazwę gracza");
        Scanner nameScanner = new Scanner(System.in);
        String playerName = nameScanner.next();

        System.out.println("Do ilu wygranych rund gramy?");
        Scanner wonRundsScanner = new Scanner(System.in);
        int wonRunds = wonRundsScanner.nextInt();

        System.out.println("Zasady obsługi gry. Wciśnij:");
        System.out.println("1, aby zagrać \"kamień\",");
        System.out.println("2, aby zagrać \"papier\", ");
        System.out.println("3, aby zagrać \"nożyce\", ");
        System.out.println("x kończy grę");
        System.out.println("n uruchamia kolejną grę");

        Player player = new Player(playerName);
        Player computer = new Player("komputer");

        Rps rps = new Rps();
        rps.playRps(player, computer, wonRunds);

        System.out.println("Do ilu wygranych rund gramy?");
        Scanner endGameScanner = new Scanner(System.in);
        char requiredResult = endGameScanner.next().charAt(0);

        rps.endGame(requiredResult);

    }

}

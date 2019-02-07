package com.kodilla.rps;

import java.util.*;

import static com.kodilla.rps.RpsRunner.scanWonRounds;

public class Rps {

    public enum Move{
        kamień, papier, nożyce
    }

    public enum EndDecision {
        n, x
    }

    public void playRps(Player player, Player computer, int numberOfWonRunds) throws java.lang.Exception {
        boolean end = false;
        int rundNumber = 0;
        int computerResult = 0;
        int userResult = 0;

        while(!end) {
            System.out.println("Wykonaj ruch");
            Move playerMove = player.getMove();
            Move computerMove = computer.drawMove();
            int computerRoundResult = 0;
            int userRoundResult = 0;


            Map<GameRound, List<Integer>> gameMap = new HashMap<>();
            gameMap.put(new GameRound(Move.kamień,Move.papier), Arrays.asList(0,1));
            gameMap.put(new GameRound(Move.kamień,Move.nożyce),Arrays.asList(1,0));
            gameMap.put(new GameRound(Move.kamień,Move.kamień),Arrays.asList(0,0));

            gameMap.put(new GameRound(Move.papier,Move.kamień),Arrays.asList(1,0));
            gameMap.put(new GameRound(Move.papier,Move.nożyce),Arrays.asList(0,1));
            gameMap.put(new GameRound(Move.papier,Move.papier),Arrays.asList(0,0));

            gameMap.put(new GameRound(Move.nożyce,Move.kamień),Arrays.asList(0,1));
            gameMap.put(new GameRound(Move.nożyce,Move.papier),Arrays.asList(1,0));
            gameMap.put(new GameRound(Move.nożyce,Move.nożyce),Arrays.asList(0,0));

            computerRoundResult = gameMap.get(new GameRound(computerMove,playerMove)).get(0);
            userRoundResult = gameMap.get(new GameRound(computerMove,playerMove)).get(1);

            computerResult += computerRoundResult;
            userResult += userRoundResult;

            rundNumber++;
            if (Math.max(userResult, computerResult)==numberOfWonRunds){
                end = true;
            }

            System.out.println("Wykonałeś ruch: " + playerMove + ", Twój przeciwnik zaś: " + computerMove);
            System.out.println("Wynik tej rundy to: " + player.getName() + " " + userRoundResult + ", " + computer.getName() + " " + computerRoundResult);
            System.out.println("Masymalna liczba rund wygranych przez jednego z przeciwników wynosi obecnie: " + Math.max(userResult, computerResult));

        }

        Player winner;
        if (computerResult>userResult) {
            winner = computer;
        } else {
            winner = player;
        }
        System.out.println("Wynik " + player.getName() + ": " + userResult);
        System.out.println("Wynik " + computer.getName() + ": " + computerResult);
        System.out.println("Zwycięzcą jest " +  winner.getName() + "!");

        System.out.println("Jeśli chcesz rozpocząć nową grę wciśnij n, aby zakończyć wybierz x");

        scanEndGameDecision(player, computer);


    }

    public char scanEndGameDecision(Player player, Player computer) throws java.lang.Exception{
        char requiredResult;
            Scanner endGameScanner = new Scanner(System.in);
            requiredResult = endGameScanner.next().charAt(0);
            if(requiredResult == 'n') {
                System.out.println("Do ilu wygranych rund gramy?");
                int numberOfWonRunds = scanWonRounds();
                playRps(player, computer, numberOfWonRunds);
            } else if (requiredResult == 'x'){
                System.out.println("Koniec gry");
            } else {
                System.out.println("Jeśli chcesz rozpocząć nową grę wciśnij n, aby zakończyć wybierz x");
                scanEndGameDecision(player, computer);
            }

        return requiredResult;
    }

}

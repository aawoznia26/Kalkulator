package com.kodilla.rps;

import java.util.*;

import static com.kodilla.rps.RpsRunner.scanWonRounds;

public class Rps {

    public enum Move{
        STONE, PAPER, SCISSORS
    }

    public enum EndDecision {
        n, x
    }
    private int computerRoundResult;
    private int playerRoundResult;

    public void playRps(Player player, Player computer, int numberOfWonRunds) throws java.lang.Exception {
        boolean end = false;
        int rundNumber = 0;
        int computerResult = 0;
        int playerResult = 0;
        List<Move> playerMoves = new ArrayList<>();
        List<Integer> playerRoundResults = new ArrayList<>();
        Map<Move,Move> reactionOnPlayerMove = new HashMap<>();

        reactionOnPlayerMove.put(Move.STONE, Move.PAPER);
        reactionOnPlayerMove.put(Move.PAPER, Move.SCISSORS);
        reactionOnPlayerMove.put(Move.SCISSORS, Move.STONE);

        while(!end) {
            System.out.println("Wykonaj ruch");

            Move playerMove = player.getMove();
            Move computerMove = null;
            if(rundNumber>=2 && playerRoundResult==1) {
                computerMove= reactionOnPlayerMove.get(playerMoves.get(rundNumber-1));
            } else if (rundNumber>=2 &&(playerRoundResults.get(rundNumber-1) + playerRoundResults.get(rundNumber-2))==0 && playerMoves.get(rundNumber-2).equals(playerMoves.get(rundNumber-1))) {
                while(computerMove!=reactionOnPlayerMove.get(playerMoves.get(rundNumber-1))){
                    computerMove = computer.drawMove(); 
                }
                computerMove = computer.drawMove();
            } else {
                computerMove = computer.drawMove();
            }

            playerMoves.add(playerMove);

            computerRoundResult = 0;
            playerRoundResult = 0;


            Map<GameRound, List<Integer>> gameMap = new HashMap<>();
            gameMap.put(new GameRound(Move.STONE,Move.PAPER), Arrays.asList(0,1));
            gameMap.put(new GameRound(Move.STONE,Move.SCISSORS),Arrays.asList(1,0));
            gameMap.put(new GameRound(Move.STONE,Move.STONE),Arrays.asList(0,0));

            gameMap.put(new GameRound(Move.PAPER,Move.STONE),Arrays.asList(1,0));
            gameMap.put(new GameRound(Move.PAPER,Move.SCISSORS),Arrays.asList(0,1));
            gameMap.put(new GameRound(Move.PAPER,Move.PAPER),Arrays.asList(0,0));

            gameMap.put(new GameRound(Move.SCISSORS,Move.STONE),Arrays.asList(0,1));
            gameMap.put(new GameRound(Move.SCISSORS,Move.PAPER),Arrays.asList(1,0));
            gameMap.put(new GameRound(Move.SCISSORS,Move.SCISSORS),Arrays.asList(0,0));

            computerRoundResult = gameMap.get(new GameRound(computerMove,playerMove)).get(0);
            playerRoundResult = gameMap.get(new GameRound(computerMove,playerMove)).get(1);

            computerResult += computerRoundResult;
            playerResult += playerRoundResult;
            playerRoundResults.add(playerRoundResult);

            rundNumber++;
            if (Math.max(playerResult, computerResult)==numberOfWonRunds){
                end = true;
            }

            System.out.println("Wykonałeś ruch: " + playerMove + ", Twój przeciwnik zaś: " + computerMove);
            System.out.println("Wynik tej rundy to: " + player.getName() + " " + playerRoundResult + ", " + computer.getName() + " " + computerRoundResult);
            System.out.println("Masymalna liczba rund wygranych przez jednego z przeciwników wynosi obecnie: " + Math.max(playerResult, computerResult));

        }

        Player winner;
        if (computerResult>playerResult) {
            winner = computer;
        } else {
            winner = player;
        }
        System.out.println("Wynik " + player.getName() + ": " + playerResult);
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

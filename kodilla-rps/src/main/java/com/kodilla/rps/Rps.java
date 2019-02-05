package com.kodilla.rps;

public class Rps {

    public void playRps(Player user, Player computer, int numberOfWonRunds) {
        boolean end = false;
        int rundNumber = 0;
        int computerResult = 0;
        int userResult = 0;

        while(!end) {
            System.out.println("Wykonaj ruch");
            String userMove = user.getMove();
            String computerMove = computer.drawMove();
            int computerRoundResult = 0;
            int userRoundResult = 0;

            if(computerMove==null || userMove== null){
                System.out.println("Wykonaj poprawny ruch!");
            } else if(computerMove==userMove) {
                computerResult = computerResult;
                userResult = userResult;
            } else if (userMove == "kamień"){
                if(computerMove =="papier"){
                    computerResult++;
                    computerRoundResult = 1;
                } else {
                    userResult++;
                    userRoundResult = 1;
                }

            } else if (userMove == "papier"){
                if(computerMove =="kamień"){
                    userResult++;
                    userRoundResult = 1;
                } else {
                    computerResult++;
                    computerRoundResult = 1;
                }

            } else {
                if(computerMove =="kamień"){
                    computerResult++;
                    computerRoundResult = 1;
                } else {
                    userResult++;
                    userRoundResult = 1;
                }
            }
            rundNumber++;
            if (Math.max(userResult, computerResult)==numberOfWonRunds){
                end = true;
            }

            System.out.println("Wykonałeś ruch: " + userMove + ", Twój przeciwnik zaś: " + computerMove);
            System.out.println("Wynik tej rundy to: " + user.getName() + " " + userRoundResult + ", " + computer.getName() + " " + computerRoundResult);
            System.out.println("Masymalna liczba rund wygranych przez jednego z przeciwników wynosi obecnie: " + Math.max(userResult, computerResult));

        }

        Player winner;
        if (computerResult>userResult) {
            winner = computer;
        } else {
            winner = user;
        }
        System.out.println(user.getName() + ": " + userResult);
        System.out.println(computer.getName() + ": " + computerResult);
        System.out.println("Zwycięzcą jest: " +  winner.getName());

    }

    public void endGame(char requiredResult){
        System.out.println("Jeśli chcesz rozpocząć nową grę wciśnij n, aby zakończyć wybierz x");
        if (requiredResult=='x') {
            System.out.println("Game over");
        } else if (requiredResult=='n'){
            playRps(player, computer, wonRunds);
        } else {
            System.out.println("Niepoprawne zakończenie gry");
        }


    }



}

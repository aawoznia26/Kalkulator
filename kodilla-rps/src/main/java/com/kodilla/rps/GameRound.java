package com.kodilla.rps;

public class GameRound {

    private Rps.Move computerMove;
    private Rps.Move playerMove;

    public GameRound(Rps.Move computerMove, Rps.Move playerMove) {
        this.computerMove = computerMove;
        this.playerMove = playerMove;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameRound)) return false;

        GameRound gameRound = (GameRound) o;

        if (computerMove != gameRound.computerMove) return false;
        return playerMove == gameRound.playerMove;
    }

    @Override
    public int hashCode() {
        int result = computerMove.hashCode();
        result = 31 * result + playerMove.hashCode();
        return result;
    }
}

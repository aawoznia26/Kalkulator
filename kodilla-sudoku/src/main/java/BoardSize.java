public enum BoardSize {

    FOUR(4), NINE(9), SIXTEEN(16), DWENTY_FIVE(25);

    private int boardSize;

    private BoardSize(int boardSize) {
        this.boardSize = boardSize;
    }

    public int getBoardSize() {
        return boardSize;
    }
}

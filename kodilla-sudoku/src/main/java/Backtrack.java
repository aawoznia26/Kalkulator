public class Backtrack {

    private SudokuBoard sudokuBoard;
    private int[][] position;
    private int option;

    public Backtrack(SudokuBoard sudokuBoard, int[][] position, int option) {
        this.sudokuBoard = sudokuBoard;
        this.position = position;
        this.option = option;
    }

    public SudokuBoard getSudokuBoard() {
        return sudokuBoard;
    }

    public int[][] getPosition() {
        return position;
    }

    public int getOption() {
        return option;
    }

}

import java.util.*;

public class SudokuGame {

    private int boardSize;
    private SudokuBoard sudokuBoard = new SudokuBoard();
    private Deque<Backtrack> backtrackQueue = new ArrayDeque<>();

    public SudokuGame(int boardSize) {
        this.boardSize = boardSize;
    }

    public int getBoardSize() {
        return boardSize;
    }


    public SudokuBoard createEmptyBoard() {
        List<SudokuRow> sudokuRows = new ArrayList<>();

        for (int i = 0; i < boardSize; i++) {
            List<SudokuElement> sudokuElements = new ArrayList<>();
            for (int j = 0; j < boardSize; j++) {
                sudokuElements.add(new SudokuElement(SudokuElement.EMPTY, new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9))));
            }
            sudokuRows.add(new SudokuRow(sudokuElements));
        }
        for (SudokuRow sudokuRow : sudokuRows) {
            sudokuBoard.addRow(sudokuRow);
        }
        return sudokuBoard;
    }


    public void setBoardElement(int rowNumber, int columnNumber, int value) {

        if (rowNumber >= 0 && columnNumber >= 0 && value >= 1 && rowNumber < boardSize && columnNumber < boardSize && value <= boardSize) {
            SudokuRow rowToSet = sudokuBoard.getRow(rowNumber);
            rowToSet.setElement(columnNumber, value);
        } else {
            System.out.println("Value, row number and column number should be between 1 and " + sudokuBoard.getBoard().size() + ". Check given numbers and try again.");
        }
    }

    public void resolveSudoku() {
        boolean ok = true;
        try {
            while (ok) {
                removeEnteredValuesFromOptions();
                int result1 = isOptionValueOrOptionInOtherField();
                int result2 = setElementWhereSingleOptionExists();
                if (result1 + result2 == 0) {
                    ok = false;

                }
            }

            boolean hasEmpty = true;

            while (hasEmpty) {

                for (int i = 0; i < sudokuBoard.getBoard().size(); i++) {
                    SudokuRow theRow = sudokuBoard.getRow(i);
                    for (int j = 0; j < theRow.getRow().size(); j++) {
                        SudokuElement sudokuElement = theRow.getElement(j);
                        int value = sudokuElement.getValue();
                        if (value == -1) {
                            guessValue(i, j);
                            resolveSudoku();
                            hasEmpty = true;
                        } else {
                            hasEmpty = false;
                        }

                    }

                }

            }

        } catch (guessSolutionException e) {

            if (backtrackQueue.size() == 0) {
                System.out.println("This SUDOKU do not have solution");
            } else {
                int value = backtrackQueue.peekLast().getOption();
                int[][] position = backtrackQueue.peekLast().getPosition();
                sudokuBoard = backtrackQueue.peekLast().getSudokuBoard();
                backtrackQueue.pop().getSudokuBoard();

                List<Integer> fulfillmentOptions = sudokuBoard.getRow(position[0][0])
                        .getElement(position[0][1]).getFulfillmentOptions();
                fulfillmentOptions.removeIf(o -> o == value);
            }
        }

    }


    public void removeEnteredValuesFromOptions() {
        for (int i = 0; i < sudokuBoard.getBoard().size(); i++) {
            SudokuRow theRow = sudokuBoard.getRow(i);
            for (int j = 0; j < theRow.getRow().size(); j++) {
                SudokuElement theElement = theRow.getElement(j);
                int value = theElement.getValue();
                if (theElement.getValue() > 0) {
                    sudokuBoard.removeValueFromOptionsInRow(i, value);
                    sudokuBoard.removeValueFromOptionsInColumn(j, value);
                    sudokuBoard.removeValueFromOptionsInBox(i, j, value);
                }
            }
        }
    }

    public int setElementWhereSingleOptionExists() throws guessSolutionException {
        int setCounter1 = 0;

        for (int i = 0; i < sudokuBoard.getBoard().size(); i++) {
            SudokuRow theRow = sudokuBoard.getRow(i);
            for (int j = 0; j < theRow.getRow().size(); j++) {
                SudokuElement theElement = theRow.getElement(j);
                int value = theElement.getValue();
                List<Integer> fulfillmentOptions = theRow.getElement(j).getFulfillmentOptions();
                if (fulfillmentOptions.size() == 1 && value < 0) {
                    for (Integer o : fulfillmentOptions) {
                        if (!(sudokuBoard.isInRow(i, o) || sudokuBoard.isInColumn(j, o) || sudokuBoard.isInBlock(i, j, o))) {
                            setBoardElement(i, j, theElement.getFulfillmentOptions().get(0));
                            setCounter1 += 1;
                        } else {
                            throw new guessSolutionException();
                        }
                    }
                }
                if (fulfillmentOptions.size() < 1 && value < 0) {
                    throw new guessSolutionException();
                }
            }
        }
        return setCounter1;
    }

    public int isOptionValueOrOptionInOtherField() {
        int setCounter2 = 0;
        for (int i = 0; i < sudokuBoard.getBoard().size(); i++) {
            SudokuRow theRow = sudokuBoard.getRow(i);
            for (int j = 0; j < theRow.getRow().size(); j++) {
                List<Integer> fulfillmentOptions = theRow.getElement(j).getFulfillmentOptions();
                for (Integer o : fulfillmentOptions) {
                    if (!(sudokuBoard.isInRow(i, o) || sudokuBoard.isInColumn(j, o) || sudokuBoard.isInBlock(i, j, o) || sudokuBoard.isInRowOptions(i, o) || sudokuBoard.isInColumnOptions(j, o) || sudokuBoard.isInBlockOptions(i, j, o))) {
                        setBoardElement(i, j, o);
                        setCounter2 += 1;
                    }
                }
            }
        }
        return setCounter2;
    }

    public void guessValue(int row, int column) {
        try {
            SudokuElement sudokuElement = sudokuBoard.getRow(row).getElement(column);
            int[][] position = new int[1][2];
            position[0][0] = row;
            position[0][1] = column;
            int option = sudokuElement.getFulfillmentOptions().get(0);
            backtrackQueue.push(new Backtrack(sudokuBoard.deepCopy(), position, option));
            setBoardElement(row, column, option);

        } catch (Exception e) {
            System.out.println(row + " " + column);
            e.printStackTrace();
        }
    }

}

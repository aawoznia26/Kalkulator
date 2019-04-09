import java.util.ArrayList;
import java.util.List;

public class SudokuBoard extends Prototype {

    private List<SudokuRow> board = new ArrayList<>();

    public SudokuBoard() {
        this.board = board;
    }

    public List<SudokuRow> getBoard() {
        return board;
    }

    public void addRow(SudokuRow sudokuRow) {
        board.add(sudokuRow);
    }

    public SudokuRow getRow(int rowNumber) {
        return board.get(rowNumber);
    }

    @Override
    public String toString() {
        String boardToDisplay = "";
        for (SudokuRow row : board) {
            boardToDisplay = boardToDisplay + System.lineSeparator() + row.toString();
        }
        return boardToDisplay + "\n" + "\n";

    }

    public boolean isInRow(int row, int value) {
        long result = board.get(row).getRow().stream()
                .map(r -> r.getValue())
                .filter(v -> v.equals(value))
                .count();
        return (result > 0);
    }

    public boolean isInColumn(int column, int value) {
        long result = board.stream()
                .map(l -> l.getElement(column).getValue())
                .filter(v -> v.equals(value))
                .count();
        return (result > 0);
    }

    public boolean isInBlock(int row, int column, int value) {
        int r = row - row % 3;
        int c = column - column % 3;

        SudokuBoard rowsList = new SudokuBoard();
        List<Integer> result = new ArrayList<>();

        rowsList.addRow(board.get(r));
        rowsList.addRow(board.get(r + 1));
        rowsList.addRow(board.get(r + 2));

        for (SudokuRow theRow : rowsList.getBoard()) {
            for (int i = c; i < c + 3; i++) {
                int elementValue = theRow.getElement(i).getValue();
                if (elementValue == value) {
                    result.add(elementValue);
                }
            }
        }

        return (result.size() > 0);
    }


    public void removeValueFromOptionsInRow(int row, int value) {

        List<SudokuElement> elementsInRow = getBoard().get(row).getRow();
        for (SudokuElement sudokuElement : elementsInRow) {
            List<Integer> fulfillmentOptions = sudokuElement.getFulfillmentOptions();
            fulfillmentOptions.removeIf(o -> o == value);
        }
    }

    public void removeValueFromOptionsInColumn(int column, int value) {

        for (SudokuRow sudokuRow : board) {
            List<Integer> fulfillmentOptions = sudokuRow.getElement(column).getFulfillmentOptions();
            fulfillmentOptions.removeIf(o -> o == value);
        }
    }

    public void removeValueFromOptionsInBox(int row, int column, int value) {

        int r = row - row % 3;
        int c = column - column % 3;

        SudokuBoard rowsList = new SudokuBoard();
        rowsList.addRow(getBoard().get(r));
        rowsList.addRow(getBoard().get(r + 1));
        rowsList.addRow(getBoard().get(r + 2));

        for (SudokuRow theRow : rowsList.getBoard()) {
            for (int i = c; i < c + 3; i++) {
                rowsList.removeValueFromOptionsInColumn(i, value);
            }
        }
    }

    public boolean isInRowOptions(int row, int value) {
        long result = board.get(row).getRow().stream()
                .flatMap(r -> r.getFulfillmentOptions().stream())
                .filter(v -> v.equals(value))
                .count();
        return (result > 0);
    }

    public boolean isInColumnOptions(int column, int value) {
        long result = board.stream()
                .flatMap(l -> l.getElement(column).getFulfillmentOptions().stream())
                .filter(v -> v == value)
                .count();
        return (result > 0);
    }


    public boolean isInBlockOptions(int row, int column, int value) {
        int r = row - row % 3;
        int c = column - column % 3;

        SudokuBoard rowsList = new SudokuBoard();
        List<Integer> result = new ArrayList<>();

        rowsList.addRow(board.get(r));
        rowsList.addRow(board.get(r + 1));
        rowsList.addRow(board.get(r + 2));

        for (SudokuRow theRow : rowsList.getBoard()) {
            for (int i = c; i < c + 3; i++) {
                theRow.getElement(i).getFulfillmentOptions().stream().forEach(option -> {
                            if (option == value) {
                                result.add(option);
                            }
                        }
                );

            }
        }
        return (result.size() > 0);
    }

    public SudokuBoard deepCopy() throws CloneNotSupportedException {

        SudokuBoard clonedBoard = (SudokuBoard) super.clone();
        clonedBoard.board = new ArrayList<>();
        for (SudokuRow theRow : board) {
            List<SudokuElement> clonedElementList = new ArrayList<>();
            SudokuRow clonedRow = new SudokuRow(clonedElementList);
            for (SudokuElement theElement : theRow.getRow()) {
                int clonedValue = theElement.getValue();
                List<Integer> clonedOptions = new ArrayList<>();
                List<Integer> theOptions = theElement.getFulfillmentOptions();
                for (Integer fulfillmentOption : theOptions) {
                    clonedOptions.add(fulfillmentOption);
                }
                SudokuElement clonedElement = new SudokuElement(clonedValue, clonedOptions);
                clonedElementList.add(clonedElement);
            }
            clonedBoard.addRow(clonedRow);
        }
        return clonedBoard;
    }
}

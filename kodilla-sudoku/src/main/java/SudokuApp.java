import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SudokuApp {

    public static void main(String[] args) throws java.lang.Exception {
        System.out.println("What size of board do you want to play 4, 9, 16 or 25?");
        Scanner scannerBoardSize = new Scanner(System.in);
        int scannedBoardSize = scannerBoardSize.nextInt();
        BoardSize boardSize = null;
        switch (scannedBoardSize){
            case 4:
                boardSize = BoardSize.FOUR;
                break;
            case 9:
                boardSize = BoardSize.NINE;
                break;
            case 16:
                boardSize = BoardSize.SIXTEEN;
                break;
            case 25:
                boardSize = BoardSize.DWENTY_FIVE;
                break;

        }
        SudokuGame theGame = new SudokuGame(boardSize.getBoardSize());

        String resloveSudokuCommand = "SUDOKU";
        theGame.createEmptyBoard();

        boolean ok = false;
        while (!ok) {
            try {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Enter row number, column number and value separated by ',' or enter 'SUDOKU' if you want to see resolved board");
                theGame.setBoardElement(0, 1, 3);
                theGame.setBoardElement(0, 2, 2);

                String scannedString = scanner1.nextLine().replaceAll(",", " ");
                Scanner scanner2 = new Scanner(scannedString);

                if (scannedString.equalsIgnoreCase(resloveSudokuCommand)) {
                    System.out.println("See resolved SUDOKU board");
                    ok = true;
                    System.out.print(theGame.resolveSudoku());
                } else {
                    int rowNumber = scanner2.nextInt();
                    int columnNumber = scanner2.nextInt();
                    int value = scanner2.nextInt();

                    theGame.setBoardElement(rowNumber - 1, columnNumber - 1, value);
                }


            } catch (InputMismatchException e) {
                System.out.println("Remember that row number, column number and value should be integers separated by ','");

            } catch (NoSuchElementException i) {
                System.out.println("Remember that row number, column number and value should be integers between 1 and " + theGame.getBoardSize());

            }
        }

    }
}
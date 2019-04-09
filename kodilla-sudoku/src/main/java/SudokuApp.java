import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SudokuApp {

    public static void main(String[] args) throws java.lang.Exception {

        boolean gameFinished = false;
        SudokuGame theGame = new SudokuGame(9);
        SudokuBoard board = theGame.createEmptyBoard();
        String resloveSudokuCommand = "SUDOKU";

        boolean ok = false;
        while (!ok) {
            try {
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("Enter row number, column number and value separated by ',' or enter 'SUDOKU' if you want to see resolved board");
                theGame.setBoardElement(0, 1, 3);
                theGame.setBoardElement(0, 2, 2);
                theGame.setBoardElement(0, 4, 1);
                theGame.setBoardElement(0, 6, 9);
                theGame.setBoardElement(0, 8, 4);

                theGame.setBoardElement(1, 1, 6);
                theGame.setBoardElement(1, 4, 8);
                theGame.setBoardElement(1, 5, 4);
                theGame.setBoardElement(1, 7, 5);

                theGame.setBoardElement(3, 3, 4);
                theGame.setBoardElement(3, 4, 9);
                theGame.setBoardElement(3, 6, 8);

                theGame.setBoardElement(4, 2, 3);
                theGame.setBoardElement(4, 5, 8);
                theGame.setBoardElement(4, 6, 2);
                theGame.setBoardElement(4, 7, 4);
                theGame.setBoardElement(4, 8, 1);

                theGame.setBoardElement(5, 4, 2);
                theGame.setBoardElement(5, 7, 3);

                theGame.setBoardElement(7, 5, 9);
                theGame.setBoardElement(7, 6, 5);
                theGame.setBoardElement(7, 8, 6);

                theGame.setBoardElement(8, 1, 1);
                theGame.setBoardElement(8, 2, 9);
                theGame.setBoardElement(8, 4, 5);
                theGame.setBoardElement(8, 8, 2);

                String scannedString = scanner1.nextLine().replaceAll(",", " ");
                Scanner scanner2 = new Scanner(scannedString);
                int solution = 0;

                if (scannedString.equalsIgnoreCase(resloveSudokuCommand)) {
                    System.out.println("See resolved SUDOKU board");
                    ok = true;
                    theGame.resolveSudoku();
                } else {
                    int rowNumber = scanner2.nextInt();
                    int columnNumber = scanner2.nextInt();
                    int value = scanner2.nextInt();

                    theGame.setBoardElement(rowNumber - 1, columnNumber - 1, value);
                }

                System.out.print(board);

            } catch (InputMismatchException e) {
                System.out.println("Remember that row number, column number and value should be integers separated by ','");

            } catch (NoSuchElementException i) {
                System.out.println("Remember that row number, column number and value should be integers between 1 and " + theGame.getBoardSize());

            }
        }

    }
}
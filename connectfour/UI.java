package connectfour;

import java.util.Scanner;

/**
 * UI class
 */
public class UI {

    Scanner scanner;

    public UI() {
        scanner = new Scanner(System.in);
    }

    // Utility methods
    public String getXOrO(int whoseMove) {
        return (whoseMove == -1) ? "X" : "O";
    }

    public String getPlayerName(int whoseMove, String xName, String yName) {
        return (whoseMove == -1) ? xName : yName;
    }

    public boolean isLegalMove(State state, int col) {
        if (col < 0 || col >= Constants.BOARD_SIZE_X) {
            return false;
        }
        return state.getBoardCell(0, col) == Constants.BLANK;
    }

    // Prompt for input methods
    public String promptForName(int player) {
        System.out.printf(Constants.GET_PLAYER_NAME, player);
        return scanner.next();
    }

    public int getMoveCol(int whoseMove, State state) {
        int col = 0;
        while (col <= 0 || col >= 4) {
            try {
                System.out.printf(Constants.GET_COL_MOVE, getXOrO(whoseMove),
                        getPlayerName(whoseMove, state.getXName(), state.getYName()));
                col = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(Constants.INVALID_ROW_OR_COLUMN);
            }
        }
        return col;
    }

    public boolean startNewGame() {
        System.out.println(Constants.START_NEW_GAME);
        String yesOrNo = scanner.next();
        return yesOrNo == "T";
    }

    // Printing text methods
    public void printWelcome() {
        System.out.println(Constants.TITLE);
    }

    public void printBoard(State state) {
        for (int row = 0; row < Constants.BOARD_SIZE_Y; row++) {
            for (int col = 0; col < Constants.BOARD_SIZE_X; col++) {
                System.out.print(state.getBoardCell(row, col));
            }
            System.out.println();
        }
    }

    public void printInvalidRowOrColumn(int rowOrCol) {
        System.out.printf(Constants.INVALID_ROW_OR_COLUMN, rowOrCol);
    }

    public void printInvalidMove(int row, int col) {
        System.out.printf(Constants.INVALID_MOVE_ERROR, row, col);
    }

    public void printMove(State state, int row, int col) {
        System.out.printf(Constants.PRINT_MOVE, getXOrO(state.getWhoseMove()),
                getPlayerName(state.getWhoseMove(), state.getXName(), state.getYName()), row, col);
    }

    public void printWinner(State state) {
        System.out.printf(Constants.WINNER, getXOrO(state.getWhoseMove()),
                getPlayerName(state.getWhoseMove(), state.getXName(), state.getYName()));
    }

    public void printTieGame() {
        System.out.println(Constants.TIE_GAME);
    }
}

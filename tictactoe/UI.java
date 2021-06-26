package tictactoe;

/**
 * UI class
 */
public class UI
{

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

public boolean isLegalMove(int state, int row, int col) {
  return 1 <= row && row <= Constants.BOARD_SIZE &&
    1 <= col && col <= Constants.BOARD_SIZE &&
    state.getBoardCell(row, col) == Constants.BLANK;
}

// Prompt for input methods
public String promptForName(int player) {
    System.out.printf(Constants.GET_PLAYER_NAME, player);
    return scanner.next();
}

public int getMoveRow(int whoseMove) {
    int row;
    while (row <= 0 || row >= 4) {
        try {
            System.out.printf(Constants.GET_ROW_MOVE, getXOrO(whoseMove), getPlayerName(whoseMove));
            row = scanner.nextInt();
        } catch (Exception e) {
            System.out.println(Constants.INVALID_ROW_OR_COLUMN);
        }
    }
    return row;
}

public int getMoveCol(int whoseMove) {
    int col;
    while (col <= 0 || col >= 4) {
        try {
            System.out.printf(Constants.GET_COL_MOVE, getXOrO(whoseMove), getPlayerName(whoseMove));
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
    System.out.println(Constants.DIVIDER_STRING);
    for (int row = 0; row < Constants.BOARD_SIZE; row++) {
        System.out.printf(Constants.BOARD_STRING, getXOrO(state.getBoardCell(row, 0)), getXOrO(state.getBoardCell(row, 1)), getXOrO(state.getBoardCell(row, 2)));
        System.out.println(Constants.DIVIDER_STRING);
    }
}

public void printInvalidRowOrColumn(int rowOrCol) {
    System.out.printf(Constants.INVALID_ROW_OR_COLUMN, rowOrCol);
}

public void printInvalidMove(int row, int col) {
    System.out.printf(Constants.INVALID_MOVE_ERROR, row, col);
}

public void printMove(State state, int row, int col) {
    System.out.printf(Constants.PRINT_MOVE, getXOrO(state.getWhoseMove(), getPlayerName(state.whoseMove), row, col));
} 

public void printWinner(State state) {
    System.out.printf(Constants.WINNER, getXOrO(state.getWhoseMove()), state.getPlayerName(state.whoseMove));
}

public void printTieGame() {
    System.out.println(Constants.TIE_GAME);
}
}

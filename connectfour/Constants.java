package connectfour;

/**
 * Tic-Tac-Toe game constants
 */

public class Constants
{
    // Valid board size
    public static final int BOARD_SIZE_X = 7;
    public static final int BOARD_SIZE_Y = 6;

    // Valid board values
    public static final int X = -1;    // Indicates an "X"
    public static final int Y = 1;     // Indicates an "O"
    public static final int BLANK = 0; // Indicates a blank square

    // Game states
    public static final int STANDBY = 0;
    public static final int GET_X_NAME = 1;
    public static final int GET_Y_NAME = 2;
    public static final int GET_X_MOVE = 3;
    public static final int GET_Y_MOVE = 4;
    public static final int MAKE_MOVE = 5;
    public static final int CHECK_IF_WINNER = 6;
    public static final int CHECK_IF_TIE = 7;
    public static final int X_WINS = 8;
    public static final int Y_WINS = 9;
    public static final int GAME_OVER = 10;
    public static final int QUIT_PROGRAM = 11;
    
    // Strings
    public static final String DIVIDER_STRING = "|---|---|---|";
    public static final String BOARD_STRING = "| %s ";
    public static final String GET_PLAYER_NAME = "Player %s: What is your name?\n";
    public static final String TITLE = "Thanks for playing Tic-Tac-Toe!\n";
    public static final String GET_ROW_MOVE = "Player %s (%s): Enter the row for your next move\n";
    public static final String GET_COL_MOVE = "Player %s (%s): Enter the column for your next move\n";
    public static final String INVALID_ROW_OR_COLUMN = "Your row and column must be 1, 2, or 3\n";
    public static final String INVALID_MOVE_ERROR = "Row %d column %d is not a valid move. Please try again\n";
    public static final String PRINT_MOVE = "Player %s (%s) move to %d %d\n";
    public static final String WINNER = "%s - %s is the winner!\n";
    public static final String TIE_GAME = "It's a tie game!\n";
    public static final String START_NEW_GAME = "Start a new game (Y or N)?\n";
}

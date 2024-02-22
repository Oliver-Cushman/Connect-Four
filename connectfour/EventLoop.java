package connectfour;

public class EventLoop {

  // Instance variables for the UI and State classes
  State state;
  UI ui;
  int row, col;

  public EventLoop() {
    state = new State();
    ui = new UI();
  }

  public void eventLoop() {
    while (state.getGameState() != Constants.QUIT_PROGRAM) {
      int gameState = state.getGameState();
      if (gameState == Constants.STANDBY) {
        state.setGameState(Constants.GET_X_NAME);

      } else if (gameState == Constants.GET_X_NAME) {
        state.setXName(ui.promptForName(Constants.X));
        state.setGameState(Constants.GET_Y_NAME);
    
      } else if (gameState == Constants.GET_Y_NAME) {
        state.setYName(ui.promptForName(Constants.Y));
        state.setGameState(Constants.GET_X_MOVE);
    
      } else if (gameState == Constants.GET_X_MOVE) {
        col = ui.getMoveCol(state.getWhoseMove(), state) - 1;
        if (ui.isLegalMove(state, col)) {
          state.setGameState(Constants.MAKE_MOVE);
        }

      } else if (gameState == Constants.GET_Y_MOVE) {
        col = ui.getMoveCol(state.getWhoseMove(), state) - 1;
        if (ui.isLegalMove(state, col)) {
          state.setGameState(Constants.MAKE_MOVE);
        }

      } else if (gameState == Constants.MAKE_MOVE) {
        ui.printMove(state, row, col);
        state.setBoardCell(col, state.getWhoseMove());
        state.setGameState(Constants.CHECK_IF_WINNER);
        ui.printBoard(state);
      } else if (gameState == Constants.CHECK_IF_WINNER) {
        if (state.isWinner()) {
          if (state.getWhoseMove() == Constants.X) {
            state.setGameState(Constants.X_WINS);
          } else {
            state.setGameState(Constants.Y_WINS);
          }
        } else {
          state.setGameState(Constants.CHECK_IF_TIE);
        }

      } else if (gameState == Constants.CHECK_IF_TIE) {
        if (state.isTie()) {
          ui.printTieGame();
          state.setGameState(Constants.GAME_OVER);
        } else {
          state.setWhoseMove(state.getWhoseMove() * -1);
          if (state.getWhoseMove() == Constants.X) {
            state.setGameState(Constants.GET_X_MOVE);
          } else {
            state.setGameState(Constants.GET_Y_MOVE);
          }
        }

      } else if (gameState == Constants.X_WINS) {
        ui.printWinner(state);
        state.setGameState(Constants.GAME_OVER);
    
      } else if (gameState == Constants.Y_WINS) {
        ui.printWinner(state);
        state.setGameState(Constants.GAME_OVER);

      } else if (gameState == Constants.GAME_OVER) {
        if (ui.startNewGame()) {

          state.setGameState(Constants.STANDBY);
        } else {
         state.setGameState(Constants.QUIT_PROGRAM);
        }
      }
    }
  }
}

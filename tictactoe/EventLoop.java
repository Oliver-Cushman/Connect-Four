package tictactoe;

public class EventLoop {

  // Instance variables for the UI and State classes
  State state = new State();
  UI ui = new UI();
  int row, col;

  public void eventLoop() {
    while (state.getGameState() != Constants.QUIT_PROGRAM) {
      int gameState = state.getGameState();
      if (gameState == Constants.STANDBY) {
        state.setGameState(Constants.GET_X_NAME);

      } else if (gameState == Constants.GET_X_NAME) {
        state.setXName(ui.promptForName(Constants.X));
        state.setGameState(Constants.GET_O_NAME);
    
      } else if (gameState == Constants.GET_O_NAME) {
        state.setYName(ui.promptForName(Constants.O));
        state.setGameState(Constants.GET_X_MOVE);
    
      } else if (gameState == Constants.GET_X_MOVE) {
        row = ui.getMoveRow(state.getWhoseMove());
        col = ui.getMoveCol(state.getWhoseMove());
        if (ui.isLegalMove(state, row, col)) {
          state.setGameState(Constants.MAKE_MOVE);
        }

      } else if (gameState == Constants.GET_O_MOVE) {
        row = ui.getMoveRow(state.getWhoseMove());
        col = ui.getMoveCol(state.getWhoseMove());
        if (ui.isLegalMove(state, row, col)) {
          state.setGameState(Constants.MAKE_MOVE);
        }

      } else if (gameState == Constants.MAKE_MOVE) {
        ui.printMove(state, row, col);
        state.setBoardCell(state.getWhoseMove(), row, col);
        state.setGameState(Constants.CHECK_IF_WINNER);

      } else if (gameState == Constants.CHECK_IF_WINNER) {
        if (state.isWinner()) {
          if (state.getWhoseMove() == Constants.X) {
            state.setGameState(Constants.X_WINS);
          } else {
            state.setGameState(Constants.O_WINS);
          }
        } else {
          state.setGameState(Constants.CHECK_IF_TIE);
        }

      } else if (gameState == Constants.CHECK_IF_TIE) {
        if (state.isTie()) {
          ui.printTie();
          state.setGameState(Constants.GAME_OVER);
        } else {
          state.setWhoseMove(state.getWhoseMove() * -1);
          if (state.getWhoseMove() == Constants.X) {
            state.setGameState(Constants.GET_X_MOVE);
          } else {
            state.setGameState(Constants.GET_O_MOVE);
          }
        }

      } else if (gameState == Constants.X_WINS) {
        ui.printWinner(state);
        state.setGameState(Constants.GAME_OVER);
    
      } else if (gameState == Constants.O_WINS) {
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

package com.cristina.tdd;

public class TicTacToe {

  private Character[][] board = {
      {'\0', '\0', '\0'},
      {'\0', '\0', '\0'},
      {'\0', '\0', '\0'}
  };
  private char lastPlayer = '\0';
  private static final int SIZE = 3;

  public String place(int x, int y) {
    checkAxis(x);
    checkAxis(y);
    lastPlayer=nextPlayer();
    setBox(x,y,lastPlayer);
    if(isWin()) {
      return lastPlayer + " is the winner";
    }
    return "No winner";
  }

  private boolean isWin() {
    for(int index=0;index<SIZE;index++) {
      if(board[0][index] + board[1][index] + board[2][index] == (lastPlayer*SIZE)) {
        return true;
      }
    }
    return false;
  }

  private void checkAxis(int axis) {
    if(axis<1 || axis>3) {
      throw new RuntimeException("You are outside of the board");
    }
  }

  private void setBox(int x, int y, char lastPlayer) {
    if(board[x-1][y-1] != '\0') {
      throw new RuntimeException("Box is occupied");
    } else {
      board[x-1][y-1]=lastPlayer;
    }
  }

  public char nextPlayer() {
    if(lastPlayer=='X') return 'O';
    else return 'X';
  }
}

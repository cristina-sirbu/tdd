package com.cristina.tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PlacementValidationTests {

  @Rule
  public ExpectedException exception = ExpectedException.none();
  private TicTacToe ticTacToe;

  @Before
  public final void before() {
    ticTacToe = new TicTacToe();
  }

  @Test
  public void whenXOutsideBoardThenRuntimeException() {
    exception.expect(RuntimeException.class);
    ticTacToe.place(4,1);
  }

  @Test
  public void whenYOutsideBoardThenRuntimeException() {
    exception.expect(RuntimeException.class);
    ticTacToe.place(1,4);
  }

  @Test
  public void whenSpaceIsOccupiedThrowRuntimeException() {
    ticTacToe.place(1,1);
    exception.expect(RuntimeException.class);
    ticTacToe.place(1,1);
  }

  @Test
  public void givenFirstTurnWhenNextPlayerThenX() {
    assertEquals('X', ticTacToe.nextPlayer());
  }

  @Test
  public void givenTurnAfterXWhenNextPlayerThenO() {
    ticTacToe.place(1,1);
    assertEquals('O', ticTacToe.nextPlayer());
  }

  @Test
  public void whenPlayThenNoWinner() {
    String actual = ticTacToe.place(1,1);
    assertEquals("No winner", actual);
  }

  @Test
  public void whenPlayAndWholeHorizontalLineThenWinner () {
    ticTacToe.place(1,1);
    ticTacToe.place(1,2);
    ticTacToe.place(2,1);
    ticTacToe.place(2,2);
    String actual = ticTacToe.place(3,1);
    assertEquals("X is the winner", actual);
  }

  @Test
  public void whenPlayAndWholeVerticalLineThenWinner() {
    ticTacToe.place(2,1);
    ticTacToe.place(1,1);
    ticTacToe.place(3,1);
    ticTacToe.place(1,2);
    ticTacToe.place(2,2);
    String actual = ticTacToe.place(1,3);
    assertEquals("O is the winner", actual);
  }

}

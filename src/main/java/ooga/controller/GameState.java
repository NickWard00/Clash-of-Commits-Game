package ooga.controller;

import ooga.model.HighScore;
import ooga.view.LoseScene;
import ooga.view.WinScene;

/**
 * This interface shows what happens when the game determines whether you won or lost the game.
 *
 * @author James Qu
 */
public interface GameState {
  /**
   * This method modifies a boolean variable to determine if the game is won or not.
   */
  boolean determineWin();

  /**
   * This method modifies a boolean variable to determine if the game is lost of not.
   */
  boolean determineLost();

  /**
   * This method determines and sets the high score.
   */
  void setHighScore(HighScore addScore);

  /**
   * This method obtains the high score of the game.
   */
  HighScore getHighScore();

  /**
   * This method displays the new scene when the game is won.
   */
  WinScene showWin();

  /**
   * This method displays the new scene when the game is lost.
   */
  LoseScene showLost();
}

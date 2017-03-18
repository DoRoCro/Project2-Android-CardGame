package com.codeclan.cardgame;

/**
 * Created by user on 18/03/2017.
 */

public interface GameMechanics {
    public void play();
    public void setup();
    public void playARound();
    public void playerTakesTurn(Player player);
    public void updateLog(Player player);
    public boolean isWon();
    public boolean isOver();
    public Player winner();
    public void endGame();
}

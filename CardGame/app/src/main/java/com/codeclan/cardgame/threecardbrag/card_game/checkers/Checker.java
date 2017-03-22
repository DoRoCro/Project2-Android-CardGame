package com.codeclan.cardgame.threecardbrag.card_game.checkers;
import com.codeclan.cardgame.threecardbrag.card_game.*;

public interface Checker{
  Player check(Player player1, Player player2);
  String getWinType();
}
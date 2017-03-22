package com.codeclan.cardgame.threecardbrag.card_game.checkers;
//import checkers.*;

import com.codeclan.cardgame.threecardbrag.card_game.*;
import java.util.*;

public class PrialChecker implements Checker {

  private ArrayList<Player> winners = new ArrayList<Player>();

  public String getWinType(){
    return "Prial";
  }

  public void checkForPrial(Player player){
    Card[] hand = player.getCards();

    if (hand[0].getNumber() == hand[1].getNumber() && hand[1].getNumber() == hand[2].getNumber()){
      winners.add(player);
    }
  }

  public Player check(Player player1, Player player2){
    checkForPrial(player1);
    checkForPrial(player2);

    if (winners.size() > 0) {
      if (winners.size() == 1) {
        return winners.get(0);
      }
      else {
      // If both players have a Prial, the player whose Prial is of the highest number wins. This version has Ace as low. Could add in to have 3 as the top number. 
        if (player1.getCards()[0].getNumber() > player2.getCards()[0].getNumber()){
          return player1;
        }
        return player2;
      }
    }
    return null;
  }

}
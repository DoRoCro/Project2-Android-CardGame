package com.codeclan.cardgame.threecardbrag.card_game.checkers;
import com.codeclan.cardgame.threecardbrag.card_game.*;
import com.codeclan.cardgame.threecardbrag.card_game.*;
import java.util.*;

public class FlushChecker implements Checker {

  private ArrayList<Player> winners = new ArrayList<Player>();
  private HighCardChecker highCardChecker = new HighCardChecker();
  public String getWinType(){
    return "Flush";
  }

  public boolean checkForFlush(Player player){
    Card[] hand = player.getCards();

    if(hand[0].getSuit() == hand[1].getSuit() && hand[1].getSuit() == hand[2].getSuit()){
      winners.add(player);
      return true;
    }
    return false;
  }

  public Player check(Player player1, Player player2){
    checkForFlush(player1);
    checkForFlush(player2);

    if (winners.size() > 0) {
      if (winners.size() == 1) {
        return winners.get(0);
      }
      else {
        return highCardChecker.check(player1, player2);
      }
    }
    return null;
  }

}
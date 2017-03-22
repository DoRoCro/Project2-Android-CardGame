package com.codeclan.cardgame.threecardbrag.card_game.checkers;
import com.codeclan.cardgame.threecardbrag.card_game.*;
import java.util.*;

public class RunChecker implements Checker {

  private ArrayList<Player> winners = new ArrayList<Player>();

  public String getWinType(){
    return "Run";
  }

  public boolean checkForRun(Player player){
    Hand hand = player.getHand();
    ArrayList<Integer> cardNumbers = hand.makeCardNumbersArray();
    int max = hand.findMaxCard();

    if (cardNumbers.contains(max - 1)){
      if (cardNumbers.contains(max - 2)){
        winners.add(player);
        return true;
      }
    }
    return false;
  }

  public Player check(Player player1, Player player2){
    checkForRun(player1);
    checkForRun(player2);

    if(winners.size() > 0){
      if (winners.size() == 1){
        return winners.get(0);
      }
      else {
        // If both players have a standard run (no flush), the one with the highest card in wins. If both runs are the same, player who refused to bet higher wins (if no betting, just first player by random luck).
        return highestCard(player1, player2);
      }
    }
    return null;
  }

  public Player highestCard(Player player1, Player player2){
    int player1Max = player1.getHand().findMaxCard();
    int player2Max = player2.getHand().findMaxCard();

    if (player1Max > player2Max){
      return player1;
    }
    else if (player2Max > player1Max){
      return player2;
    }
    // if there is no diff in highest card of running flush, return player who refused to bet any higher - always enter this player as player1. 
    return player1;
  }

}
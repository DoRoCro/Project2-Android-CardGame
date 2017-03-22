package com.codeclan.cardgame.threecardbrag.card_game.checkers;
import com.codeclan.cardgame.threecardbrag.card_game.*;
//import com.codeclan.cardgame.threecardbrag.card_game.checkers.*;

import java.util.*;

public class PairChecker implements Checker {

  private ArrayList<Player> winners = new ArrayList<Player>();

  public String getWinType(){
    return "Pair";
  }

  public void checkForPair(Player player){
    Card[] hand = player.getCards();

    if (hand[0].getNumber() == hand[1].getNumber() || hand[1].getNumber() == hand[2].getNumber() || hand[0].getNumber() == hand[2].getNumber()){
      winners.add(player);    
    }
  }

  public Player check(Player player1, Player player2){
    checkForPair(player1);
    checkForPair(player2);

    if (winners.size() > 0) {
      if (winners.size() == 1) {
        return winners.get(0);
      }
      else {
        return highestPair(player1, player2);
      }
    }
    return null;
  }

  public Player highestPair(Player player1, Player player2){
    // working on it

    // get the pair
    ArrayList<Integer> player1Numbers = player1.getHand().makeCardNumbersArray();
    ArrayList<Integer> player2Numbers = player2.getHand().makeCardNumbersArray();

    Collections.sort(player1Numbers);
    Collections.sort(player2Numbers);

    // When 3 cards including a pair are sorted, the middle card is always going to be part of the pair. 

    Integer player1Pair = player1Numbers.get(1);
    player1Numbers.remove(player1Pair);
    player1Numbers.remove(player1Pair);
    Integer player1Spare = player1Numbers.get(0);

    Integer player2Pair = player2Numbers.get(1);
    player2Numbers.remove(player2Pair);
    player2Numbers.remove(player2Pair);
    Integer player2Spare = player2Numbers.get(0);

    // compare pair cards
    if (player1Pair > player2Pair){
      return player1;
    }
    else if (player2Pair > player1Pair){
      return player2;
    }
    else if (player2Spare > player1Spare){
      return player2;
    }
    return player1;
  }

}
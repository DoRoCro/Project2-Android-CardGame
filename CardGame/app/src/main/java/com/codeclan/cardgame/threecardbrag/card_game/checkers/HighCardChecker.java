package com.codeclan.cardgame.threecardbrag.card_game.checkers;
import com.codeclan.cardgame.threecardbrag.card_game.*;
import java.util.*;

public class HighCardChecker implements Checker {

  private ArrayList<Player> winners = new ArrayList<Player>();
  public String getWinType(){
    return "High Card";
  }

  public Player check(Player player1, Player player2){

    ArrayList<Integer> player1Numbers = player1.getHand().makeCardNumbersArray();
    ArrayList<Integer> player2Numbers = player2.getHand().makeCardNumbersArray();

    Collections.sort(player1Numbers);
    Collections.sort(player2Numbers);

    for (int i = 2; i > -1; i--){
      if (player1Numbers.get(i) > player2Numbers.get(i)){
        return player1;
      }
      else if (player2Numbers.get(i) > player1Numbers.get(i)){
        return player2;
      }
    }

    return player1;
  }

}
package com.codeclan.cardgame.threecardbrag.card_game.checkers;

import com.codeclan.cardgame.threecardbrag.card_game.*;
import java.util.*;

public class RunningFlushChecker implements Checker {

  private ArrayList<Player> winners = new ArrayList<Player>();
  private RunChecker runChecker = new RunChecker();
  private FlushChecker flushChecker = new FlushChecker();

  public String getWinType(){
    return "Running Flush";
  }

  public void checkForRunningFlush(Player player){
    boolean run = runChecker.checkForRun(player);
    boolean flush = flushChecker.checkForFlush(player);

    if(run && flush){
      winners.add(player);
    }
  }

  public Player check(Player player1, Player player2){
    checkForRunningFlush(player1);
    checkForRunningFlush(player2);

    if(winners.size() > 0){
      if (winners.size() == 1){
        return winners.get(0);
      }
      else {
        // If both players have a running flush, the player with the highest run (shown by the highest card of the run) wins. If both runs are the same, player who refused to bet higher wins (if no betting, just first player by random luck).
        return runChecker.highestCard(player1, player2);
      }
    }
    return null;
  }

}
package com.codeclan.cardgame.threecardbrag.card_game;
import com.codeclan.cardgame.threecardbrag.card_game.checkers.*;
import java.util.*;

public class WinChecker {

  private Player player1;
  private Player player2;
  private ArrayList<Player> winners = new ArrayList<Player>();
  private String winType = "None";
  private ArrayList<Checker> checkerList;

  public WinChecker(ArrayList<Checker> checkerList){
    this.checkerList = checkerList;
  }

  public void setPlayers(ArrayList<Player> players){
    this.player1 = players.get(0);
    this.player2 = players.get(1);
  }

  public Player checkForWin(){
    Player winner;

    for (Checker checker : this.checkerList){
      winner = checker.check(player1, player2);

      if(winner != null){
        this.winType = checker.getWinType();
        return winner;
      }
    } 

    return null;
  }

  public String printHands(){
    return player1.printHand() + " -- " + player2.printHand();
  }

  public String getWinType(){
    return winType;
  }

}
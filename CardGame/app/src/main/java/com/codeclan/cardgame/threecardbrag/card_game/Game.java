package com.codeclan.cardgame.threecardbrag.card_game;
//import card_game.*;

import java.util.*;

public abstract class Game {

  ArrayList<Player> players = new ArrayList<Player>();
  ArrayList<Card> deck = new ArrayList<Card>();
  WinChecker winChecker;
  String winType;
  Player winner;
  abstract void setup();
  abstract void startPlay();
  abstract void endPlay();

  public final void play(){
    setup();
    startPlay();
    endPlay();
  }

  public ArrayList<Card> getDeck(){
    return this.deck;
  }

  public void addPlayer(Player player){
    players.add(player);
  }

  public int playerCount(){
    return players.size();
  }

  public String getWinType(){
    return this.winType;
  }

  public Player getWinner(){
    return this.winner;
  }

}
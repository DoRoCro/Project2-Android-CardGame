package com.codeclan.cardgame.threecardbrag.card_game;
//import card_game.*;

public class Player {

  private String name;
  private Hand hand;

  public Player(String name){
    this.name = name;
  }

  public String getName(){
    return this.name;
  }

  public void setHand(Hand hand){
    this.hand = hand;
  }

  public Hand getHand(){
    return this.hand;
  }

  public Card[] getCards(){
    return this.hand.getCards();
  }

  public String printHand(){
    return this.hand.toString();
  }

}
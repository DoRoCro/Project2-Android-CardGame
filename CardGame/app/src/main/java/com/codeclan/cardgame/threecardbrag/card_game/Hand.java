package com.codeclan.cardgame.threecardbrag.card_game;
//import card_game.*;

import java.util.*;

public class Hand {

  private Card[] cards = new Card[3];

  public Hand(Card card1, Card card2, Card card3){
    cards[0] = card1;
    cards[1] = card2;
    cards[2] = card3;
  }

  public Card[] getCards(){
    return this.cards;
  }

  public ArrayList<Integer> makeCardNumbersArray(){
    ArrayList<Integer> cardNumbers = new ArrayList<Integer>();
    cardNumbers.add(cards[0].getNumber());
    cardNumbers.add(cards[1].getNumber());
    cardNumbers.add(cards[2].getNumber());
    return cardNumbers;
  }

  public int findMaxCard(){
    ArrayList<Integer> cardNumbers = makeCardNumbersArray();
    int max = (int) Collections.max(cardNumbers);
    return max;
  }

  public String toString(){
    return cards[0].toString() + ", " + cards[1].toString() + ", " + cards[2].toString();
  }

}
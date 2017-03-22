package com.codeclan.cardgame.threecardbrag.card_test;

import com.codeclan.cardgame.threecardbrag.card_game.*;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.*;

public class HandTest {

  Hand hand;
  Card card1;
  Card card2;
  Card card3;

  @Before
  public void before(){
    card1 = new Card(2, Suit.Clubs);
    card2 = new Card(3, Suit.Spades);
    card3 = new Card(11, Suit.Diamonds);
    hand = new Hand(card1, card2, card3);
  }

  @Test
  public void hasThreeCards(){
    assertEquals(3, hand.getCards().length);
  }

  @Test
  public void canMakeNumbersArray(){
    ArrayList<Integer> array = new ArrayList<Integer>();
    array.add(2);
    array.add(3);
    array.add(11);
    assertEquals(array, hand.makeCardNumbersArray());
  }

  @Test
  public void canFindMaxCard(){
    assertEquals(11, hand.findMaxCard());
  }

  @Test
  public void canPrintCards(){
    assertEquals("Two of Clubs, Three of Spades, Jack of Diamonds", hand.toString());
  }
}


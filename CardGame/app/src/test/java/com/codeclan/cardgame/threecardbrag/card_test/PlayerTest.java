package com.codeclan.cardgame.threecardbrag.card_test;

import com.codeclan.cardgame.threecardbrag.card_game.*;

import static org.junit.Assert.*;
import org.junit.*;

public class PlayerTest {

  Player player1;
  Player player2;
  Card card1;
  Card card2;
  Card card3;

  @Before
  public void before(){
    player1 = new Player("Beth");
    player2 = new Player("Jay");
    card1 = new Card(2, Suit.Clubs);
    card2 = new Card(3, Suit.Spades);
    card3 = new Card(11, Suit.Diamonds);
    Hand hand = new Hand(card1, card2, card3);
    player1.setHand(hand);
  }

  @Test
  public void hasName(){
    assertEquals("Beth", player1.getName());
  }

  @Test
  public void handStartsEmpty(){
    assertNull(player2.getHand());
  }

  @Test 
  public void canSetHand(){
    assertEquals(card1, player1.getCards()[0]);
  }

  @Test
  public void canPrintHand(){
    assertEquals("Two of Clubs, Three of Spades, Jack of Diamonds", player1.printHand());
  }

}
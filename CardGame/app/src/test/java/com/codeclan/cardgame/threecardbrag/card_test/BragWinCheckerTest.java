package com.codeclan.cardgame.threecardbrag.card_test;

import com.codeclan.cardgame.threecardbrag.card_game.*;
import com.codeclan.cardgame.threecardbrag.card_game.checkers.*;

import static org.junit.Assert.*;
import org.junit.*;
import java.util.*;

public class BragWinCheckerTest {

  Player player1;
  Player player2;
  WinChecker winChecker;
  Card card1;
  Card card2;
  Card card3;
  Card card4;
  Card card5;
  Card card6;
  Card card7;
  Card card8;
  Card card9;

  @Before
  public void before(){
    player1 = new Player("Beth");
    player2 = new Player("Rick");

    card1 = new Card(2, Suit.Clubs);
    card2 = new Card(3, Suit.Clubs);
    card3 = new Card(4, Suit.Clubs);

    card4 = new Card(3, Suit.Clubs);
    card5 = new Card(3, Suit.Spades);
    card6 = new Card(3, Suit.Diamonds);

    card7 = new Card(6, Suit.Clubs);
    card8 = new Card(6, Suit.Spades);
    card9 = new Card(6, Suit.Hearts);

    Hand hand1 = new Hand(card1, card2, card3);
    player1.setHand(hand1);
    Hand hand2 = new Hand(card4, card5, card6);
    player2.setHand(hand2);

    PrialChecker prialChecker = new PrialChecker();
    RunningFlushChecker runningFlushChecker = new RunningFlushChecker();
    RunChecker runChecker = new RunChecker();
    FlushChecker flushChecker = new FlushChecker();
    PairChecker pairChecker = new PairChecker();
    HighCardChecker highCardChecker = new HighCardChecker();

    ArrayList<Checker> checkerList = new ArrayList<Checker>();
    checkerList.add(prialChecker);
    checkerList.add(runningFlushChecker);
    checkerList.add(runChecker);
    checkerList.add(flushChecker);
    checkerList.add(pairChecker);
    checkerList.add(highCardChecker);

    winChecker = new WinChecker(checkerList);

    ArrayList<Player> players = new ArrayList<Player>();
    players.add(player1);
    players.add(player2);
    winChecker.setPlayers(players);
  }

  @Test
  public void hasTwoHands(){
    assertEquals("Two of Clubs, Three of Clubs, Four of Clubs -- Three of Clubs, Three of Spades, Three of Diamonds", winChecker.printHands());
  }

  @Test
  public void canCheckWinner_OnePrial(){
    assertEquals(player2, winChecker.checkForWin());
    assertEquals("Prial", winChecker.getWinType());
  }

  @Test
  public void canCheckWinner_TwoPrials(){
    Hand hand = new Hand(card7, card8, card9);
    player1.setHand(hand);
    assertEquals(player1, winChecker.checkForWin());
  }

  @Test
  public void canCheckWinner_OneRunningFlush(){
    Hand hand = new Hand(card4, card7, card2);
    player2.setHand(hand);
    assertEquals(player1, winChecker.checkForWin());
    assertEquals("Running Flush", winChecker.getWinType());
  }

  @Test
  public void canCheckWinner_TwoRunningFlushes(){
    Card cardA = new Card(3, Suit.Hearts);
    Card cardB = new Card(4, Suit.Hearts);
    Card cardC = new Card(5, Suit.Hearts);

    Hand hand = new Hand(cardA, cardB, cardC);
    player2.setHand(hand);
    assertEquals(player2, winChecker.checkForWin());
  }

}
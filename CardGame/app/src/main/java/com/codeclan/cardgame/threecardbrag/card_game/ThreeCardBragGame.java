package com.codeclan.cardgame.threecardbrag.card_game;
//import card_game.*;
//import checkers.*;
import com.codeclan.cardgame.threecardbrag.card_game.checkers.*;

import java.util.*;

public class ThreeCardBragGame extends Game {

  public ThreeCardBragGame(ArrayList<Player> players){
    this.players = players;

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

    this.winChecker = new WinChecker(checkerList);
  }

  public void setup(){
    buildDeck();
  }

  public void startPlay(){
    deal();
  }

  public void endPlay(){
    findWinner();
  }

  public void buildDeck(){
    for (int i=1; i< 14; i++) {
      Card cardClubs = new Card(i, Suit.Clubs);
      Card cardSpades = new Card(i, Suit.Spades);
      Card cardHearts = new Card(i, Suit.Hearts);
      Card cardDiamonds = new Card(i, Suit.Diamonds);
      deck.add(cardClubs);
      deck.add(cardSpades);
      deck.add(cardHearts);
      deck.add(cardDiamonds);
    }
    shuffleDeck();
  }

  public void shuffleDeck(){
    Collections.shuffle(deck);
  }

  public void deal(){
    if (deck.size() < 3){
      buildDeck();
    }
    for (Player player : this.players){
      Hand hand = new Hand(deck.get(0), deck.get(1), deck.get(2));
      player.setHand(hand);
      deck.remove(0);
      deck.remove(0);
      deck.remove(0);
    } 
  }

  public void findWinner(){
    winChecker.setPlayers(players);
    Player winner = winChecker.checkForWin();
    this.winType = winChecker.getWinType();
    this.winner = winner;
  }


}
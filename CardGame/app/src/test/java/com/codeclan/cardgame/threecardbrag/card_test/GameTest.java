package com.codeclan.cardgame.threecardbrag.card_test;

import com.codeclan.cardgame.threecardbrag.card_game.*;
import java.util.*;

import static org.junit.Assert.*;
import org.junit.*;

public class GameTest {

  ThreeCardBragGame game;
  Player player1;
  Player player2;

  @Before
  public void before(){
    player1 = new Player("Beth");
    player2 = new Player("Rick");
    ArrayList<Player> players = new ArrayList<Player>();
    players.add(player1);
    players.add(player2);
    game = new ThreeCardBragGame(players);
    game.setup();
  }

  @Test
  public void hasDeckOf52(){
    assertEquals(52, game.getDeck().size());
  }

  @Test
  public void canAddPlayersOnInit(){
    assertEquals(2, game.playerCount());
  }

  @Test
  public void dealsCards(){
    game.addPlayer(player1);
    game.addPlayer(player2);
    game.startPlay();
    assertNotNull(player1.getCards()[0]);
    assertNotNull(player2.getCards()[2]);
  }

}
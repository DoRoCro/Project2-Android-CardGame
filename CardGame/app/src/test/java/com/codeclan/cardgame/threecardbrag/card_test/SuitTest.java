package com.codeclan.cardgame.threecardbrag.card_test;

import com.codeclan.cardgame.threecardbrag.card_game.*;

import static org.junit.Assert.*;
import org.junit.*;

public class SuitTest {

  @Test
  public void hasFourValues(){
    assertEquals(4, Suit.values().length);
  }

  @Test
  public void firstValueisSpades(){
    assertEquals(Suit.Spades, Suit.values()[0]);
  }

}
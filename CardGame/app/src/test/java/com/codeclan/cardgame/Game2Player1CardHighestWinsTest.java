package com.codeclan.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 18/03/2017.
 */

public class Game2Player1CardHighestWinsTest {

    private Game2Player1CardHighestWinsN game;

    @Before
    public void before(){
        game = new Game2Player1CardHighestWinsN( 1, new ConsoleViewer());
    }

    @Test
    public void canDefineGame(){
        game.setup();
    }

    @Test
    public void canPlayARound(){
        // using unshuffled deck
        game.playARound();
        assertEquals("Shown cards: ACE of SPADES\nHidden cards:", game.getTurnlog().lastEntryFor(game.getPlayers()[0]).getHand().toString());
        assertEquals("Shown cards: KING of SPADES\nHidden cards:", game.getTurnlog().lastEntryFor(game.getPlayers()[1]).getHand().toString());
    }

    @Test
    public void canPlayGame(){
        game.play();
    }

    @Test
    public void playedGameHasWinner(){
        // using unshuffled deck
        game.playARound();
        assertEquals(true, game.isOver());
        assertEquals("You", game.winner().getName());
    }

}

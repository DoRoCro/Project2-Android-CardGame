package com.codeclan.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by DRC on 22/03/2017.
 */

public class Game2Player2CardHighestScoreWinsNTest {

    private Game2Player2CardHighestScoreWinsN game;

    @Before
    public void before(){
        game = new Game2Player2CardHighestScoreWinsN( 1, new ConsoleViewer());
    }
    @Test
    public void canDefineGame(){
        game.setup();
    }

    @Test
    public void canPlayARoundHas2Cards(){
        // using unshuffled deck
        game.playARound();
        assertEquals("Shown cards: ACE of SPADES QUEEN of SPADES\nHidden cards:", game.getTurnlog().lastEntryFor(game.getPlayers()[0]).getHand().toString());
        assertEquals("Shown cards: KING of SPADES JACK of SPADES\nHidden cards:", game.getTurnlog().lastEntryFor(game.getPlayers()[1]).getHand().toString());
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


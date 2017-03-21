package com.codeclan.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by user on 18/03/2017.
 */

public class TurnLogTest {

    TurnLog turnlog;
    Player player1;

    @Before
    public void before(){
        player1 = new Player("Slartibartfast", new Hand());
    }

    @Test
    public void canCreateTurnLog() {
        turnlog = new TurnLog();
        turnlog.addEntry(player1);
        assertEquals("Slartibartfast", turnlog.lastEntryFor(player1).getName());
        assertEquals("Shown cards:\nHidden cards:", turnlog.lastEntryFor(player1).getHand().toString());
    }
    @Test
    public void canReturnLastEntry() {
        turnlog = new TurnLog();
        turnlog.addEntry(player1);
        turnlog.addEntry(player1);
        turnlog.addEntry(player1);
        turnlog.addEntry(player1);
        turnlog.addEntry(new Player("LastEntry", new Hand()));
        assertEquals("Slartibartfast", turnlog.lastEntryFor(player1).getName());
        assertEquals("Shown cards:\nHidden cards:", turnlog.lastEntryFor(player1).getHand().toString());
        assertEquals("LastEntry", turnlog.lastEntry().getName());
    }

}

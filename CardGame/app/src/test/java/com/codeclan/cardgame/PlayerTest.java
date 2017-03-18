package com.codeclan.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by DRC on 18/03/2017.
 */

public class PlayerTest {
    Player player1;
    Player player2;


    @Before
    public void before(){
        player1 = new Player("Lister", new Hand());
        player2 = new Player("Rimmer", new Hand());
    }

    @Test
    public void playerHasName() {
        assertEquals("Lister", player1.getName());
    }

    @Test
    public void initialScoreZero() throws Exception {
        assertEquals( (Integer) 0, player1.getScore());
    }

    @Test
    public void canSetScore() throws Exception {
        player1.setScore(21);
        assertEquals( (Integer) 21, player1.getScore());
    }

    @Test
    public void canGetHand() {
        assertEquals( Hand.class,  player1.getHand().getClass());
    }

    @Test
    public void canReceiveCardToHand() {
        Card card = new Card(Card.Suit.CLUBS, Card.CardNumber.SEVEN);
        player1.getHand().receiveCard(card);
        player1.getHand().showCardByIndex(0);
        assertEquals("SEVEN of CLUBS", player1.getHand().topShownCard().toString());

    }
}

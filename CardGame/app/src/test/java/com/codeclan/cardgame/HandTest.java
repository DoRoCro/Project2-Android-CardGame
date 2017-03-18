package com.codeclan.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by DRC on 18/03/2017.
 */

public class HandTest {

    Hand hand1;
    Hand hand2;
    Card card1;

    @Before
    public void before(){
        hand1 = new Hand();
        hand2 = new Hand();
        card1 = new Card(Card.Suit.HEARTS, Card.CardNumber.QUEEN);
    }


    @Test
    public void handReceivesCardFaceDown(){
        hand1.receiveCard(card1);
        assertEquals("QUEEN of HEARTS", hand1.showCardByIndex(0));
    }

    @Test
    public void canListOutHand(){
        hand1.receiveCard(card1);
        assertEquals("Shown cards:\nHidden cards: QUEEN of HEARTS", hand1.toString());
    }

    @Test
    public void canListOutHandAfterShowing(){
        hand1.receiveCard(card1);
        hand1.showCardByIndex(0);
        assertEquals("Shown cards: QUEEN of HEARTS\nHidden cards:", hand1.toString());

    }

    @Test
    public void canSetPointsForHand(){
        hand1.setPoints(99);
        assertEquals((Integer)99, hand1.getPoints());
    }
    @Test
    public void canCountCardPointsinHand() {
        hand1.receiveCard(card1);
        Integer totalpoints = 0;
        for ( Card card : hand1.getAllCardsInHand()){
            totalpoints += card.getCardNumber().score();
        }
        assertEquals( (Integer) 12, totalpoints );
    }

}

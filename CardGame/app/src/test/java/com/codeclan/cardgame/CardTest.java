package com.codeclan.cardgame;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by DRC on 18/03/2017.
 */

public class CardTest {

    Card card;
    Card.Suit suit;
    Card.CardNumber cardnumber;

    @Before
    public void before(){
        card = new Card(Card.Suit.HEARTS, Card.CardNumber.ACE );
    }

    @Test
    public void cardHasSuitAndNumber() {
        assertEquals( Card.Suit.HEARTS ,card.getSuit());
        assertEquals( Card.CardNumber.ACE, card.getCardNumber());

    }

    @Test
    public void cardHasNumberAndSuit() {
        // test for lazy card creation where parameter order doesn't matter
        card = new Card( Card.CardNumber.ACE, Card.Suit.HEARTS );
        assertEquals( Card.Suit.HEARTS ,card.getSuit());
        assertEquals( Card.CardNumber.ACE, card.getCardNumber());
    }

    @Test
    public void cardCanBeDuplicated() {
        Card card2 = new Card( Card.CardNumber.ACE, Card.Suit.HEARTS );
        assertEquals(true, card2.equals(card));
    }

    @Test
    public void cardHasColour() {
        assertEquals(Card.SuitColour.RED, card.getSuitColour());
    }

    @Test
    public void cardNumberHasScore(){
        assertEquals(14, card.getCardNumber().score());
    }

    @Test
    public void cardCanSayName(){
        assertEquals("ACE of HEARTS", card.toString());
    }


}

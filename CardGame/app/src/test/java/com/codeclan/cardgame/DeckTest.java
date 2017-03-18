package com.codeclan.cardgame;

import org.junit.Before;
import org.junit.Test;

import java.util.Objects;
import java.util.concurrent.Callable;

import static org.junit.Assert.assertEquals;

/**
 * Created by DRC on 18/03/2017.
 */

public class DeckTest {
    Card.Suit suit;
    Card.CardNumber cardnumber;
    Card card;
    Deck deck;

    @Before
    public void before(){
        card = new Card(Card.Suit.values()[0], Card.CardNumber.values()[0]);
        deck = new Deck( Card.CardNumber.values(), Card.Suit.values() );
    }

    @Test
    public void canCreateNewFullDeck(){
        assertEquals(Card.CardNumber.values().length * Card.Suit.values().length, deck.cardCount());
    }

    @Test
    public void newDeckIsFullOfCards(){
        for (int i=0; i< deck.cardCount(); i++){
            // System.out.println("" + deck.getCardByIndex(i).getSuit() + deck.getCardByIndex(i).getCardNumber());
            assertEquals( deck.getCardByIndex(i).getClass(), Card.class );
        }
    }

    @Test
    public void canShuffleDeck(){
        // creates a string listing  of the deck contents before and after shuffle and compares
        //  This test is passed with a bad shuffle - e.g. swap two cards only, or just remove a card from deck.
        String signature1 = "";
        String signature2 = "";
        for (int i=0; i< deck.cardCount(); i++) {
            signature1 += deck.getCardByIndex(i).toString();
        }
        deck.shuffle();
        for (int i=0; i< deck.cardCount(); i++) {
            signature2 += deck.getCardByIndex(i).toString();
        }
        //
        // Not 100% guaranteed but shuffle matching initial
        // list very low likelihood for more than a few cards
        // (52 cards would be 1 in 52!  (approx 10^66)),
        // assuming Collections.shuffle() is genuinely random...

        assertEquals(false, Objects.equals(signature2, signature1));

        // System.out.println(signature1);
        // System.out.println(signature2);
    }

    @Test
    public void canDealACard(){
        int cardsBefore = deck.cardCount();
        Card lastcard = deck.getCardByIndex(cardsBefore - 1);
        Card dealt = deck.dealCard();
        int cardsAfter = deck.cardCount();
        // assertEquals("ACE of SPADES" , dealt.toString());  // initial version, generalised in line below
        assertEquals(Card.CardNumber.values()[Card.CardNumber.values().length -1]
                + " of " + Card.Suit.values()[Card.Suit.values().length - 1],
                dealt.toString());      // last card in unshuffled deck has been dealt
        assertEquals(cardsBefore , cardsAfter + 1 );          // deck has lost a card
        assertEquals(lastcard, dealt);                        // need to understand hashCode to see if this works as intended
    }

    @Test
    public void canReceiveACardBack(){
        int cardsBefore = deck.cardCount();
        Card dealt1 = deck.dealCard();
        Card dealt2 = deck.dealCard();
        assertEquals(cardsBefore -2, deck.cardCount());
        deck.returnCardToDeck(dealt1);
        assertEquals(cardsBefore -1, deck.cardCount());
        for (int i = 1; i < cardsBefore - 1 ; i++) {
            deck.dealCard();
        }
        assertEquals(dealt1, deck.dealCard());
    }

}

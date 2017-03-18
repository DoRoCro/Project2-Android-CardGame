package com.codeclan.cardgame;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by DRC on 18/03/2017.
 */

public class Deck {
    // Description
    // Container for Cards addressable by index.  Created by passing
    //  in enums of CardNumber and Suit to generate all combinations and store in ArrayList
    // Uses  1-based indexing to leave deck[0] for temporary use, e.g. card swaps.
    // Top of deck is the end of tha ArrayList
    // Bottom of deck is at index 0 of ArrayList

    private ArrayList<Card> deck;

    public Deck(Card.CardNumber[] faces, Card.Suit[] suits){
        deck = new ArrayList<Card>();
        for (Card.Suit suit : suits) {
            for ( Card.CardNumber face : faces){
                deck.add( new Card(suit, face)) ;
            }
        }
    }

    public int cardCount(){
        return deck.size();
    }

    public Card getCardByIndex(int index){
        // does not remove from deck, only lists (i.e. returning a copy object?)
        return deck.get(index);
    }

    public void shuffle(){
        Collections.shuffle(this.deck);
    }

    public Card dealCard(){
        // from top of deck
        return this.deck.remove(this.cardCount()-1);
    }

    public void returnCardToDeck(Card card){
        // return card to bottom of deck
        this.deck.add(0, card);  // add(index obj) takes care of renumbering
    }

}

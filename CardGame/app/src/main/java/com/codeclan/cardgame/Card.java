package com.codeclan.cardgame;

/**
 * Created by user on 18/03/2017.
 */

public class Card {

    //  Description
    //  Representation of a playing card with two basic characteristics,
    //  such as suit and card number (or rank, sequence etc)
    // including (and originally designed to cover) standard deck of playing cards

    public enum CardNumber {
        TWO   (2),
        THREE (3),
        FOUR  (4),
        FIVE  (5),
        SIX   (6),
        SEVEN (7),
        EIGHT (8),
        NINE  (9),
        TEN   (10),
        JACK  (11),
        QUEEN (12),
        KING  (13),
        ACE   (14);

        private final int score;

        CardNumber(int score){
            this.score = score;
        }
        public int score(){
            return this.score;
        }
    }

    public enum SuitColour{
        BLACK,
        RED;
    }

    public enum Suit {
        DIAMONDS (SuitColour.RED),
        CLUBS    (SuitColour.BLACK),
        HEARTS   (SuitColour.RED),
        SPADES   (SuitColour.BLACK);

        private final SuitColour colour;

        Suit(SuitColour colour){
            this.colour = colour;
        }

        public SuitColour colour(Suit suit){
            return suit.colour;
        }

        public SuitColour colour(){
            return this.colour;
        }
    }
    private Suit suit;
    private CardNumber cardnumber;

    public Card(Suit suit, CardNumber cardnumber) {
        this.suit = suit;
        this.cardnumber = cardnumber;
    }

    public Card( CardNumber cardnumber, Suit suit) {
        this(suit, cardnumber);
    }

    public Suit getSuit(){
        return this.suit;
    }
    public CardNumber getCardNumber(){
        return this.cardnumber;
    }

    public SuitColour getSuitColour(){
        return this.suit.colour();
    }

 /*   // @Override
    public Boolean equals(Card card){
        if (card instanceof Card)
            return (this.suit == card.getSuit() && this.cardnumber == card.getCardNumber());
        else
            return false;
    }
    // @Override
    // public int hashCode();{
    //   return hash(this.suit, this.cardnumber);
    // }
*/

    // Android Studio generated equals and hashCode methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Card card = (Card) o;

        if (getSuit() != null ? !getSuit().equals(card.getSuit()) : card.getSuit() != null)
            return false;
        return cardnumber != null ? cardnumber.equals(card.cardnumber) : card.cardnumber == null;

    }

    @Override
    public int hashCode() {
        int result = getSuit() != null ? getSuit().hashCode() : 0;
        result = 31 * result + (cardnumber != null ? cardnumber.hashCode() : 0);
        return result;
    }

    public String toString(){
        return "" + this.cardnumber + " of " + this.suit;
    }

}

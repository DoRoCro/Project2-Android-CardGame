package com.codeclan.cardgame;

import java.util.ArrayList;

/**
 * Created by user on 18/03/2017.
 */

public class Hand {
    // Hand represents a player's card holding
    // cards which can be shown or hidden
    // cards are received and held FACEDOWN (i.e. hidden) by default
    // A hand therefore consists of two lists, visible and hidden cards.

    private ArrayList<Card> faceups;
    private ArrayList<Card> facedowns;


    public Hand(){
        this.faceups = new ArrayList<Card>();
        this.facedowns = new ArrayList<Card>();
    }

    public void receiveCard( Card card ){
        this.facedowns.add(card);
    }

    public String showCardByIndex(int index){
        // move card from facedowns to end of faceups
        // and return card face details
        this.faceups.add( this.facedowns.remove(index) );
        return this.faceups.get(this.faceups.size() - 1 ).toString();
    }

    public String toString(){
        // return string listing contents of hand
        String holding = "Shown cards:";
        for ( Card faceup: faceups){
            holding += " " + faceup.toString();
        }
        holding += "\nHidden cards:";
        for ( Card facedown: facedowns){
            holding += " " + facedown.toString();
        }
        // System.out.println(holding);    // debug line
        return holding;
    }

    public Card topShownCard(){
        return this.faceups.get(faceups.size() - 1);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public Boolean equals(Hand handtocompare ){
        if (this.faceups.equals(handtocompare.faceups) &&
                this.facedowns.equals( handtocompare.faceups) ){
            return true;
        }
        else{
            return false;
        }
    }
}

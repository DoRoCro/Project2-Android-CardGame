package com.codeclan.cardgame;

/**
 * Created by DRC on 18/03/2017.
 */

public class Player {
    private String name;
    private Integer score;
    private Hand hand;

    public Player(String name, Hand hand) {
        this.name = name;
        this.score = 0;
        this.hand = new Hand();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Hand getHand() {
        return hand;
    }
}

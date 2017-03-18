package com.codeclan.cardgame;

import javax.xml.transform.Source;

/**
 * Created by user on 18/03/2017.
 */

public class Viewer {
    public Viewer() {
    }

    public void messageOut(String output){
        System.out.println(output);
    }

    public void listHand(Player player){
        messageOut("Player: " + player.getName());
        messageOut(player.getHand().toString());
    }

    public void winsRound(Player player) {
        messageOut("Player: " + player.getName() + " wins Round!");
    }

    public void winsGame(Player player) {
        messageOut("Congratulations " + player.getName() + ", you have won the game!");
    }
}

package com.codeclan.cardgame;

import javax.xml.transform.Source;

import com.codeclan.cardgame.TestActivity.*;

/**
 * Created by user on 18/03/2017.
 */

public class ConsoleViewer implements ViewerInterface {
    public ConsoleViewer() {
    }

    public String messageOut(String output){
        System.out.println(output);
        return output;
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

    public void waitForUserClick(Player player){
        // hook for onclick in activity
        // does nothing in console version
    }
}

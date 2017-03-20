package com.codeclan.cardgame;

/**
 * Created by user on 20/03/2017.
 */

public interface ViewerInterface {
    public String messageOut(String output);

    public void listHand(Player player);

    public void winsRound(Player player);

    public void winsGame(Player player);

    public void waitForUserClick(Player player);

}

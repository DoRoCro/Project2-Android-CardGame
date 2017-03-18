package com.codeclan.cardgame;

import java.util.ArrayList;

/**
 * Created by user on 18/03/2017.
 */

public class TurnLog {

    ArrayList<Player> log;

    public TurnLog() {
        this.log = new ArrayList<Player>();
    }

    public void addEntry(Player entry){
        this.log.add(entry);
    }
    public Player lastEntryFor(Player player){
        // get last entry in log for player.
        return this.log.get(this.log.lastIndexOf(player));
    }
}

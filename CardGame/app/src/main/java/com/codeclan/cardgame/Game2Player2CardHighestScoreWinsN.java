package com.codeclan.cardgame;

import java.util.HashMap;

/**
 * Created by DRC on 22/03/2017.
 */

public class Game2Player2CardHighestScoreWinsN extends Game2Player1CardHighestWinsN {


    public Game2Player2CardHighestScoreWinsN(Integer rounds, ViewerInterface viewer) {
        super(rounds, viewer);
        cardsInRound = 2;
    }




}

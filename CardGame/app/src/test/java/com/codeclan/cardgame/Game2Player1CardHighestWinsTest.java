package com.codeclan.cardgame;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by user on 18/03/2017.
 */

public class Game2Player1CardHighestWinsTest {

    private Game2Player1CardHighestWinsN game;

    @Before
    public void before(){
        game = new Game2Player1CardHighestWinsN( 1,new ConsoleViewer());
    }

    @Test
    public void canDefineGame(){

    }
}

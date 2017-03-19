package com.codeclan.cardgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Game2Player1CardHighestWinsN game = new Game2Player1CardHighestWinsN(2, new Viewer());

        game.setup();


    }
}

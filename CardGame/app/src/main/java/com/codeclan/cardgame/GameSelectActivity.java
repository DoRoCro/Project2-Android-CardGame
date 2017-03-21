package com.codeclan.cardgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GameSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_select);
    }


    public void startG2P1CHW(View v) {
        // goto simplest game

    }

    public void startG2P2CHW(View v) {
        // goto 2 card game
    }
}
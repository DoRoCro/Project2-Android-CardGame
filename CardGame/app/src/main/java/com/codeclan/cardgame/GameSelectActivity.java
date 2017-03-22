package com.codeclan.cardgame;

import android.content.Intent;
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
        Intent intent = new Intent(this, G2P1CHWPlayActivity.class);
        startActivity(intent);
    }

    public void startG2P2CHW(View v) {
        // goto simple 2 card game
        Intent intent = new Intent(this, G2P2CHWPlayActivity.class);
        startActivity(intent);
    }

    public void startG3CBrag(View v) {
        // goto 3 card brag game
//TODO
//        Intent intent = new Intent(this, G3CBragPlayActivity.class);
//        startActivity(intent);
    }
    public void startBlackJack(View v) {
        // goto simplest game
//        TODO
//        Intent intent = new Intent(this, BlackJackPlayActivity.class);
//        startActivity(intent);
    }
}
package com.codeclan.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class G2P2CHWResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g2p1chwresults);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();                   //retrieve parameters from intent
        int player1score = extras.getInt("player1score");
        int dealerscore = extras.getInt("dealerscore");
        String winner = extras.getString("winner");

        TextView infoPanel = (TextView) findViewById(R.id.info_panel_results);
        infoPanel.setText(getString(R.string.player_label) + " scored " + player1score + "\n" +
            getString((R.string.computer_label)) + " scored " + dealerscore +"\n" +
            "The winner is " + winner);

    }

//  button to return to launcher
    public void returnToSelectGame(View view) {
        Intent intent = new Intent(this, GameSelectActivity.class);

        startActivity(intent);
    }
//  add button to play again
    public void playAgain(View view) {
        Intent intent = new Intent(this, G2P1CHWPlayActivity.class);

        startActivity(intent);
    }

}

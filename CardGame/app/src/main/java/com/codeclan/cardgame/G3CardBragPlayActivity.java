package com.codeclan.cardgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.codeclan.cardgame.threecardbrag.card_game.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class G3CardBragPlayActivity extends AppCompatActivity {

    ThreeCardBragGame game;
    ArrayList<com.codeclan.cardgame.threecardbrag.card_game.Player> players;
    com.codeclan.cardgame.threecardbrag.card_game.Player player1;
    com.codeclan.cardgame.threecardbrag.card_game.Player dealer;
    ArrayList<ImageButton> computercards;
    ArrayList<ImageButton> youcards;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g3_card_brag);

        computercards = new ArrayList<ImageButton>();
        youcards = new ArrayList<ImageButton>();
        players = new ArrayList<>();

        computercards.add((ImageButton) findViewById(R.id.computerCard0));
        computercards.add((ImageButton) findViewById(R.id.computerCard1));
        computercards.add((ImageButton) findViewById(R.id.computerCard2));
        youcards.add( (ImageButton) findViewById(R.id.youCard0));
        youcards.add( (ImageButton) findViewById(R.id.youCard1));
        youcards.add( (ImageButton) findViewById(R.id.youCard2));

        player1 = new com.codeclan.cardgame.threecardbrag.card_game.Player(getString(R.string.player_label));
        dealer = new com.codeclan.cardgame.threecardbrag.card_game.Player(getString(R.string.player_label));
        players.add(player1);
        players.add(dealer);
        game = new ThreeCardBragGame(players);
        game.setup();
    }

// not DRY, but it works...
    private enum PlayState{
        NOCARDS,
        DEALCARDS,
        SHOWCARDS,
        NEWGAME;

        private PlayState getNext(){
            // cycle through states (nicked from SO)
            return values()[(this.ordinal() + 1) % PlayState.values().length];
        }
    }

    private String cardToDrawableName(com.codeclan.cardgame.threecardbrag.card_game.Card card){
        // slightly different card naming convention to previous
        return "card_" + card.toString().toLowerCase().replace(" ", "_");
    }


    private static PlayState playstate = PlayState.SHOWCARDS;  // initial value in class each time enter view?

    protected void nextStepInGame(View view){

        playstate = playstate.getNext();

        TextView infoPanel = (TextView) findViewById(R.id.info_panel);
        switch (playstate) {
            case NOCARDS: {
                // show empty buttons as no cards on table
                for (ImageButton imgbtn : computercards) {
                    imgbtn.setImageResource(R.color.holo_green_dark);
                }
                for (ImageButton imgbtn : youcards) {
                    imgbtn.setImageResource(R.color.holo_blue_dark);
                }
                infoPanel.setText("Click to deal cards to both players");
                break;
            }
            case DEALCARDS: {
                // show backs of cards ready to play them
                for (int i = 0; i <= 2; i++) {
                    // TODO cosmetic delay here
                    youcards.get(i).setImageResource(R.drawable.card_back);
                    // TODO cosmetic delay here
                    computercards.get(i).setImageResource(R.drawable.card_back);
                }
                infoPanel.setText("Click on a card to reveal cards");
                break;
            }
            case SHOWCARDS: {
                game.startPlay();
                for (int i = 0; i <= 2; i++) {
                    computercards.get(i).setImageResource(
                            getResources().getIdentifier(
                                    cardToDrawableName(dealer.getCards()[i]), "drawable", "com.codeclan.cardgame"));
                    youcards.get(i).setImageResource(
                            getResources().getIdentifier(
                                    cardToDrawableName(player1.getCards()[i]), "drawable", "com.codeclan.cardgame"));
                }
                game.endPlay();
                infoPanel.setText("And the winner is: \n" + game.getWinner().getName() + " with a " +
                        game.getWinType().toString() + "\n Click to play again");
                break;
            }
            case NEWGAME: {
                Intent newIntent = new Intent(this, GameSelectActivity.class);
                infoPanel.setText("\n");

                startActivity(newIntent);
            }
        }
    }

}

package com.codeclan.cardgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class G2P2CHWPlayActivity extends AppCompatActivity implements ViewerInterface {

    private Game2Player2CardHighestScoreWinsN game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g2p2chwplay);

        game = new Game2Player2CardHighestScoreWinsN(2, this);

//        Game2Player1CardHighestWinsN gameConsole = new Game2Player1CardHighestWinsN(10, new ConsoleViewer());
//            gameConsole.play(); // runs game logic in console non-interactively using ConsoleViewer class
//        un-comment below for interactive version
//
//
//
        Log.d(getClass().toString(), getString(R.string.player_label));
        Log.d(getClass().toString(), getString(R.string.computer_label));
        this.game.getPlayers()[0].setName(getString(R.string.player_label));    // player gets card first, use common name
        this.game.getPlayers()[1].setName(getString(R.string.computer_label));  // dealer gets card second, use common name
        Log.d(getClass().toString(), "about to setup");
        this.game.setup();
        Log.d(getClass().toString(), "setup, about to start game");

    }

    public String messageOut(String output){
        System.out.println(output);
        Toast.makeText(this, output, Toast.LENGTH_SHORT).show();
        return output;
    }

    public void listHand(Player player){
        messageOut("Player: " + player.getName());
        messageOut(player.getHand().toString());
    }

    public void winsRound(Player player) {
        messageOut(player.getName() + " wins Round!");
    }

    public void winsGame(Player player) {
        messageOut("Congratulations " + player.getName() + ", you have won the game!");
    }

    private enum PlayState{
        NOCARDS,
        DEALCARDS,
        SHOWCARDS;

        private PlayState getNext(){
            // cycle through states (nicked from SO)
            return values()[(this.ordinal() + 1) % PlayState.values().length];
        }
    }

    private static PlayState playstate = PlayState.SHOWCARDS;  // initial value in class each time enter view?

    public void nextStepInGame(View view){
        // called by click on either card, so need to track state
        Log.d(getClass().toString(),"playstate before = " + playstate.toString());

        playstate = playstate.getNext();
        Log.d(getClass().toString(),"playstate after update = " + playstate.toString());
        ImageButton computerCard1 = (ImageButton) findViewById(R.id.computerCard1);
        ImageButton computerCard2 = (ImageButton) findViewById(R.id.computerCard2);
        ImageButton youCard1 = (ImageButton) findViewById(R.id.youCard1);
        ImageButton youCard2 = (ImageButton) findViewById(R.id.youCard2);
        TextView infoPanel = (TextView) findViewById(R.id.info_panel);
        switch (playstate){
            case NOCARDS: {
                // show empty buttons as no cards on table
                computerCard1.setImageResource(R.color.holo_green_dark);
                computerCard2.setImageResource(R.color.holo_green_dark);
                youCard1.setImageResource(R.color.holo_blue_dark);
                youCard2.setImageResource(R.color.holo_blue_dark);
                infoPanel.setText("Click to deal cards to both players");

                break;
            }
            case DEALCARDS: {
                // show backs of cards ready to play them
                computerCard1.setImageResource(R.drawable.card_back);
                computerCard2.setImageResource(R.drawable.card_back);
                youCard1.setImageResource(R.drawable.card_back);
                youCard2.setImageResource(R.drawable.card_back);
                infoPanel.setText("Click to reveal cards");
                break;
            }
            case SHOWCARDS: {
                // playARound, but only show last 2 card faces on the faceups pile
                game.playARound();
                // TODO update card 2 to show correct card not duplicate.  Needs method to access next card in hand
                ArrayList<Card> shownCards = game.getPlayers()[1].getHand().getFaceups();
                int lastcardindex = shownCards.size() - 1 ;
                String cardToShow1 = shownCards.get(lastcardindex).toDrawableName();
                String cardToShow2 = shownCards.get(lastcardindex - 1).toDrawableName();     // safe if two cards dealt
                computerCard1.setImageResource(getResources().getIdentifier(cardToShow1, "drawable", "com.codeclan.cardgame"));
                computerCard2.setImageResource(getResources().getIdentifier(cardToShow2, "drawable", "com.codeclan.cardgame"));

                shownCards = game.getPlayers()[0].getHand().getFaceups();
                lastcardindex = shownCards.size() - 1 ;    // redundant since should be same size for both players...
                cardToShow1 = shownCards.get(lastcardindex).toDrawableName();
                cardToShow2 = shownCards.get(lastcardindex - 1).toDrawableName();     // safe if two cards dealt
                youCard1.setImageResource(getResources().getIdentifier(cardToShow1, "drawable", "com.codeclan.cardgame"));
                youCard2.setImageResource(getResources().getIdentifier(cardToShow2, "drawable", "com.codeclan.cardgame"));

                infoPanel.setText(getString(R.string.computer_label) + " has " +
                        game.getPlayers()[1].getScore().toString() + " points,\n" +
                        getString(R.string.player_label) + " has " +
                        game.getPlayers()[0].getScore().toString() + " points.\n Click for clear table") ;

                break;
            }

        }
        if( game.isOver() ){
//
//         break out of onClick loop by going to new activity to display results
//
            Intent resultsIntent = new Intent(this, G2P2CHWResultsActivity.class);
            resultsIntent.putExtra("player1score", game.getPlayers()[0].getScore());
            resultsIntent.putExtra("dealerscore", game.getPlayers()[1].getScore());
            resultsIntent.putExtra("winner", game.winner().getName());

            startActivity(resultsIntent);
        }

    }

//    TODO may want to remove this from interface and game classes

    public void waitForUserClick(Player player){
        // hook for onclick in activity
        Log.d(getClass().toString(),"wait for user click???");
        }


}

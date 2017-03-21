package com.codeclan.cardgame;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class G2P1CHWPlayActivity extends AppCompatActivity implements ViewerInterface {

    private Game2Player1CardHighestWinsN game;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_g2p1chwplay);
        game = new Game2Player1CardHighestWinsN(2, this);

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

//    private Game2Player1CardHighestWinsN game;

//    public G2P1CHWPlayActivity() {
//        // seems to be called before onCreate
//        this.game = new Game2Player1CardHighestWinsN(2, this);
//        Log.d(getClass().toString(), getString(R.string.player_label));
//    }

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
        ImageButton computerCard = (ImageButton) findViewById(R.id.computerCard);
        ImageButton youCard = (ImageButton) findViewById(R.id.youCard);
        TextView infoPanel = (TextView) findViewById(R.id.info_panel);
        switch (playstate){
            case NOCARDS: {
                // show empty buttons as no cards on table
                computerCard.setImageResource(R.color.holo_green_dark);
                computerCard.setVisibility(View.VISIBLE);
                youCard.setImageResource(R.color.holo_blue_dark);
                youCard.setVisibility(View.VISIBLE);
                infoPanel.setText("Click to deal cards to both players");

                break;
            }
            case DEALCARDS: {
                // show backs of cards ready to play them
                computerCard.setImageResource(R.drawable.card_back);
                computerCard.setVisibility(View.VISIBLE);
                youCard.setImageResource(R.drawable.card_back);
                youCard.setVisibility(View.VISIBLE);
                infoPanel.setText("Click to reveal cards");
                break;
            }
            case SHOWCARDS: {
                // playARound, but only show card faces
                game.playARound();
                String cardToShow = this.game.getTurnlog().lastEntryFor(game.getPlayers()[1]).getHand().topShownCard().toDrawableName();
                computerCard.setImageResource(getResources().getIdentifier(cardToShow, "drawable", "com.codeclan.cardgame"));
                cardToShow = this.game.getTurnlog().lastEntryFor(game.getPlayers()[0]).getHand().topShownCard().toDrawableName();
                youCard.setImageResource(getResources().getIdentifier(cardToShow, "drawable", "com.codeclan.cardgame"));

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
            Intent resultsIntent = new Intent(this, G2P1CHWResultsActivity.class);
            resultsIntent.putExtra("player1score", game.getPlayers()[0].getScore());
            resultsIntent.putExtra("dealerscore", game.getPlayers()[1].getScore());
            resultsIntent.putExtra("winner", game.winner().getName());

            startActivity(resultsIntent);
        }

    }

    public void waitForUserClick(Player player){
        // hook for onclick in activity
        Log.d(getClass().toString(),"wait for user click???");
        }


// Redundant development Code to delete
//    public void flipComputerCardThenContinue(View view){
//        this.game.playerTakesTurn(this.game.getPlayers()[1]);
//
//        String cardToShow = this.game.getTurnlog().lastEntryFor(game.getPlayers()[1]).getHand().topShownCard().toDrawableName();
//        ImageButton computerCard = (ImageButton) findViewById(R.id.computerCard);// use turnlog to determine if still in same round and can turn card yet
////        if(this.game.getTurnlog().lastEntry().getName() != this.game.getPlayers()[0].getName() ) {
//            computerCard.setImageResource(getResources().getIdentifier(cardToShow, "drawable", "com.codeclan.cardgame"));
////        }
//
//
//    public void flipYouCardThenContinue(View view){
//        this.game.playerTakesTurn(this.game.getPlayers()[0]);
//        String cardToShow = this.game.getTurnlog().lastEntryFor(game.getPlayers()[0]).getHand().topShownCard().toDrawableName();
//        ImageButton youCard = (ImageButton) findViewById(R.id.youCard);
////        if(this.game.getTurnlog().lastEntry().getName() != this.game.getPlayers()[0].getName() ) {
//            youCard.setImageResource(getResources().getIdentifier(cardToShow, "drawable", "com.codeclan.cardgame"));
////        }
//    }
}

package com.codeclan.cardgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class TestActivity extends AppCompatActivity implements ViewerInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        Game2Player1CardHighestWinsN game = new Game2Player1CardHighestWinsN(2, new ConsoleViewer());
            game.play(); // runs game logic in console non-interactively using ConsoleViewer class
//        un-comment below for interactive version
//
        Game2Player1CardHighestWinsN game2 = new Game2Player1CardHighestWinsN(2, this);
//
//
//        game.setup();
//        game.playARound();

    }

    public String messageOut(String output){
//        System.out.println(output);
        return output;
    }

    public void listHand(Player player){
        messageOut("Player: " + player.getName());
        messageOut(player.getHand().toString());
    }

    public void winsRound(Player player) {
        messageOut("Player: " + player.getName() + " wins Round!");
    }

    public void winsGame(Player player) {
        messageOut("Congratulations " + player.getName() + ", you have won the game!");
    }

    public void waitForUserClick(Player player){
        // hook for onclick in activity
        flipComputerCardThenContinue();
    }
    public void flipComputerCardThenContinue(){
        ImageButton card = (ImageButton) findViewById(R.id.computerCard);
        card.setImageResource(R.drawable.card_2_of_clubs);
    }
}

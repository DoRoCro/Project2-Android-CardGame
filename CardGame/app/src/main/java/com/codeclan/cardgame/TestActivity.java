package com.codeclan.cardgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class TestActivity extends AppCompatActivity implements ViewerInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

//        Game2Player1CardHighestWinsN gameConsole = new Game2Player1CardHighestWinsN(10, new ConsoleViewer());
//            gameConsole.play(); // runs game logic in console non-interactively using ConsoleViewer class
//        un-comment below for interactive version
//
//
//
        System.out.println("about to setup");
        this.game.setup();
        System.out.println("setup, about to start game");;

    }

    private Game2Player1CardHighestWinsN game;

    public TestActivity() {
         this.game = new Game2Player1CardHighestWinsN(2, this);
    }

    public String messageOut(String output){
        System.out.println(output);
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
        System.out.println("wait for user click???");
        }

    public void flipComputerCardThenContinue(View view){
        this.game.playARound();
//        String cardToShow = "card_10_of_diamonds";
        String cardToShow = this.game.getTurnlog().lastEntryFor(game.getPlayers()[1]).getHand().topShownCard().toDrawableName();
        ImageButton computerCard = (ImageButton) findViewById(R.id.computerCard);
        computerCard.setImageResource(getResources().getIdentifier(cardToShow, "drawable", "com.codeclan.cardgame"));

    }
    public void flipYouCardThenContinue(View view){
        String cardToShow = this.game.getTurnlog().lastEntryFor(game.getPlayers()[0]).getHand().topShownCard().toDrawableName();
        ImageButton youCard = (ImageButton) findViewById(R.id.youCard);
        youCard.setImageResource(getResources().getIdentifier(cardToShow, "drawable","com.codeclan.cardgame" ));
    }
}

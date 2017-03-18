package com.codeclan.cardgame;


import java.util.HashMap;

/**
 * Created by user on 18/03/2017.
 */

public class Game2Player1CardHighestWinsN implements GameMechanics {
    public Player[] players;
    Deck deck;
    public TurnLog turnlog;
    Player player1 = new Player("You", new Hand());
    Player dealer = new Player("Computer", new Hand());   // is the computer
    Viewer viewer;
    int rounds;

//    public Viewer viewer;


    public Game2Player1CardHighestWinsN(Integer rounds, Viewer viewer) {

        this.turnlog = new TurnLog();
        this.deck = new Deck(Card.CardNumber.values(), Card.Suit.values());
        this.players = new Player[]{player1, dealer};
        this.viewer = viewer;
        this.rounds = rounds;
    }

    @Override
    public void setup() {
        this.deck.shuffle();
    }

    @Override
    public void playARound() {
        HashMap<Player, Integer> roundScores = new HashMap<Player, Integer>();
        for (Player player : players){
            playerTakesTurn(player);
            roundScores.put(player, player.getHand().topShownCard().getCardNumber().score());
        }
        if(roundScores.get(player1) > roundScores.get(dealer)){
//            player 1 wins round
            viewer.winsRound(player1);
        }
        else if( roundScores.get(dealer) == roundScores.get(player1)){
//            draw
            viewer.messageOut("Round is a draw");
        }
        else {
//            dealer wins
            viewer.winsRound(dealer);
        }

    }

    @Override
    public void playerTakesTurn(Player player) {
        player.getHand().receiveCard( deck.dealCard() );
        player.getHand().showCardByIndex(0);
        updateLog(player);
        viewer.listHand(player);
    }

    @Override
    public void updateLog(Player player) {
        this.turnlog.addEntry(player);
    }

    @Override
    public boolean isWon() {
        return false;
    }

    @Override
    public boolean isOver() {
        return false;
    }

    @Override
    public Player winner() {
        return null;
    }

    @Override
    public void endGame() {
    }

    @Override
    public void play(){
        setup();
        for(int i=0; i< rounds; i++ ){
            playARound();
        }
        endGame();
    }
}

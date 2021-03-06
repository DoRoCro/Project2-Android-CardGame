package com.codeclan.cardgame;


import java.util.HashMap;

/**
 * Created by DRC on 18/03/2017.
 */

public class Game2Player1CardHighestWinsN implements GameMechanics {
    protected static final int NUMPLAYERS = 2;
    protected Player[] players;
    protected Deck deck;
    protected TurnLog turnlog;
    protected Player player1 = new Player("You", new Hand());
    protected Player dealer = new Player("Computer", new Hand());   // is the computer
    protected ViewerInterface viewer;
    protected int rounds;
    protected int roundsPlayed;
    protected int cardsInRound = 1;

//    public ConsoleViewer viewer;


    public Game2Player1CardHighestWinsN(Integer rounds, ViewerInterface viewer) {

        this.turnlog = new TurnLog();
        this.deck = new Deck(Card.CardNumber.values(), Card.Suit.values());
        this.players = new Player[]{player1, dealer};
        this.viewer = viewer;
        this.rounds = rounds;
        this.roundsPlayed =0;
    }

    @Override
    public void setup() {
        this.deck.shuffle();
    }

    @Override
    public void playARound() {
        HashMap<Player, Integer> roundScores = new HashMap<Player, Integer>();
        for (int i=0; i < cardsInRound; i++) {
            for (Player player : players) {
                playerTakesTurn(player);
                roundScores.put(player, player.getHand().topShownCard().getCardNumber().score());
            }
        }
        roundsPlayed ++;    // needs to incremented in playARound when called by AndroidActivity
        if(roundScores.get(player1) > roundScores.get(dealer)){
//            player 1 wins round
            viewer.winsRound(player1);
            player1.setScore( player1.getScore() + 1);
        }
        else if( roundScores.get(dealer) == roundScores.get(player1)){
//            drawn round
            viewer.messageOut("Round drawn");
        }
        else {
//            dealer wins round
            viewer.winsRound(dealer);
            dealer.setScore( dealer.getScore() + 1);
        }

    }

    @Override
    public void playerTakesTurn(Player player) {
        player.getHand().receiveCard( deck.dealCard() );
//        viewer.waitForUserClick(player);
        player.getHand().showCardByIndex(0);
        updateLog(player);
//        viewer.listHand(player);
    }

    @Override
    public void updateLog(Player player) {
        this.turnlog.addEntry(player);
    }

    @Override
    public boolean isWon() {
//        game won condition.
//        for this game, is only sensible to evaluate at end of N rounds by comparing player scores, but could abandon game midway and still declare a winner
        return player1.getScore() != dealer.getScore();
    }

    @Override
    public boolean isOver() {
//        game is over when have completed all rounds OR less cards in deck than players
        return (deck.cardCount() < NUMPLAYERS) ||
                (this.roundsPlayed >= this.rounds);
    }

    @Override
    public Player winner() {
        if(player1.getScore() > dealer.getScore()){
            // player 1 wins game
            viewer.winsGame(player1);
            return player1;
        }
        else if(player1.getScore() < dealer.getScore()){
            // dealer wins game
            viewer.winsRound(dealer);
            return dealer;
        }
        else {
            // drawn game
            viewer.messageOut("Game drawn");
            return new Player("Game drawn", new Hand());
        }
    }

    @Override
    public void endGame() {
        // tidy up if required
    }

    public Player[] getPlayers() {   // added for testing
        return players;
    }

    public TurnLog getTurnlog() {    // added for testing
        return turnlog;
    }

    @Override
    public void play(){
        setup();
        for(int roundsPlayedInPlay=0; roundsPlayedInPlay < rounds; roundsPlayedInPlay ++ ){
            playARound();
        }
        if(isWon()){
            viewer.winsGame(winner());
        }
        endGame();
    }
}

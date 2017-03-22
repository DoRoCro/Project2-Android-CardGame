package com.codeclan.cardgame.threecardbrag.card_game;

//import card_game.*;
import java.util.*;

public class Runner {

  public static void main(String[] args){
    System.out.println("Let's play Three Card Brag!");
    ArrayList<Player> players = new ArrayList<Player>();
    Player player1 = new Player("Beth");
    Player player2 = new Player("Rick");
    players.add(player1);
    players.add(player2);
    ThreeCardBragGame game = new ThreeCardBragGame(players);
    game.play();


    System.out.println(player1.getName() + ": " + player1.printHand());
    System.out.println(player2.getName() + ": " + player2.printHand());

    Player winner = game.getWinner();

    System.out.println("The winner is: " + winner.getName() + " with a " + game.getWinType());

  }

}
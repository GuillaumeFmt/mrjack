package com.mrjack;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    private final Board board;
    public static final Scanner scan = new Scanner(System.in);

    public Game(){
        board = new Board();
    }

    public void play() {
        System.out.println("- Nouveau tour -");
        System.out.println("C'est à " + (board.isHolmesStarting() ? "Holmes" : "MrJack") + " de jouer");
        if (board.isHolmesStarting()) {
            for (int i = 0; i < 4; i++) {
                board.getJetons().get(i).setHead((Math.random() < 0.5));
            }
        }
        System.out.println(board.show());
        System.out.println("Entrez un numero de jeton (0-3)");
        int indexJeton = scan.nextInt();
        board.getJetons().get(indexJeton).setHoldByHolmes(true);

        System.out.println("Entrez un numero de jeton (0-3)");
        indexJeton = scan.nextInt();
        board.getJetons().get(indexJeton).setHoldByHolmes(false);

        System.out.println("Entrez un numero de jeton (0-3)");
        indexJeton = scan.nextInt();
        board.getJetons().get(indexJeton).setHoldByHolmes(false);

        System.out.println("Entrez un numero de jeton (0-3)");
        indexJeton = scan.nextInt();
        board.getJetons().get(indexJeton).setHoldByHolmes(true);


        board.endTurn();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
















    }
}

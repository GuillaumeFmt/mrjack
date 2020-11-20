package com.mrjack;

import java.util.*;

public class Board {
    /*
         0 1 2
     11  .|.|.  3
     10  .|.|.  4
      9  .|.|.  5
         8 7 6

     */

    private ArrayList<ArrayList<District>> board = new ArrayList<>(3);
    private Card mrjackId;
    private ArrayList<Card> deck;
    private ArrayList<Integer> detectivesPositions = new ArrayList<>(3);
    private int lapNumber;
    private ArrayList<Jeton> jetons;


    public Board() {
        this.init();
    }

    private void init() {
        //jeton
        jetons = new ArrayList<>(Arrays.asList(Jeton.values()));

        //deck
        deck = new ArrayList<>(Arrays.asList(Card.values()));
        Collections.shuffle(deck);

        //board
        for(int i=0; i<3;i++) {
            ArrayList<District> row = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                int random = (int) (Math.random() * 3);
                row.add(new District(deck.get(3*i+j),random));
            }
            board.add(row);
        }
        board.get(0).get(0).setOrientation(4);
        board.get(0).get(2).setOrientation(1);
        board.get(2).get(1).setOrientation(3);

        //mrJackId
        Collections.shuffle(deck);
        mrjackId = draw();

        //detective pos
        detectivesPositions.add(11);
        detectivesPositions.add(3);
        detectivesPositions.add(7);

        lapNumber=1;
    }

    public Board(ArrayList<ArrayList<District>> board, Card mrjackId, ArrayList<Card> deck, ArrayList<Integer> detectivesPositions, int lapNumber) {
        this.board = board;
        this.mrjackId = mrjackId;
        this.deck = deck;
        this.detectivesPositions = detectivesPositions;
        this.lapNumber = lapNumber;
    }

    public Card draw() {
        return deck.remove(deck.size()-1);
    }

    public boolean isHolmesStarting() {
        return lapNumber%2 == 1;
    }

    public void endTurn() {
        lapNumber++;
    }

    public ArrayList<Jeton> getJetons() {
        return jetons;
    }

    @Override
    public String toString() {
        StringBuilder boardStr = new StringBuilder("\n");
        for(ArrayList<District> row : board) {
            for (District district: row) {
                boardStr.append(" | ").append(district.getCard()).append(district.getOrientation());
            }
            boardStr.append("|\n");
        }
        return "Board{" +
                "\nboard=" + boardStr +
                ", mrjackId=" + mrjackId +
                ", \ndeck=" + deck +
                ", \ndetectivesPositions=" + detectivesPositions +
                ", \nlapNumber=" + lapNumber +
                ", \njetons=" + jetons +
                '}';
    }

    public String show() {
        StringBuilder boardStr = new StringBuilder("\n");
        for(ArrayList<District> row : board) {
            for (District district: row) {
                boardStr.append(" | ").append(district.getCard()).append(district.getOrientation());
            }
            boardStr.append("|\n");
        }
        return "Le plateau ressemble a " +
                "board=" + boardStr +
                ", detectivesPositions=" + detectivesPositions + "\n" +
                ", lapNumber=" + lapNumber + "\n" +
                ", jetons=" + jetons;
    }
}

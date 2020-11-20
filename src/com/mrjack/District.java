package com.mrjack;

public class District {
    /*
    orientation 0 :
     ===
      |
     */

    private final Card card;
    private boolean isSuspect;
    private Integer orientation;

    public District(Card card) {
        this.card = card;
        this.orientation = 0;
    }

    public District(Card card, Integer orientation) {
        this.card = card;
        this.orientation = orientation;
    }


    public void rotate() {
        this.rotate(1);
    }

    public void rotate(int times) {
        this.orientation = (this.orientation + times) % 4;
    }

    public void setOrientation(Integer orientation) {
        this.orientation = orientation;
    }


    public Card getCard() {
        return card;
    }

    public boolean isSuspect() {
        return isSuspect;
    }

    public Integer getOrientation() {
        return orientation;
    }

    private void setInnocent(){
        this.isSuspect = false;
    }
}

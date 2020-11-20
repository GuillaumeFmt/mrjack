package com.mrjack;

public enum Jeton {
    JETON1,
    JETON2,
    JETON3,
    JETON4;

    private boolean isHead = true;
    private boolean isHoldByHolmes;

    public boolean isHead() {
        return isHead;
    }

    public void setHead(boolean head) {
        isHead = head;
    }

    public boolean isHoldByHolmes() {
        return isHoldByHolmes;
    }

    public void setHoldByHolmes(boolean holdByHolmes) {
        isHoldByHolmes = holdByHolmes;
    }

    public String getAction() {
        if (isHead) {
            switch (this.ordinal()) {
                case 0:
                    return "holmes";
                case 1:
                    return "watson";
                case 2:
                    return "exchange";
                default:
                    return "all";
            }

        } else {
            switch (this.ordinal()) {
                case 0:
                    return "draw";
                case 1:
                    return "toby";
                default:
                    return "rotate";
            }
        }

    }

}

package com.lmhscodingclub.monopoly.playerdata;

import com.lmhscodingclub.monopoly.boardlogic.BoardSpace;

public class Property {
    BoardSpace space;
    int houseCount;
    boolean isMortgaged;

    public Property(BoardSpace boardSpace) {
        space = boardSpace;
    }

    public BoardSpace getBoardSpace() {
        return space;
    }

    public int getHouseCount() {
        return houseCount;
    }

    public void setHouseCount(int houseCount) {
        this.houseCount = houseCount;
    }

    public boolean getIsMortgaged() {
        return isMortgaged;
    }

    public void getIsMortgaged(boolean value) {
        isMortgaged = value;
    }
}
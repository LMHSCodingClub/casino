package com.lmhscodingclub.monopoly.playerdata;

public class Player {
    String name;
    BoardPiece piece;
    Ownership ownership;

    // 40 is jail
    int position;

    public void move(int spaces) {
        position = (position + spaces) % 40;
    }

    public void goToJail() {
        position = 40;
    }

    public int getLocation() {
        return position;
    }

    public Player(String name, BoardPiece piece) {
        this.name = name;
        this.piece = piece;
        ownership = new Ownership();
    }

    public String getName() {
        return name;
    }

    public BoardPiece getPiece() {
        return piece;
    }

    public Ownership getOwnership() { 
        return ownership;
    }
}

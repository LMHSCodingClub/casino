package com.lmhscodingclub.casino.core;
public class Player {
    //Att ributes
    public int wallet;
    public int playerNumber;
    public int[] hand;

    //Contructor
    public Player(int playerNum, int startingCash){

        playerNumber = playerNum;
        wallet = startingCash;

    }
    //Player Methods
    public void takeBetAmount(int amount){
        wallet -= amount;
    }
    public void takePot(int potSize){
        wallet += potSize;
    }
    public void giveCards(int[] cards){
        hand = cards;
    }
}
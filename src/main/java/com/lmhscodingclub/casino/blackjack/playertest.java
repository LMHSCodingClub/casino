package com.lmhscodingclub.casino.core;
public class playertest {
    //Attributes
    public static int playerNum = 0;
    public static final int startingCash = 100;
    public int wallet;
    public int playerNumber;
    public int[] hand;
    
    //Contructor
    public Player(){

        playerNumber = playerNum;
        playerNum++;
        
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

package com.lmhscodingclub.casino.core;
import com.lmhscodingclub.casino.core.Card;
public class Player {
    //Attributes
    public static int playerNum = 0;
    public static final int startingCash = 100;
    public int wallet;
    public int playerNumber;
    public Card[] hand;
    
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
    public void takeAmount(int amount){
        wallet -= amount;
    }
    public void takePot(int potSize){
        wallet += potSize;
    }
    public void giveCards(Card[] cards){
        hand = cards;
    }
    public String getBalance(){
        String bal = "" + wallet + " Kromer";
        return bal; 
    }
    
}
package com.lmhscodingclub.casino.core;
import com.lmhscodingclub.casino.core.Card;
public class Player {
    //Attributes
    public static int playerNum = 0;
    public static final int startingCash = 100;
    public double wallet;
    public int playerNumber;
    public Card[] hand;
    
    //Contructor
    public Player(){

        playerNumber = playerNum;
        playerNum++;
        
        wallet = startingCash;

    }
    //Player Methods
    public double takeBetAmount(double amount){
        wallet -= amount;
        return amount;
    }
    public void takeAmount(double amount){
        wallet -= amount;
    }
    public void takePot(double potSize){
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
package com.lmhscodingclub.casino.poker;

import java.io.*;
import static java.lang.System.*;
import java.util.Scanner;
import java.util.*;
import java.lang.Object;
import com.lmhscodingclub.casino.core.Card;
public class Poker {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int numPlayers = scan.nextInt();
        ArrayList<Integer> deck = createDeck();//Deck is created
        //System.out.println(deck.get(3));
        deck = shuffleDeck(deck);//Deck is shuffled
        //System.out.println(deck.get(0));
        int[][] allHands = dealHands(numPlayers, deck);
        //System.out.println(allHands[0][0]);
        ArrayList<Integer> comCards = new ArrayList<Integer>(dealThree(deck));
        printArray(comCards);
    }
    static ArrayList<Integer> createDeck(){
        ArrayList<Integer> deck = new ArrayList<>();
        for(int i = 0; i < 52; i++){
            deck.add(i+1);
        }
        return deck;
    }
    static ArrayList<Integer> shuffleDeck(ArrayList<Integer> originalDeck){
        ArrayList<Integer> newDeck = new ArrayList<Integer>();
        int randomIndex = 0;
        for(int i = 0; i < 52; i++){
            randomIndex = (int)(Math.random()*(originalDeck.size()));
            newDeck.add(originalDeck.get(randomIndex));
            originalDeck.remove(randomIndex);
        }
        return newDeck;
    }
    static int[][] dealHands(int numPlayers, ArrayList<Integer> deck){
        
        int[][] allHands = new int[numPlayers][2];
        for(int c = 0; c < 2; c++){
            for(int r = 0; r < numPlayers; r++){
                allHands[r][c] = deck.get(0);
            }
        }

        return allHands;
    }
    static ArrayList<Integer> dealThree(ArrayList<Integer> deck){
        deck.remove(0);
        ArrayList<Integer> comCards = new ArrayList<Integer>();
        for(int i = 0; i < 3; i++){
            comCards.add(deck.remove(0));
        }
        return comCards;
    }
    static void printArray(ArrayList<Integer> array){
        for(int i = 0; i < array.size(); i++){
            System.out.print(array.get(i) + " ");
        }

    }
    static String testWinner5Card(int[][] playersHands){
        int numPlayers = playersHands.length;
        
        for (int i = 0; i < numPlayers; i++){//Where put numplayers constant
            for (int  n = 0; n < 10; n ++){
                if (n == 0){
                    //Royal Flush
                    
                }
                else if (n == 1){
                    //Straight Flush
                }
                else if (n == 2){
                    
                }
                
            }
        }
    }
    static int[][] fold(int[][] allHands){ //This will create the new hand 2d array after a player folds

    }

}

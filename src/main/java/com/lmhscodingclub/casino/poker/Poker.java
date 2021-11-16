package com.lmhscodingclub.casino.poker;


import java.io.*;
import static java.lang.System.*;
import java.util.Scanner;
import java.util.*;
import java.lang.Object;
import com.lmhscodingclub.casino.core.Card;
import com.lmhscodingclub.casino.core.Player;

//!**/userinterface, !**/roulette, !**/slots, !pom.xml


public class Poker {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        try {
            int numPlayers = scan.nextInt();
            int currentBet = 0;
            int starting_cash = 100;
            ArrayList<Integer> deck = createDeck();//Deck is created
            deck = shuffleDeck(deck);//Deck is shuffled
            ArrayList<int[]> allHands = dealHands(numPlayers, deck);//Two cards are dealt to each player into an ArrayList<int[]>
            ArrayList<Integer> comCards = new ArrayList<Integer>(dealThree(deck));//Three cards from the deck are put into the comCards ArrayList<Integer>
            printArray(allHands.get(0));
            
    
            scan.close();
        } catch (InputMismatchException e) {
            System.out.println("You had to have entered an int");
        }






        
    }
    static ArrayList<Integer> createDeck(){ //Makes an array of cards numbered 1-52
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





    static ArrayList<Player> constructPlayers(int numPlayers,int startingCash){
        ArrayList<Player> playerList = new ArrayList<Player>();
        for(int i = 0; i < numPlayers; i++){
            Player currentPlayer = new Player(i, startingCash);
            playerList.add(currentPlayer);
        }
        return playerList;
    }



    
    static ArrayList<int[]> dealHands(int numPlayers, ArrayList<Integer> deck){
        
        ArrayList<int[]> allHands = new ArrayList<int[]>();
        for(int i = 0; i < numPlayers; i++){
            int[] hand = new int[]{deck.get(0), deck.get(1)};
            deck.remove(0);
            deck.remove(0);
            allHands.add(hand);
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




    static void printArrayList(ArrayList<Integer> array){
        for(int i = 0; i < array.size(); i++){
            System.out.print(array.get(i) + " ");
        }
    }



    static void printArray(int[] array){
        for(int i = 0; i < array.length; i++){
            System.out.print(array[i] + " ");
        }
    }


     

    static String testWinnerHoldem(int[][] playersHands){
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

        return null; // temporary
    }




    static void fold(ArrayList<int[]> allHands, int playerNum){ //This will create the new hand 2d array after a player fold
        allHands.remove(playerNum);
    }



    

    static int betRound(ArrayList<int[]> allHands, int numPlayers, int highestBet) {
        for(int i = 0; i<allHands.size(); i++) {
            System.out.println("What would you like to bet: Type either fold, raise, check, or a number(if player 1)");
            String decision = scan.nextLine();
            if (decision.equals("fold")) {
                fold(allHands, i);
            }
            else if (decision.equals("raise")) {
                int raise = scan.nextInt();
                if (raise > highestBet)
                    highestBet = raise;
                else
                    System.out.print("Die");
            }
            else if (decision.equals("check")) {
                    
            }
            else {
                int firstBet = Integer.parseInt(decision);
                highestBet = firstBet;
            }
            

        }

    }

    
}

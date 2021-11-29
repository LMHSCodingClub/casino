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
            ArrayList<Card> deck = createDeck();//Deck is created
            deck = shuffleDeck(deck);//Deck is shuffled
            ArrayList<ArrayList<Card>> allHands = dealHands(numPlayers, deck);//Two cards are dealt to each player into an ArrayList<int[]>
            ArrayList<Card> comCards = new ArrayList<Card>(dealThree(deck));//Three cards from the deck are put into the comCards ArrayList<Integer>
            //printArray(allHands.get(0));
            
    
            scan.close();
        } catch (InputMismatchException e) {
            System.out.println("You had to have entered an int");
        }






        
    }
    static ArrayList<Card> createDeck(){ //Makes an array of cards numbered 1-52
        ArrayList<Card> deck = new ArrayList<>();
        for(int i = 0; i < 52; i++){
            Card currentCard = new Card(i);
            deck.add(currentCard);
        }
        return deck;
    }



    
    static ArrayList<Card> shuffleDeck(ArrayList<Card> originalDeck){
        ArrayList<Card> newDeck = new ArrayList<Card>();
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



    
    static ArrayList<ArrayList<Card>> dealHands(int numPlayers, ArrayList<Card> deck){
        
        ArrayList<ArrayList<Card>> allHands = new ArrayList<ArrayList<Card>>();
        for(int i = 0; i < numPlayers; i++){
            ArrayList<Card> hand = new ArrayList<Card>();
            hand.add(deck.get(0));
            hand.add(deck.get(1));
            deck.remove(0);
            deck.remove(0);
            allHands.add(hand);
        }

        return allHands;
    }



    
    static ArrayList<Card> dealThree(ArrayList<Card> deck){
        deck.remove(0);
        ArrayList<Card> comCards = new ArrayList<Card>();
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
                else if(){
                    
                }
                else{  

                }                
            }
        }

        return null; // temporary
    }

    static int isDoubles(ArrayList<Card> testingCards){
        class CardValueComparator implements Comparator<Card> {

            @Override
            public int compare(Card o1, Card o2) {
                if (o1.getValue() == o2.getValue()) return 0;
                return o1.getValue() > o2.getValue() ? 1 : -1;
            }
   
        }

        TreeSet<Card> x = new TreeSet<>(new CardValueComparator());
        int count = 0;
        for (Card c : testingCards) {
            if (x.add(c) == false) {
                // duplicate detected
                count++;
            }
        }
        return count;
    }



    static void fold(ArrayList<int[]> allHands, int playerNum){ //This will create the new hand 2d array after a player fold
        allHands.remove(playerNum);
    }

    static void raised(int num){ 
        currentBet = num;
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
                raised(raise);
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

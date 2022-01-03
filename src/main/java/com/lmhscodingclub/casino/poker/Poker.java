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


     

    static String testWinnerHoldem(ArrayList<ArrayList<Card>> playersHands){
        int numPlayers = playersHands.size();




        for (int i = 0; i < numPlayers; i++){//Where put numplayers constant
            ArrayList<Card> testingArr = playersHands.get(i);
            HashSet<Integer> modTestingSet = new HashSet<Integer>();//Fix this cuz the set only has values
            for(Card card : testingArr){
                modTestingSet.add(card.getValue());
            }

            for (int  n = 0; n < 10; n ++){ 

                if (n == 0){
                    //Royal Flush
                    
                }
                else if (n == 1){
                    //Straight Flush
                }
                else if (n == 2){
                    
                }
                else if(n == 3){
                    
                }
                else{  

                }                
            }
        }

        return null; // temporary
    }

    static int[] getWinCode(ArrayList<Card> testingList){//write this
        int[] result = new int[2];
        //int[] modifiedTesting = countDuplicates(testingList);
        //royalFlush(modifiedTesting);
        //Sort testing set
        SortByValues(testingList, testingList.size());
        printArrayListCard(testingList);
        return result;
    }

    static void printArrayListCard(ArrayList<Card> arr){
        for(int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i).getValue());
        }
    }
    static void SortByValues(ArrayList<Card> arr, int size) 
    { 

        if(size <= 1)
        {
            return;
        }
        SortByValues(arr, size - 1 );
       
        Card last = arr.get(size - 1);
        int j = size - 2;
       
        while (j >= 0 && arr.get(j).getValue() > last.getValue())
        { 
            arr.set(j + 1, arr.get(j));
            j--; 
        } 
        arr.set(j + 1, last);
    } 
    static boolean royalFlush(int[] arr){
        
        return false;
    }
    static ArrayList<int[]> countDuplicates(ArrayList<Card> testingCards){//write this to work change card class
        ArrayList<int[]> counts = new ArrayList<int[]>();
        for(int i = 0; i < testingCards.size(); i++ ){
            int[] currentCard= {testingCards.get(i).getValue(), testingCards.get(i).getSuitValue()};//First value is the value, second is the suit
            counts.add(currentCard);
        }
        return counts;
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

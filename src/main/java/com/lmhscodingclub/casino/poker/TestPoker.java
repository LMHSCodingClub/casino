package com.lmhscodingclub.casino.poker;


import java.io.*;
import static java.lang.System.*;
import java.util.Scanner;
import java.util.*;
import java.lang.Object;
import com.lmhscodingclub.casino.core.Card;
import com.lmhscodingclub.casino.core.Player;

public class TestPoker
{

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        try {
            //int numPlayers = scan.nextInt();
            int currentBet = 0;
            int starting_cash = 100;
            ArrayList<Card> deck = createDeck();//Deck is created
            deck = shuffleDeck(deck);//Deck is shuffled
            //ArrayList<ArrayList<Card>> allHands = dealHands(numPlayers, deck);//Two cards are dealt to each player into an ArrayList<int[]>
            //ArrayList<Card> comCards = new ArrayList<Card>(dealThree(deck));//Three cards from the deck are put into the comCards ArrayList<Integer>
            //printArray(allHands.get(0));
            for(int i = 51; i > 7; i--){
                deck.remove(i);
            }
            SortByValues(deck, deck.size());

            for(int i = 0; i < deck.size(); i++ ){
                //if(i % 2 == 0){
                //    deck.remove(i);
                //}
                System.out.println(deck.get(i).getValue());
                
            }
            System.out.println();
            System.out.println();
            ArrayList<Card> straight = new ArrayList<Card>();
            for(int i = 0; i < 7; i++){
                straight.add(deck.get(i));
            }
            straight = royalFlush(straight);
            System.out.println(straight.get(0));
            for(int i = 0; i < straight.size(); i++ ){
                System.out.println(straight.get(i).getValue());
            }
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
    static ArrayList<Card> royalFlush(ArrayList<Card> arrList){
        ArrayList<Card> straightList = new ArrayList<Card>();
        for(int i = 0; i < arrList.size(); i++){
            if(i >= arrList.size() - 4){
                break;
            }
            else{
                straightList.add(arrList.get(i));
                for(int j = i + 1; j < i + 4; j++){
                    if(j == i + 3)
                        break;
                    if(arrList.get(j).getValue() == arrList.get(j-1).getValue()){
                        straightList.add(arrList.get(j));
                        System.out.println("equal");
                    }
                    else if(arrList.get(j).getValue() == arrList.get(j-1).getValue() + 1){
                        straightList.add(arrList.get(j));
                        System.out.println("consec");
                    }
                    else{
                        straightList.clear();
                        System.out.println("reset");
                        break;
                    }
                }
            }
        }
        System.out.println("hi");
        return straightList;
    }


    
}
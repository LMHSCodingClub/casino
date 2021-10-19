import java.io.*;
import static java.lang.System.*;
import java.util.Scanner;
import java.util.*;
import java.lang.Object;

public class Poker {
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
    static int[][] dealHandsHoldEm(int numPlayers, ArrayList<Integer> deck){
        int[][] bothHands = new int[numPlayers][2];
        for(int i = 0; i < numPlayers; i++){
            for(int x = 0; x < 2; x++){
                allHands[i][x] = deck.remove();
            }
        }
    
        
        return allHands;
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
    public static void main(String[] args)
    {
        int numPlayers = 2;
        ArrayList<Integer> deck = createDeck();//Deck is created
        System.out.println(deck.get(3));
        deck = shuffleDeck(deck);//Deck is shuffled
        System.out.println(deck.get(3));
        //dealHands(numPlayers, deck);
    }
}

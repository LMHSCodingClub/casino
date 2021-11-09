package com.lmhscodingclub.casino.blackjack;

import java.io.*;
import static java.lang.System.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
import com.lmhscodingclub.casino.core.Card;

class blackjack{

     public static void main (String str[]) throws IOException {
          Scanner scan = new Scanner(System.in);
          int tempVal;
          
          
          ArrayList<Card> hand = new ArrayList<Card>();
          
          for(int i = 0; i < 2; i++)
          {
            hand.add(new Card((int)(1 + (Math.random()*52))));          
            //hand.add(new Card(12));
            if (hand.get(i).getValue() > 10)
            {
            //System.out.println(hand.get(i));
               hand.get(i).setValue(10);
            }
          }
          
          int total = hand.get(0).getValue() + hand.get(1).getValue();
          
          
          while (total < 22)
          {
            
             System.out.print("Your current hand is a(n) " + hand.get(0));
             for(int i = 1; i < hand.size(); i++)
             {
             System.out.print(" and a(n) " + hand.get(i));
             }
             System.out.println(" = " + total);
             
             System.out.println("Would you like another card? Inputs: Yes or No");
             
             String answer = scan.nextLine();
             
             if (answer.equals("Yes") || answer.equals("yes") )
             {
               tempVal = (int)(1 + (Math.random()*52));
               hand.add(new Card(tempVal));
               total += tempVal;
               System.out.println("You got a " + hand.get(hand.size()-1) + "!");
             }
             else
             {
               break;
             }
             
          }
          
          if(total < 22)
            System.out.println("Your total is " + total);
          else
          {
            total = -999;
            System.out.println("You busted, buster!");   
          }                   
     }

}


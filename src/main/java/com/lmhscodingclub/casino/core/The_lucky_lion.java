package com.lmhscodingclub.casino.core;

import java.io.*;
import static java.lang.System.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;
import com.lmhscodingclub.casino.core.Card;
import com.lmhscodingclub.casino.core.Player;

public class The_lucky_lion
{
   public static void main(String[] args) {
      
      Scanner scan = new Scanner(System.in);
      
      Player sucker = new Player();
      System.out.println("██╗░░░░░░░██╗███████╗██╗░░░░░░█████╗░░█████╗░███╗░░░███╗███████╗");
      System.out.println("██║░░██╗░░██║██╔════╝██║░░░░░██╔══██╗██╔══██╗████╗░████║██╔════╝");
      System.out.println("╚██╗████╗██╔╝█████╗░░██║░░░░░██║░░╚═╝██║░░██║██╔████╔██║█████╗░░");
      System.out.println("░████╔═████║░██╔══╝░░██║░░░░░██║░░██╗██║░░██║██║╚██╔╝██║██╔══╝░░");
      System.out.println("░╚██╔╝░╚██╔╝░███████╗███████╗╚█████╔╝╚█████╔╝██║░╚═╝░██║███████╗");
      System.out.println("░░╚═╝░░░╚═╝░░╚══════╝╚══════╝░╚════╝░░╚════╝░╚═╝░░░░░╚═╝╚══════╝");

      System.out.println("");
      System.out.println("");
      System.out.println("");
      while(true){
      System.out.println("Which game would you like to play?");
      System.out.println("1: BlackJack");
      System.out.println("2: Poker");
      System.out.println("3: Roullete");
      System.out.println("4: Sluts");

      int saw = scan.nextInt();

      switch(saw)
      {
         case 1: 
            //Blackjack(sucker); 
         break;

         case 2: 
            //Blackjack(sucker); 
         break;

         case 3: 
            //Blackjack(sucker); 
         break;

         case 4: 
            //Blackjack(sucker); 
         break;

         default: 
            System.out.println("Bad input!"); 
         break;
      }
      
      
   }

   }
}


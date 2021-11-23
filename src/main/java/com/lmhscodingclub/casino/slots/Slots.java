package com.lmhscodingclub.casino.slots;

import java.util.Hashtable;
import java.util.Scanner;


public class Slots {
   // takes user input for bet
   //
   Slots() {
       // asks user for input for bet amount
       //
         Scanner input = new Scanner (System.in);
         System.out.println("How much would you like to bet? (from $1 to $3)");
         float bet = input.nextFloat();
         // if valid bet is not entered, continue to ask for input
         //
         while(bet < 1 || bet > 3) {
            System.out.println("Please enter a valid input (from $1 to $3)");
            bet = input.nextFloat();
         }
         input.close();
         
    }

    // spins three slot randomizers
    //
    float play() {
       Hashtable<SlotsResult, Integer> payouts = new Hashtable<>();
       payouts.put(new SlotsResult(10, 10, 10), 1000);

         int slot1 = (int)(Math.random()*(10)+1);
         int slot2 = (int)(Math.random()*(10)+1);
         int slot3 = (int)(Math.random()*(10)+1);
         System.out.println(slot1);
         System.out.println(slot2);
         System.out.println(slot3);

         SlotsResult result = new SlotsResult(slot1, slot2, slot3);
         if (payouts.containsKey(result)) {
            System.out.println("You win!");
         } else {
            System.out.println("You lose!");
         }
         // If all slots match, then win; if slot1 and slot2 match, then half the money
         //
         /*
         if(slot1 == slot2){
            if(slot1 == slot3 || slot2 == slot3){
               System.out.println("You won!");
            }else{ 
               System.out.println("You won half the money");
            }
         }else{
            System.out.println("You lost");
         }*/

         return 0; // temporary
    }

    public static void main(String[] args) {
        Slots slotGame = new Slots();
        slotGame.play();
    }
}

class SlotsResult {
   int x, y, z;
   public SlotsResult(int x, int y, int z) {
      this.x = x;
      this.y = y;
      this.z = z;
   }

   @Override
   public boolean equals(Object o) {
      if (o instanceof SlotsResult) {
         SlotsResult other = (SlotsResult)o;
         return x == other.x && y == other.y && z == other.z;
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return x ^ y ^ z;
   }

}
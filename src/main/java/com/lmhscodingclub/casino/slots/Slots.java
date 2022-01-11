package com.lmhscodingclub.casino.slots;

import java.util.Hashtable;
import java.util.Scanner;


public class Slots {
   float bet;
   // takes user input for bet
   //
   Slots() {
       // asks user for input for bet amount
       //
         Scanner input = new Scanner (System.in);
         System.out.println("How much would you like to bet? (from $1 to $3)");
         bet = input.nextFloat();
         // if valid bet is not entered, continue to ask for input
         //
         while(bet < 1 || bet > 3) {
            System.out.println("Please enter a valid input (from $1 to $3)");
            bet = input.nextFloat();
         }
         System.out.println("");
         input.close();
         
    }

    // spins three slot randomizers
    //
    float play() {
       Hashtable<SlotsResult, Integer> payouts = new Hashtable<>();
       
       for(int i = 10; i > 0; i--){
         payouts.put(new SlotsResult(i, i, i), i*100);
       }
       payouts.put(new SlotsResult(1, 2, 3), 2);
       payouts.put(new SlotsResult(4, 5, 6), 5);
       payouts.put(new SlotsResult(8, 9, 10), 50);
       payouts.put(new SlotsResult(10, 9, 10), 90);
       payouts.put(new SlotsResult(9, 8, 9), 90);
       payouts.put(new SlotsResult(1, 2, 1), 50);
       payouts.put(new SlotsResult(3, 5, 8), 60);
       payouts.put(new SlotsResult(5, 6, 7), 40);
       payouts.put(new SlotsResult(1, 2, 3), 35);
       payouts.put(new SlotsResult(7, 5, 8), 37);


          int slot1 = (int)(Math.random()*(10)+1);
          int slot2 = (int)(Math.random()*(10)+1);
          int slot3 = (int)(Math.random()*(10)+1);

         System.out.print(slot1 + " ");
         System.out.print(slot2 + " ");
         System.out.print(slot3 + "\n");
         

         SlotsResult result = new SlotsResult(slot1, slot2, slot3);
         if (payouts.containsKey(result)) {
            float output = payouts.get(result);
            System.out.println("You win $" + bet*output);

         } else {
            System.out.println("You lose");
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
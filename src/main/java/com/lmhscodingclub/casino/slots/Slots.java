package com.lmhscodingclub.casino.slots;

import java.util.Hashtable;

public class Slots {
    Slots() {

    }

    void play() {
       Hashtable<Integer, Integer> payouts = new Hashtable<>();
       payouts.put(10, 1000);
       payouts.put()

         int slot1 = (int)(Math.random()*(10)+1);
         int slot2 = (int)(Math.random()*(10)+1);
         int slot3 = (int)(Math.random()*(10)+1);
         System.out.println(slot1);
         System.out.println(slot2);
         System.out.println(slot3);
         if(slot1 == slot2){
            if(slot1 == slot3 || slot2 == slot3){
               System.out.println("You won!");
            }else{ 
               System.out.println("You won half the money");
            }
         }else{
            System.out.println("You lost");
         }
    }

    public static void main(String[] args) {
        Slots slotGame = new Slots();
        slotGame.play();
    }
}


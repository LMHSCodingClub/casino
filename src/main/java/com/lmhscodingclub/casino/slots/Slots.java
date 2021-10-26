package com.lmhscodingclub.casino.slots;

public class Slots {
    Slots() {

    }

    void play() {
        int slot1 = (int)(Math.random()*(20)+1);
         int slot2 = (int)(Math.random()*(20)+1);
         int slot3 = (int)(Math.random()*(20)+1);
         System.out.println(slot1);
         System.out.println(slot2);
         System.out.println(slot3);
         if(slot1 == slot2){
            if(slot1 == slot3){
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


package com.lmhscodingclub.casino.roulette;

import java.io.*;
import static java.lang.System.*;
import java.util.Scanner;
import java.util.*;
import java.lang.Object;

// https://www.888casino.com/blog/roulette-strategy-guide/how-to-play-roulette

// Creates an array for numbers 00,0 and 1-36
public class Roulette {
    public static ArrayList<Integer> board_wheel() {
        ArrayList<Integer> wheel = new ArrayList<>();
        wheel.add(00,0);
        for (int i = 0; i < 36; i++) {
            wheel.add(i+1);
        }
        return wheel;
    }

    // 2, 35, 4, 33, 6, 31, 8, 29, 10, 13, 24, 15, 22, 17, 20, 11, 26, 28
    // 2, 4, 6, 8, 10
    // 11, 13, 15, 17
    // 20, 22, 24, 26, 28, 
    // 29, 31, 33, 35

    // Creates an array for all of the black colored numbers
    public static int[] color_black() {
        int[] black = {2, 35, 4, 33, 6, 31, 8, 29, 10, 13, 24, 15, 22, 17, 20, 11, 26, 28};
        return black;
    }

    // 1, 36, 3, 34, 5, 32, 7, 30, 9, 14, 23, 16, 21, 18, 19, 12, 25, 27
    // 1, 3, 5, 7, 9
    // 12, 14, 16, 18
    // 19, 21, 23, 25, 27
    // 30, 32, 34, 36

    // Creates an array for all of the red colored numbers
    public static int[] color_red() {
        int[] red = {1, 36, 3, 34, 5, 32, 7, 30, 9, 14, 23, 16, 21, 18, 19, 12, 25, 27};
        return red;
    }

    // Picks a random number from the wheel
    public static int rou_ball(ArrayList<Integer> wheel) {
        Random rand = new Random();
        int ball;
        ball = rand.nextInt(wheel.size());
        return ball;
    }

    public static void rolling() throws Exception {
        ArrayList<Integer> wheel = board_wheel();
        int[] black = color_black();
        int[] red = color_red();
        int ball = rou_ball(wheel);
        int roll_ball = 0;
        int count = 1;
        int hold;
        int counter = 0;
        int time = 50;

        hold = (int)(Math.random()*(3)+1);

        if (hold == 1) {
            counter = 10;
        }
        else if (hold == 2) {
            counter = 12;
        }
        else if (hold == 3) {
            counter = 14;
        }

        System.out.println("Rolling: ");
        System.out.print(String.format("\033[%dA",count));

        for (int i = 0; i < counter; i++) {
            ball = rou_ball(wheel);
            System.out.print("\t .");
            Thread.sleep(time);
            System.out.print("\b ");
            System.out.print(" .");
            Thread.sleep(time);
            System.out.print("\b ");
            System.out.print(" .");
            Thread.sleep(time);
            System.out.print("\b ");
            System.out.println("\n" + ball);

            roll_ball = ball;
            Thread.sleep(500); // waits for 1 second
            time *= 1.5;
            System.out.print(String.format("\033[%dA",count)); // moves the line up 1
            System.out.print("\033[2K"); // clears the line
            System.out.print(String.format("\033[%dA",count)); // moves the line up 1
        }
        Thread.sleep(1000);
        System.out.print("\033[2K");
        System.out.println("\n" + roll_ball);
    }
    
    public static int inside_bets() {
        // Placed on only numbers

        /*
        The Straight Up
            - bet one or more numbers
            - 35 to 1 
            - house edge: 5.26%
        
        Split Bet
            - more than one number
            - placed on the line between two numbers
            - 17 to 1
            - house edge: 5.26%
        
        Street Bet / Three Number Bet / Side Bet / Trio
            - three numbers with one chip
            - place chip on the outside border of three numbers
            - 11 to 1
            - house edge: 5.26%
        
        The Corner / The Square / The Four Number Bet
            - chip on four numbers
            - numbers must make a square
            - 8 to 1
            - house edge: 5.26%
        
        The Five Number Bet / The Monster / The Beast
            - 5 numbers: 00, 0, 1, 2, and 3
            - 6 to 1
            - house edge: 7.89%
            if chips are placed on those numbers separetly (it becomes the straight up)
        
        The Line Bet / Six Number Bet / Sixline Bet
            - outside border of six numbers
            - 5 to 1
            - house edge: 5.26%
        */
    }

    public static int outside_bets() {
        // Placed on propositions: high-low, odd-even, red-black, first, second, third dozen, etc.
    }

    public static void main(String[] args) throws Exception {
        rolling();
        /*
        ArrayList<Integer> wheel = board_wheel();
        int[] black = color_black();
        int[] red = color_red();
        int count = 1;
        int ball = rou_ball(wheel);
        int roll_ball = 0;
        System.out.println("Rolling: ");
        System.out.print(String.format("\033[%dA",count));
        for (int i = 0; i < 10; i++) {
            ball = rou_ball(wheel);
            System.out.print("\t .");
            Thread.sleep(500);
            System.out.print(" .");
            Thread.sleep(500);
            System.out.print(" .");
            Thread.sleep(500);
            System.out.println("\n" + ball);
            roll_ball = ball;
            Thread.sleep(1000); // waits for 1 second
            System.out.print(String.format("\033[%dA",count)); // moves the line up 1
            System.out.print("\033[2K"); // clears the line
            System.out.print(String.format("\033[%dA",count)); // moves the line up 1
            System.out.print("\b\b");
            //System.out.print(String.format("\033[2J")); // clears the screen
        }
        Thread.sleep(1000);
        System.out.print("\033[2K");
        System.out.println("\n" + roll_ball);
        */
    }

}
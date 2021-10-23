package com.lmhscodingclub.casino.roulette;

import java.io.*;
import static java.lang.System.*;
import java.util.Scanner;
import java.util.*;
import java.lang.Object;

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
    public static ArrayList<Integer> color_black() {
        ArrayList<Integer> black = new ArrayList<>();
        black.add(2, 35, 4, 33, 6, 31, 8, 29, 10, 13, 24, 15, 22, 17, 20, 11, 26, 28);
        return black;
    }

    // 1, 36, 3, 34, 5, 32, 7, 30, 9, 14, 23, 16, 21, 18, 19, 12, 25, 27
    // 1, 3, 5, 7, 9
    // 12, 14, 16, 18
    // 19, 21, 23, 25, 27
    // 30, 32, 34, 36

    // Creates an array for all of the red colored numbers
    public static ArrayList<Integer> color_red() {
        ArrayList<Integer> red = new ArrayList<>();
        red.add(1, 36, 3, 34, 5, 32, 7, 30, 9, 14, 23, 16, 21, 18, 19, 12, 25, 27);
        return red;
    }

    // Picks a random number from the wheel
    public static int rou_ball(ArrayList<Integer> wheel) {
        Random rand = new Random();
        int ball;
        ball = wheel.get(rand.nextInt(wheel.size()));
        return ball;
    }

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> wheel = board_wheel();
        int count = 1;
        for (int i = 0; i < 10; i++) {
            System.out.println(rou_ball(wheel));
            Thread.sleep(1000); // waits for 1 second
            System.out.print(String.format("\033[%dA",count)); // moves the line up 1
            System.out.print("\033[2K"); // clears the line
            //System.out.print(String.format("\033[2J")); // clears the screen
        }
    }

}
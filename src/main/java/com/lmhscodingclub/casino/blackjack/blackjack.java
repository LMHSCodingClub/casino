package com.lmhscodingclub.casino.blackjack;

import java.io.*;
import static java.lang.System.*;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.text.DefaultStyledDocument.ElementSpec;

import java.lang.Math;
import com.lmhscodingclub.casino.core.Card;
import com.lmhscodingclub.casino.core.Player;

public class Blackjack {


    private static Random random = new Random();
    public static void main(Player baka) throws IOException {
        Scanner scan = new Scanner(System.in);
        int tempVal = 0;
        double betMax = 1000;
        double pot = 0;
        boolean play = true;
        boolean ddown = true;

        while (1 > 0 && play) // will be about player balance later
        {
            ArrayList<Card> hand = new ArrayList<Card>();
            ArrayList<Card> dealer = new ArrayList<Card>();

            int total = 0;
            int dealer_total = 0;

            boolean bet = false;
            while (!bet) {
                System.out.println("How much Kromer do you want to bet?");
                double betNum = scan.nextDouble();
                scan.nextLine();

                if (betNum > baka.wallet) {
                    System.out.println("Sorry, I can't give credit. Bet that when you're a little mmm richer!");
                } else if (betNum > betMax) {
                    System.out.println("Those stakes are too high! Lower them below " + betMax + " Kromer!");
                } else // Valid bet
                {
                    pot = baka.takeBetAmount(betNum);
                    bet = !bet;
                }
            }

            // Check out the Card class bounds

            for (int i = 0; i < 2; i++) {
                hand.add(new Card(random.nextInt(52) + 1));
                // hand.add(new Card(13));
                dealer.add(new Card(random.nextInt(52) + 1));
                // dealer.add(new Card(13));

                if (hand.get(i).getValue() > 10) {
                    // System.out.println(hand.get(i));
                    hand.get(i).setValue(10);
                } else if (hand.get(i).getValue() == 1) {
                    hand.get(i).setValue(11);
                }

                if (dealer.get(i).getValue() > 10) {
                    // System.out.println(hand.get(i));
                    dealer.get(i).setValue(10);
                } else if (dealer.get(i).getValue() == 1) {
                    dealer.get(i).setValue(11);
                }

                total += hand.get(i).getValue();

                dealer_total += dealer.get(i).getValue();

            }

            if (total > 21) {
                hand.get(0).setValue(1);
                total -= 10;
            }
            if (dealer_total > 21) {
                dealer.get(0).setValue(1);
                dealer_total -= 10;
            }

            System.out.println("The Dealer has a " + dealer.get(0) + " showing.");

            while (total < 21) {

                System.out.print("Your current hand is a(n) " + hand.get(0));
                for (int i = 1; i < hand.size(); i++) {
                    System.out.print(" and a(n) " + hand.get(i));
                }
                System.out.println(" = " + total);

                if (ddown) {
                    System.out.println("Would you like to double down? Inputs: Yes or No");
                    String downer = scan.nextLine();
                    if (downer.equals("Yes") || downer.equals("yes") || downer.equals("y")) {
                        pot += baka.takeBetAmount(pot);

                        tempVal = random.nextInt(52) + 1;
                        hand.add(new Card(tempVal));
                        if (hand.get(hand.size() - 1).getValue() > 10) {
                            hand.get(hand.size() - 1).setValue(10);
                        }

                        System.out.println("You got a " + hand.get(hand.size() - 1) + "!");
                        total += hand.get(hand.size() - 1).getValue();

                        if (total + 10 < 22 && hand.get(hand.size() - 1).getValue() == 1) {
                            total += 10;
                            hand.get(hand.size() - 1).setValue(11);
                        }

                        break;
                    }
                }

                ddown = false;
                System.out.println("Would you like another card? Inputs: Yes or No");

                String answer = scan.nextLine();

                if (answer.equals("Yes") || answer.equals("yes") || answer.equals("y")) {
                    tempVal = random.nextInt(52) + 1;
                    hand.add(new Card(tempVal));
                    if (hand.get(hand.size() - 1).getValue() > 10) {
                        hand.get(hand.size() - 1).setValue(10);
                    }

                    System.out.println("You got a " + hand.get(hand.size() - 1) + "!");
                    total += hand.get(hand.size() - 1).getValue();

                    if (total + 10 < 22 && hand.get(hand.size() - 1).getValue() == 1) {
                        total += 10;
                        hand.get(hand.size() - 1).setValue(11);
                    }

                    if (total > 22) {
                        for (int i = 0; i < hand.size(); i++) {
                            if (hand.get(i).getValue() == 11) {
                                hand.get(i).setValue(1);
                                total -= 10;
                                break;
                            }
                        }
                    }

                } else {
                    break;
                }

            }

            if (total < 22) {
                System.out.println("Your total is " + total);
            } else {
                total = -1;
                System.out.println("You busted, buster!");
                // Bet money taken not returned.
            }

            if (total != -1) {

                boolean hit = true;

                while (dealer_total < 21) {
                    System.out.print("Dealer's hand is a(n) " + dealer.get(0));
                    for (int i = 1; i < dealer.size(); i++) {
                        System.out.print(" and a(n) " + dealer.get(i));
                    }
                    System.out.println(" = " + dealer_total);

                    if (dealer_total < 17) {
                        hit = true;
                    } else {
                        hit = false;
                    }

                    if (hit) {
                        tempVal = random.nextInt(52) + 1;
                        dealer.add(new Card(tempVal));
                        if (dealer.get(dealer.size() - 1).getValue() > 10) {
                            dealer.get(dealer.size() - 1).setValue(10);
                        }
                        dealer_total += dealer.get(dealer.size() - 1).getValue();
                        System.out.println("The Dealer hit, and got a " + dealer.get(dealer.size() - 1) + "!");
                        if (dealer_total + 10 < 22 && dealer.get(dealer.size() - 1).getValue() == 1) {
                            dealer_total += 10;
                            dealer.get(dealer.size() - 1).setValue(11);
                        }

                        if (dealer_total > 21) {
                            for (int i = 0; i < dealer.size(); i++) {
                                if (dealer.get(i).getValue() == 11) {
                                    dealer.get(i).setValue(1);
                                    dealer_total -= 10;
                                    continue;
                                }
                            }
                        }

                    } else {
                        System.out.println("The Dealer stood at " + dealer_total + ".");
                        break;
                    }
                }

                if (dealer_total > 21) {
                    System.out.println("The house busts. You win!");
                    dealer_total = 0;
                    baka.takePot(pot * 2);
                } else if (total > dealer_total) {
                    System.out.println("You win!");
                    baka.takePot(pot * 2);
                } else if (total < dealer_total) {
                    System.out.println("You lose.");
                    // Money not returned
                } else {
                    // Tie case. This is... tough
                    if (total != 21) {
                        System.out.println("Push. No winner or loser.");
                        baka.takePot(pot);
                    } else if (dealer.size() == 2 && hand.size() != 2) {
                        System.out.println("You lose, dealer has Blackjack.");
                        // Money not returned
                    } else if (hand.size() == 2 && dealer.size() != 2) {
                        System.out.println("Blackjack! You win.");
                        baka.takePot(pot * 2);
                    } else // (hand.size() == 2 && dealer.size() == 2)
                    {
                        System.out.println("Push. No winner or loser.");
                        baka.takePot(pot);
                    }

                }

            } else {
                System.out.println("Better luck next time!");
            }

            System.out.println("Wanna play again?");

            String answer = scan.nextLine();

            if (answer.equals("Yes") || answer.equals("yes") || answer.equals("y")) {
                // play stays true
            } else {
                play = false;
            }

        } // end of gameplay loop
    }

}

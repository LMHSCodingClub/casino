package com.lmhscodingclub.monopoly.boardlogic;

import com.lmhscodingclub.monopoly.playerdata.Player;
import com.lmhscodingclub.monopoly.playerdata.Property;

public class BoardSpace { // Maybe this should be abstract
    public static int FreeParking = 500;
    private String type;
    /*
     * List of all types: Property Railroad Tax Free Parking Bonus(Community Chest
     * and Chance) Visiting Jail Jail Go To Jail Go Utilities
     */
    private int price;
    private String name;
    private String color; // Maybe give all non-property squares some stupid inaccessible color
    /*
     * List of all colors: Red Yellow Green Dark Blue Brown Light Blue Pink Orange
     * Misc. (Not for sale)
     */
    private Player owner;
    private int rent;

    public BoardSpace() {
        type = null;
        name = null;
        color = null;
    }

    public BoardSpace(String InputType, String InputName, String InputColor) {
        type = InputType;
        name = InputName;
        color = InputColor;
    }

    public BoardSpace(int cost, String InputName, String InputColor) {
        type = "property";
        name = InputName;
        color = InputColor;
        price = cost;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String type() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int set) {
        rent = set;
    }

    // Write the action class (DoAction)/begin setting the board elements.
    public void DoAction(Player player) {
        switch (type) {

            case "Property":
                if (owner == null && player.getOwnership().getBalance() > price) // getBalance may not be the final name
                {
                    // offer to buy
                } else if (owner == player) {
                    // do nothing
                } else if (owner != player) {
                    // charge them whatever is worth
                }
                break;

            case "Railroad":

                if (owner == null) {
                    // offer to buy
                } else if (owner == player) {

                    // do nothing
                } else // Owner is not the player on the property
                {
                    // Charge the player the amount stated
                    // Add the amount charged to FreeParking
                }
                break;

            case "Tax":

                if (name == "Luxury Tax") {
                    // charge the player $75
                } else // income tax
                {
                    // charge the player $200
                }

                break;

            case "Free Parking":
                // Give the player all the cash and set the thingy to $500

                break;

            case "Bonus":
                int suprise = (int) (Math.random() * (5) + 0); // Random number from 0-4
                if (name == "Chance") {
                    switch (suprise) {
                        case 0:
                            // send to random square. Suffer.
                            break;

                        case 1:
                            // send to jail (gulag)
                            break;

                        case 2:
                            // swap places with another player (randomly)
                            break;

                        case 3:
                            // swap money with another player (randomly)
                            break;

                        case 4:
                            // You pay rent instead of revieving it next time
                            break;

                    }
                } else 
                // name == Community Chest
                {
                    switch (suprise) {

                        case 0:
                            // Give $100
                            break;

                        case 1:
                            // Make payer oay $50 to others
                            break;

                        case 2:
                            // get out of jail FREE
                            break;

                        case 3:
                            // Send to Go
                            break;

                        case 4:
                            // Send to reading railroad
                            break;
                    }
                }

                break;

            case "Visiting Jail":
                // Do Nothing
                break;

            case "Jail":
                // jail counter for each player?
                // We can increemnt it by one, and when it hits 3 we set it
                // to 0 and move them to Visiting Jail
                // Or they can pay 50 to do that prematurely
                break;

            case "Go To Jail":
                player.goToJail();
                break;

            case "Go":
                // +200 dollars.
                break;

            case "Utilities":
                int cost = 0;
                int multiplier = 0;
                if (player.getOwnership().getProperties().stream()/* .filter(p -> p.isTrue()) */.count() == 0) {
                    // Begin the buying thing;
                } else {
                    if (player.toString() == "1")
                        multiplier = 4;
                    else
                        multiplier = 10;

                    /*
                     * if (Board.initial_location > 11) cost = multiplier * (27 -
                     * Board.initial_location); else cost = multiplier * (11 -
                     * Board.initial_location);
                     */
                }
                break;

        }
    }

}

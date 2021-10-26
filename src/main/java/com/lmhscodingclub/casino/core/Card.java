package com.lmhscodingclub.casino.core;

public class Card {

private int value;
private String rank;
private String suit;


public Card()
{
 value= 0;
 rank = "error";
 suit = "error";
}

public Card(int input) //inputs from 1-51
{
 value= (input%13)+1; 
 switch(value)
 {
    case 1:
     rank = "Ace";
    break;

    case 2:
     rank = "Two";
    break;

    case 3:
     rank = "Three";
    break;

    case 4:
     rank = "Four";
    break;

    case 5:
     rank = "Five";
    break;

    case 6:
     rank = "Six";
    break;

    case 7:
     rank = "Seven";
    break;

    case 8:
     rank = "Eight";
    break;

    case 9:
     rank = "Nine";
    break;

    case 10:
     rank = "Ten";
    break;

    case 11:
     rank = "Jack";
    break;

    case 12:
     rank = "Queen";
    break;

    case 13:
     rank = "King";
    break;

 }
 
 if(input < 13)
 {
  suit = "Hearts";
 }
 else if (input < 26)
 {
  suit = "Spades";
 }
 else if (input < 39)
 {
  suit = "Clubs";
 }
 else if (input < 52)
 {
  suit = "Diamonds";
 }

}

public int getValue()
{
    return value;
}

public String getSuit()
{
    return suit;
}

public String getRank()
{
    return rank;
}


}

package com.lmhscodingclub.monopoly.playerdata;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.lmhscodingclub.monopoly.boardlogic.BoardSpace;

public class Ownership {
    double balance;
    Map<BoardSpace, Property> properties;

    public static void executeTrade(Ownership source, ITradeItem[] tradesFromSource, Ownership destination, ITradeItem[] tradesFromDestination) {
        for (ITradeItem trade : tradesFromSource) {
            trade.removeFromOwnership(source);
            trade.addToOwnership(destination);
        }

        for (ITradeItem trade : tradesFromDestination) {
            trade.removeFromOwnership(destination);
            trade.addToOwnership(source);
        }
    }

    public Ownership() {
        properties = new HashMap<>();
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double bal) {
        balance = bal;
    }

    public void addBalance(double d) {
        setBalance(getBalance()  + d);
    }

    public Property getOrAddProperty(BoardSpace boardSpace) {
        return properties.containsKey(boardSpace) 
            ? properties.get(boardSpace) 
            : properties.put(boardSpace, new Property(boardSpace));    
    }

    public void addProperty(Property p) {
        properties.put(p.getBoardSpace(), p);
    }

    public Property removeBoardSpace(BoardSpace boardSpace) {
        return properties.remove(boardSpace);
    }

    public Collection<Property> getProperties() {
        return properties.values();
    }
}
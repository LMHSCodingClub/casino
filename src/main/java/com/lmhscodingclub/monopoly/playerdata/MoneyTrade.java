package com.lmhscodingclub.monopoly.playerdata;

public class MoneyTrade implements ITradeItem {
    double amount;

    public MoneyTrade(double amount) {
        this.amount = amount;
    }

    public void removeFromOwnership(Ownership o) {
        o.setBalance(o.getBalance() - amount);
    }

    public void addToOwnership(Ownership o) {
        o.setBalance(o.getBalance() + amount);
    }
}

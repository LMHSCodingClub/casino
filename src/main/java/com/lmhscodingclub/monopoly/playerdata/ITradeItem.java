package com.lmhscodingclub.monopoly.playerdata;

public interface ITradeItem {
    void removeFromOwnership(Ownership o);
    void addToOwnership(Ownership o);
}
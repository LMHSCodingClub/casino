package com.lmhscodingclub.monopoly.playerdata;

public class PropertyTrade implements ITradeItem {
    Property property;

    public PropertyTrade(Property property) {
        this.property = property;
    }

    public void removeFromOwnership(Ownership o) {
        o.removeBoardSpace(property.getBoardSpace());
    }

    public void addToOwnership(Ownership o) {
        o.addProperty(property);
    }
}

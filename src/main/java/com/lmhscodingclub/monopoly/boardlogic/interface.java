interface  playable
{
    public Player<> getPlayerArrayList(); // Should just be in the player class
    public void     incrementTurn();      // Should maybe be in Board class
    public int[]    rollDice();
    public Board    createBoard();        // Should maybe be in Board class
    public void     doAction();           // Should maybe be in Board class
    public void     movePlayer();         // Should just be in the player class
}
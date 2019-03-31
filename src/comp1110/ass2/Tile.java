package comp1110.ass2;

public class Tile {
    private Dice dice = null;

    private char gate;

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public void clearTile(){
        dice = null;
    }

    public Tile(char a){
        gate = a;
    }

    public void setGate(char a){
        gate = a;
    }

    public char getGate(){
        return gate;
    }



}

package comp1110.ass2;
// this class is to design three different kinds of dice, for convenience, we applied enum.
public class Dice {
    public char northPassage;
    public char eastPassage;
    public char southPassage;
    public char westPassage;
    public int faceNumber;

    public void setPassge(char northPassage,char eastPassag,char southPassage,char westPassage){
        this.northPassage = northPassage;
        this.eastPassage = eastPassag;
        this.southPassage = southPassage;
        this.westPassage = westPassage;
    }

    public char getNorthPassage() {
        return northPassage;
    }

    public char getEastPassage() {
        return eastPassage;
    }

    public char getSouthPassage() {
        return southPassage;
    }

    public char getWestPassage() {
        return westPassage;
    }

    public void rotete90Degree(){
        char transition = eastPassage;
        eastPassage = northPassage;
        northPassage = westPassage;
        westPassage = southPassage;
        southPassage = transition;
    }

    public void flip(){
        char transition = eastPassage;
        eastPassage = westPassage;
        westPassage = transition;
    }
}

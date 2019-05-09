package comp1110.ass2;
// this class is to design three different kinds of dice.
public class Dice {
    public static final double MAX_DICE_WIDTH = 3;
    public static final char INVALID_SPACE = '!';

    public char northPassage;
    public char eastPassage;
    public char southPassage;
    public char westPassage;
    public int faceNumber;
    public String identityInfo;

    public void setPassge(char northPassage,char eastPassage,char southPassage,char westPassage){
        this.northPassage = northPassage;
        this.eastPassage = eastPassage;
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

    public void setIdentityInfo(String identityInfo){
        this.identityInfo = identityInfo;
    }
}

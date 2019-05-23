package comp1110.ass2;
// this class is to design three different kinds of dice.
//  @author Shuhao Geng
public class Dice {
    public static final double MAX_DICE_WIDTH = 3;
    public static final char INVALID_SPACE = '!';

    public char northPassage;
    public char eastPassage;
    public char southPassage;
    public char westPassage;
    public int faceNumber;
    public String identityInfo = "";

    public char backupNorthPassage;
    public char backupEastPassage;
    public char backupSouthPassage;
    public char backupWestPassage;

    public void setPassge(char northPassage,char eastPassage,char southPassage,char westPassage){
        this.northPassage = northPassage;
        backupNorthPassage = northPassage;

        this.eastPassage = eastPassage;
        backupEastPassage = eastPassage;

        this.southPassage = southPassage;
        backupSouthPassage = southPassage;

        this.westPassage = westPassage;
        backupWestPassage = westPassage;
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

    public void rotate90Degree(){
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

    public void returnToStart(){
        northPassage = backupNorthPassage;
        eastPassage = backupEastPassage;
        southPassage = backupSouthPassage;
        westPassage = backupWestPassage;
    }

    public void setIdentityInfo(String identityInfo){
        this.identityInfo = identityInfo;
    }
}

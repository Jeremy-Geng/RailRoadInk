package comp1110.ass2;

import java.util.ArrayList;

public class Tile {
    private Dice dice = null;

    private char gate;

    private Traveller traveller = null;

    public String mark = null;

    public Traveller rowTraveller = null;

    public Traveller columnTraveller = null;



    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public void clearDice(){
        dice = null;
    }

    public Dice getDice() { return dice; }

    public Tile(char a){
        gate = a;
    }

    public void setGate(char a){
        gate = a;
    }

    public char getGate(){
        return gate;
    }

    public void travellerPasses(Traveller traveller){
        this.traveller = traveller;
    }

    public void rowTravellerPasses(Traveller traveller){
        rowTraveller = traveller;
    }

    public void columnTravellerPasses(Traveller traveller){
        columnTraveller = traveller;
    }

    public boolean ifPassed(){
        boolean test = false;
        if(this.ifFilled()) {
            if(this.traveller != null){
                test = true;
            }
        }
        return test;
    }

    public boolean ifFilled(){
        boolean test = false;
        if(dice != null){
            test = true;
        }
        return  test;
    }

    public boolean ifOverpass(){
        boolean test = false;
        if(dice.identityInfo.charAt(0) == 'B' && dice.identityInfo.charAt(1) == '2'){
            test = true;
        }
        return test;
    }

    public void ruleOverpass(String direction){
        if(direction.equals("row")) {
            mark = "row";
        }else{
            mark = "column";
        }

    }

    public boolean ifRowOfOverpassPassed(){
        boolean test = false;
        if(rowTraveller != null || !this.ifOverpass()){
            test = true;
        }
        return  test;
    }

    public boolean ifColumnOfOverpassPassed(){
        boolean test = false;
        if(columnTraveller != null || !this.ifOverpass()){
            test = true;
        }

        return  test;
    }





}

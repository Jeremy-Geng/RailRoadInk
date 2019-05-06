package comp1110.ass2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class IfConnectedToGateCorrectlyTest {
    @Test
    public void ConnectedToGateCorrectlyTest(){
        Board grid = new Board();
        boolean[] results = {true,false};
        Dice[] dices = new Dice[connectedCorrectlyTiles.length];
        for(int i = 0;i< connectedCorrectlyTiles.length;i++){
            dices[i] = RailroadInk.diceCreator(connectedCorrectlyTiles[i]);
            dices[i] = RailroadInk.diceRotatorOrFliper(dices[i],connectedCorrectlyTiles[i].charAt(4) - '0');
        }

        for(int i =0;i<dices.length;i++){
            char gate = grid.getTile(connectedCorrectlyTiles[i].charAt(2) - 'A', connectedCorrectlyTiles[i].charAt(3)-'0').getGate();
            assertTrue(connectedCorrectlyTiles[i]+ " is conncected to one gate correctlly, but your method shows false",RailroadInk.ifConnectedToGateCorrectly(connectedCorrectlyTiles[i],dices[i],gate) == results[0]);
        }
    }

    @Test
    public void ConnectedToGateInCorrectlyTest(){
        Board grid = new Board();
        boolean[] results = {true,false};
        Dice[] dices = new Dice[connectedIncorrectlyTiles.length];
        for(int i = 0;i< connectedIncorrectlyTiles.length;i++){
            dices[i] = RailroadInk.diceCreator(connectedIncorrectlyTiles[i]);
            dices[i] = RailroadInk.diceRotatorOrFliper(dices[i],connectedIncorrectlyTiles[i].charAt(4) - '0');
        }
        for(int i = 0;i<dices.length;i++){
            char gate = grid.getTile(connectedIncorrectlyTiles[i].charAt(2) - 'A', connectedIncorrectlyTiles[i].charAt(3)-'0').getGate();
            assertTrue(connectedIncorrectlyTiles[i]+ " is conncected to one gate incorrectlly, but your method shows true",RailroadInk.ifConnectedToGateCorrectly(connectedIncorrectlyTiles[i],dices[i],gate) == results[1]);

        }


    }


    public static String[] connectedCorrectlyTiles = {"A3A13","S4B60","A2G30","A5D00","B0G34","A3D02"};

    public static String[] connectedIncorrectlyTiles = {"A2D60","A3B02","B1G11","S4D60","B0G54"};




}

package comp1110.ass2;

// This class is for integrating every part of the game together, the main logic will be designed in this class later.
public class GameRRL {
    private Board grid;
    private Scoring socre;
    private Endgame endgame;
    private Dice[] dices;
// this method is for activating the game in the test drive
    public void startGame(){};

    public GameRRL(Board gir,Scoring score,Endgame endgame,Dice[] dices){
        startGame();
    }


}

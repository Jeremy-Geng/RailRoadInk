package comp1110.ass2;

import comp1110.ass2.Dice;
import comp1110.ass2.Tile;

public class Board {
    /* constants describing the shape of the board */
    public static final int NUM_ROWS = 7;
    public static final int NUM_COLS = 7;
    public static final int NUM_SPACES = 26; // number of spaces on board
    public int col;
    public int row;


    public Board(int col,int row){
        this.col = col;
        this.row = row;
    }

    public Tile[][] board = new Tile[7][7];

    Board(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length;j++){
                board[i][j] = new Tile('!');
            }
        }

        board[0][1].setGate('H');
        board[0][3].setGate('R');
        board[0][5].setGate('H');
        board[1][0].setGate('R');
        board[1][6].setGate('R');
        board[3][0].setGate('H');
        board[3][6].setGate('H');
        board[5][0].setGate('R');
        board[5][6].setGate('R');
        board[6][1].setGate('H');
        board[6][3].setGate('R');
        board[6][5].setGate('H');
    }

    public Tile getTile(int a, int b){
        return board[a][b];
    }



}


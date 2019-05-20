package comp1110.ass2.gui;


import com.sun.javafx.css.StyleCacheEntry;
import comp1110.ass2.*;
import javafx.application.Application;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.concurrent.CountDownLatch;


public class Game extends Application {
    //Game board on screen
    private final int screenX = 1024;
    private final int screenY = 768;
    private static Scene scene;
    private static Group group = new Group();
    private static GridPane board= new GridPane();
    public static int counter = 0;



    private  FXimageView[][] tiles = new FXimageView[9][9];
    private  Image blacktile = new Image("assets/whitesquare.png",true);
    private  Image railWayExit = new Image("assets/RailWayExit.png",true);
    private  Image highWayExit = new Image("assets/HighWayExit.png",true);

    Image A0 = new Image("assets/A0.png",true);
    Image A1 = new Image("assets/A1.png",true);
    Image A2 = new Image("assets/A2.png",true);
    Image A3 = new Image("assets/A3.png",true);
    Image A4 = new Image("assets/A4.png",true);
    Image A5 = new Image("assets/A5.png",true);


    Image S0 = new Image("assets/S0.png",true);
    Image S1 = new Image("assets/S1.png",true);
    Image S2 = new Image("assets/S2.png",true);
    Image S3 = new Image("assets/S3.png",true);
    Image S4 = new Image("assets/S4.png",true);
    Image S5 = new Image("assets/S5.png",true);

    Image B0 = new Image("assets/B0.png",true);
    Image B1 = new Image("assets/B1.png",true);
    Image B2 = new Image("assets/B2.png",true);


    public class FXimageView extends ImageView {
        String name = "none";
        String passages;
        char gate;
        Dice dice;
        int orientation = 0;
        boolean ifFlipped = false;
        boolean ifFilled = false;

        void setPassages(int orientation){
            dice.returnToStart();
            if(ifFlipped){
                dice.flip();
            }

            if(orientation % 4 == 1) {
                dice.rotate90Degree();
            }
            else if(orientation % 4 == 2){
                dice.rotate90Degree();
                dice.rotate90Degree();
            }else if(orientation % 4 == 3){
                dice.rotate90Degree();
                dice.rotate90Degree();
                dice.rotate90Degree();
            }

            passages = Character.toString(dice.getNorthPassage());
            passages = passages + Character.toString(dice.getEastPassage());
            passages = passages + Character.toString(dice.getSouthPassage());
            passages = passages + Character.toString(dice.getWestPassage());
        }

    }


    public  void fillInBoard(){
        for(int i = 0;i<tiles.length;i++){
            for(int j = 0; j<tiles.length;j++){
                tiles[i][j] = new FXimageView();
            }
        }


//        set up gates and  assgin name of gate for each gate
//        up gates
        for(int i = 0;i < 1;i++){
            for(int j = 2; j<tiles[0].length;j++ ){
                if(j == 2 || j == 6){
                    tiles[i][j].setImage(highWayExit);
                    tiles[i][j].setFitHeight(60);
                    tiles[i][j].setFitWidth(60);
                    tiles[i+1][j].gate = 'H';
                    board.add(tiles[i][j],j,i);

                }else if(j == 4){
                    tiles[i][j].setImage(railWayExit);
                    tiles[i][j].setFitHeight(60);
                    tiles[i][j].setFitWidth(60);
                    tiles[i+1][j].gate = 'R';
                    board.add(tiles[i][j],j,i);
                }
            }
        }

//        left gates
        for(int j = 0; j<1;j++){
            for(int i = 2; i < tiles.length;i++){
                if(i == 2 || i ==6){
                    tiles[i][j].setImage(railWayExit);
                    tiles[i][j].setFitHeight(60);
                    tiles[i][j].setFitWidth(60);
                    tiles[i][j].setRotate(-90);
                    tiles[i][j+1].gate = 'R';
                    board.add(tiles[i][j],j,i);

                }else if(i == 4){
                    tiles[i][j].setImage(highWayExit);
                    tiles[i][j].setFitHeight(60);
                    tiles[i][j].setFitWidth(60);
                    tiles[i][j].setRotate(-90);
                    tiles[i][j+1].gate = 'H';
                    board.add(tiles[i][j],j,i);
                }
            }
        }


//      down gates
        for(int i = 8;i < tiles.length;i++){
            for(int j = 2; j<tiles[0].length;j++ ){
                if(j == 2 || j == 6){
                    tiles[i][j].setImage(highWayExit);
                    tiles[i][j].setFitHeight(60);
                    tiles[i][j].setFitWidth(60);
                    tiles[i][j].setRotate(180);
                    tiles[i-1][j].gate = 'H';
                    board.add(tiles[i][j],j,i);

                }else if(j == 4){
                    tiles[i][j].setImage(railWayExit);
                    tiles[i][j].setFitHeight(60);
                    tiles[i][j].setFitWidth(60);
                    tiles[i][j].setRotate(180);
                    tiles[i-1][j].gate = 'R';
                    board.add(tiles[i][j],j,i);
                }
            }
        }

//        right gates
        for(int j = 8; j<tiles.length;j++){
            for(int i = 2; i < tiles.length;i++){
                if(i == 2 || i ==6){
                    tiles[i][j].setImage(railWayExit);
                    tiles[i][j].setFitHeight(60);
                    tiles[i][j].setFitWidth(60);
                    tiles[i][j].setRotate(90);
                    tiles[i][j-1].gate = 'R';
                    board.add(tiles[i][j],j,i);

                }else if(i == 4){
                    tiles[i][j].setImage(highWayExit);
                    tiles[i][j].setFitHeight(60);
                    tiles[i][j].setFitWidth(60);
                    tiles[i][j].setRotate(90);
                    tiles[i][j-1].gate = 'H';
                    board.add(tiles[i][j],j,i);
                }

            }
        }


//         set up tiles
        for(int i = 1 ;i < tiles.length-1;i++ ){
            for(int j = 1;j < tiles[i].length-1;j++){
                    tiles[i][j].setImage(blacktile);
                tiles[i][j].setFitHeight(60);
                tiles[i][j].setFitWidth(60);
                    board.add(tiles[i][j],j,i);
            }
        }

//        assign position information for each tile
        for(int i = 1;i<tiles.length-1;i++){
            for(int j = 1;j<tiles.length-1;j++){
                char row = (char)('A'-1+i);
                tiles[i][j].name = Character.toString(row) + Integer.toString(j-1);
            }
        }
        board.setLayoutX(240);
        board.setLayoutY(25);
    }

    public void creatDiceforAround() {
        //special Dices
            FXimageView[] specialDiceImages = new FXimageView[6];
            for (int i = 0; i < specialDiceImages.length; i++) {
                specialDiceImages[i] = new FXimageView();
            }
            specialDiceImages[0].setImage(S0);
            specialDiceImages[0].dice = new S(0);
            specialDiceImages[0].name = "S0";
            specialDiceImages[1].setImage(S1);
            specialDiceImages[1].dice = new S(1);
            specialDiceImages[1].name = "S1";
            specialDiceImages[2].setImage(S2);
            specialDiceImages[2].dice = new S(2);
            specialDiceImages[2].name = "S2";
            specialDiceImages[3].setImage(S3);
            specialDiceImages[3].dice = new S(3);
            specialDiceImages[3].name = "S3";
            specialDiceImages[4].setImage(S4);
            specialDiceImages[4].dice = new S(4);
            specialDiceImages[4].name = "S4";
            specialDiceImages[5].setImage(S5);
            specialDiceImages[5].dice = new S(5);
            specialDiceImages[5].name = "S5";
            Button[] sDices = new Button[6];
            for (int i = 0; i < sDices.length; i++) {
                int j = i + 1;
                if (j == 1) sDices[i] = new Button("Rotate " + j + "st Dice");
                else if (j == 2) sDices[i] = new Button("Rotate " + j + "nd Dice");
                else if (j == 3) sDices[i] = new Button("Rotate " + j + "rd Dice");
                else if (j == 4) sDices[i] = new Button("Rotate " + j + "th Dice");
                else if (j == 5) sDices[i] = new Button("Rotate " + j + "th Dice");
                else if (j == 6) sDices[i] = new Button("Rotate " + j + "th Dice");
                sDices[i].setLayoutX(100);
                sDices[i].setLayoutY(90 + 125 * i);
                sDices[i].setEffect(new SepiaTone());
                rotatedice(sDices[i], specialDiceImages[i]);
                group.getChildren().addAll(sDices[i]);
            }
            for (int i = 0; i < specialDiceImages.length; i++) {
                specialDiceImages[i].setFitHeight(50);
                specialDiceImages[i].setFitWidth(50);
                specialDiceImages[i].setLayoutX(125);
                specialDiceImages[i].setLayoutY(30 + 120 * i);
                group.getChildren().add(specialDiceImages[i]);
            }
            for (int i = 0; i < specialDiceImages.length; i++) {
                onDragDetected(specialDiceImages[i], i);

            }
            for (int i = 1; i < tiles.length - 1; i++) {
                for (int j = 1; j < tiles[i].length - 1; j++) {
                    onDragOver(tiles[i][j], tiles, i, j);
                    onDragEntered(tiles[i][j]);
                    onDragExit(tiles[i][j]);
                    onDragDroppedForSpecialDices(tiles[i][j], specialDiceImages);
                }
            }


















        //Normal dices
        Button button = new Button("Throw a dice");
        button.setLayoutX(800);
        button.setLayoutY(650);
        button.setEffect(new DropShadow());
        group.getChildren().add(button);
        FXimageView[] diceImages  = new FXimageView[4];
        Button[] rbs = new Button[4];

        button.setOnAction(e ->{
            String dices = RailroadInk.generateDiceRoll();
            String[] diceBuiler = new String[4];

            for(int i = 0;i<diceBuiler.length;i++){
                diceBuiler[i] = dices.substring(i*2,(i+1)*2);
            }

            for(int i = 0;i<diceImages.length;i++){
                if(diceImages[i] != null){
                    group.getChildren().remove(diceImages[i]);
                }
            }

            for(int i = 0;i < diceBuiler.length;i++){
                diceImages[i] = new FXimageView();
                if(diceBuiler[i].charAt(0) == 'A'){
                    if(diceBuiler[i].charAt(1) == '0'){
                        diceImages[i].setImage(A0);
                        diceImages[i].dice = new A(0);
                        diceImages[i].name = "A0";
                    }else if(diceBuiler[i].charAt(1) == '1'){
                        diceImages[i].setImage(A1);
                        diceImages[i].dice = new A(1);
                        diceImages[i].name = "A1";
                    }else if(diceBuiler[i].charAt(1) == '2'){
                        diceImages[i].setImage(A2);
                        diceImages[i].dice = new A(2);
                        diceImages[i].name = "A2";
                    }else if(diceBuiler[i].charAt(1) == '3'){
                        diceImages[i].setImage(A3);
                        diceImages[i].dice = new A(3);
                        diceImages[i].name = "A3";
                    }else if(diceBuiler[i].charAt(1) == '4'){
                        diceImages[i].setImage(A4);
                        diceImages[i].dice = new A(4);
                        diceImages[i].name = "A4";
                    }else if(diceBuiler[i].charAt(1) == '5'){
                        diceImages[i].setImage(A5);
                        diceImages[i].dice = new A(5);
                        diceImages[i].name = "A5";
                    }

                }else if(diceBuiler[i].charAt(0) == 'B'){
                    if(diceBuiler[i].charAt(1) == '0'){
                        diceImages[i].setImage(B0);
                        diceImages[i].dice = new B(0);
                        diceImages[i].name = "B0";
                    }else if(diceBuiler[i].charAt(1) == '1'){
                        diceImages[i].setImage(B1);
                        diceImages[i].dice = new B(1);
                        diceImages[i].name = "B1";
                    }else if(diceBuiler[i].charAt(1) == '2'){
                        diceImages[i].setImage(B2);
                        diceImages[i].dice = new B(2);
                        diceImages[i].name = "B2";
                    }
                }
            }

            for(int i = 0; i<diceImages.length;i++){
                diceImages[i].setFitHeight(50);
                diceImages[i].setFitWidth(50);
                diceImages[i].setLayoutX(300+120*i);
                diceImages[i].setLayoutY(600);
                group.getChildren().add(diceImages[i]);
            }

            for(int i = 0;i< rbs.length;i++){
                int j = i+1;
                if(j ==1 ) rbs[i] = new Button("Rotate "+ j +"st Dice" );
                else if(j ==2 ) rbs[i] = new Button("Rotate "+ j +"nd Dice" );
                else if(j == 3 ||j == 4 ) rbs[i] = new Button("Rotate "+ j +"th Dice" );
                rbs[i].setLayoutX(270+125*i);
                rbs[i].setLayoutY(700);
                rbs[i].setEffect(new SepiaTone());
                rotatedice(rbs[i],diceImages[i]);
                group.getChildren().addAll(rbs[i]);

            }

            for(int i = 0;i < diceImages.length;i++){
                onDragDetected(diceImages[i],i);
            }

            for(int i = 1;i<tiles.length-1;i++){
                for(int j = 1;j<tiles[i].length-1;j++){
                    onDragOver(tiles[i][j],tiles,i,j);
                    onDragEntered(tiles[i][j]);
                    onDragExit(tiles[i][j]);
                    onDragDropped(tiles[i][j],diceImages);
                }
            }

        });

        group.setOnKeyReleased(t ->{
            if(t.getCode() == KeyCode.A && diceImages[0].getRotate() % 360 == 0){
                diceImages[0].setScaleX(-1);
                diceImages[0].ifFlipped = true;
                diceImages[0].orientation = 4;
            }else if(t.getCode() == KeyCode.S && diceImages[1].getRotate() % 360 ==0){
                diceImages[1].setScaleX(-1);
                diceImages[1].ifFlipped = true;
                diceImages[1].orientation = 4;
            }else if(t.getCode() == KeyCode.D && diceImages[2].getRotate() % 360 == 0){
                diceImages[2].setScaleX(-1);
                diceImages[2].ifFlipped = true;
                diceImages[2].orientation = 4;
            }else if(t.getCode() == KeyCode.F && diceImages[3].getRotate() % 360 == 0 ){
                diceImages[3].setScaleX(-1);
                diceImages[3].ifFlipped = true;
                diceImages[3].orientation = 4;
            }
        });

    }

    public static void rotatedice(Button rb,FXimageView fiv){
        rb.setOnAction(e->{
            fiv.setRotate(fiv.getRotate() + 90);
            fiv.orientation = fiv.orientation + 1;
        });
    }

    public static void onDragDetected(FXimageView fxImageView,int cleanNum){
        fxImageView.setOnDragDetected(e ->{
            Dragboard db = fxImageView.startDragAndDrop(TransferMode.ANY);
            ClipboardContent content = new ClipboardContent();
            Image dragView = fxImageView.snapshot(null, null);
            content.putImage(dragView);
            fxImageView.setPassages(fxImageView.orientation);
            String fxOrientation = "";
            if(!fxImageView.ifFlipped){
                fxOrientation = fxOrientation + fxImageView.orientation % 4;
            }else if(fxImageView.ifFlipped){
                int i = 4 + fxImageView.orientation % 4 ;
                fxOrientation = fxOrientation + i;
            }
            String tansfered = fxImageView.name + fxOrientation + fxImageView.passages + cleanNum;
            System.out.println(tansfered);
            System.out.println(fxImageView.orientation);
            content.putString(tansfered);
            db.setContent(content);
            e.consume();
        });
    }

    public static void onDragOver(FXimageView fXimageView,FXimageView[][] board,int row,int col){

        fXimageView.setOnDragOver(e ->{
            String transferName = e.getDragboard().getString().substring(0,2);
            String tansferOrientation = e.getDragboard().getString().substring(2,3);
            String tansferPassage =e.getDragboard().getString().substring(3,7);
            String placementInfo = transferName + fXimageView.name + tansferOrientation + tansferPassage;


            if(!fXimageView.name.equals("none") && !fXimageView.ifFilled){
//              gates
                if(fXimageView.name.charAt(0) == 'A'){
                    if(fXimageView.gate == placementInfo.charAt(5)){
                        e.acceptTransferModes(TransferMode.ANY);
                    }
                }else if(fXimageView.name.charAt(0) == 'B'){
                    if(fXimageView.name.charAt(1) == '0'){
                        if(fXimageView.gate == placementInfo.charAt(8)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }else if(fXimageView.name.charAt(1) == '6'){
                        if(fXimageView.gate == placementInfo.charAt(6)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }
                }else if(fXimageView.name.charAt(0) == 'D'){
                    if(fXimageView.name.charAt(1) == '0'){
                        if(fXimageView.gate == placementInfo.charAt(8)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }
                    else if(fXimageView.name.charAt(1) == '6'){
                        if(fXimageView.gate == placementInfo.charAt(6)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }
                    }else if(fXimageView.name.charAt(0) == 'F'){
                        if(fXimageView.name.charAt(1) == '0'){
                            if(fXimageView.gate == placementInfo.charAt(8)){
                                e.acceptTransferModes(TransferMode.ANY);
                            }
                        }else if(fXimageView.name.charAt(1) == '6'){
                            if(fXimageView.gate == placementInfo.charAt(6)){
                                e.acceptTransferModes(TransferMode.ANY);
                            }
                        }
                } else if(fXimageView.name.charAt(0) == 'G'){
                    if(fXimageView.gate == placementInfo.charAt(7)){
                        e.acceptTransferModes(TransferMode.ANY);
                    }
                    }

//               normal tiles
                String pi = placementInfo.substring(0,5);
//                check top-left
                if(row == 1 && col == 1){
                    if(board[1][2].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[1][2].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }
                    if(board[2][1].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[2][1].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }
                }
//                check top-right

                if(row == 1 && col == 7){
                    if(board[1][6].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[1][6].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }
                    if(board[2][7].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[2][7].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }
                }
//               check bottom-left
                if(row == 7 && col == 1){
                    if(board[7][2].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[7][2].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }
                    if(board[6][1].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[6][1].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }
                }
//              check bottom-right
                if(row == 7 && col == 7){
                    if(board[7][6].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[7][6].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }
                    if(board[6][7].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[6][7].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }
                }

//                check top-edge
                if(row == 1 && col != 1 && col != 7 ){
                    if(board[row][col+1].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[row][col+1].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }

                    if(board[row][col-1].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[row][col-1].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }

                    if(board[row+1][col].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[row+1][col].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }
                }

//                check left-edge
                if(col == 1 && row != 1 && row != 7 ){
                    if(board[row][col+1].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[row][col+1].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }

                    if(board[row+1][col].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[row+1][col].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }

                    if(board[row-1][col].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[row-1][col].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }

                }
//                check bottom-edge
                if(row ==7 && col != 1 && col != 7){
                    if(board[row][col+1].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[row][col+1].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }

                    if(board[row][col-1].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[row][col-1].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }

                    if(board[row-1][col].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[row-1][col].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }

                }
//                check right-edge
                if(col ==7 && row != 1 && row != 7){
                    if(board[row][col-1].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[row][col-1].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }

                    if(board[row+1][col].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[row+1][col].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }

                    if(board[row-1][col].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[row-1][col].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }

                }

                if(row > 1 && row <7 && col > 1 && col <7){
                    if(board[row][col-1].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[row][col-1].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }

                    if(board[row][col+1].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[row][col+1].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }

                    if(board[row+1][col].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[row+1][col].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }

                    if(board[row-1][col].ifFilled){
                        if(RailroadInk.areConnectedNeighbours(pi,board[row-1][col].name)){
                            e.acceptTransferModes(TransferMode.ANY);
                        }
                    }

                }






            }
        });
    }

    public static void onDragEntered(FXimageView fXimageView){
        fXimageView.setOnDragEntered(e ->{
            fXimageView.setEffect(new GaussianBlur());
            e.consume();
        });
    }

    public static void onDragExit(FXimageView fXimageView){
        fXimageView.setOnDragExited(e ->{
            fXimageView.setEffect(new Glow());
        });
    }

    public static void onDragDropped(FXimageView fXimageView,FXimageView[] cleanImage) {
        fXimageView.setOnDragDropped(e -> {

            String transferName = e.getDragboard().getString().substring(0, 2);
            String tansferOrientation = e.getDragboard().getString().substring(2, 3);
            String tansferPassage = e.getDragboard().getString().substring(3, 7);
            String placementInfo = transferName + fXimageView.name + tansferOrientation;


            boolean success = false;
            fXimageView.setImage(e.getDragboard().getImage());
            fXimageView.name = placementInfo;
            fXimageView.ifFilled = true;
            success = true;

            int i = Integer.parseInt(e.getDragboard().getString().substring(7, 8));
            cleanImage[i].setImage(null);
            e.setDropCompleted(success);
            e.consume();

        });
    }
    public static void onDragDroppedForSpecialDices(FXimageView fXimageView,FXimageView[] cleanImage) {
        if (counter==3){
            return;
        }
        fXimageView.setOnDragDropped(e -> {

            String transferName = e.getDragboard().getString().substring(0, 2);
            String tansferOrientation = e.getDragboard().getString().substring(2, 3);
            String tansferPassage = e.getDragboard().getString().substring(3, 7);
            String placementInfo = transferName + fXimageView.name + tansferOrientation;


            boolean success = false;
            fXimageView.setImage(e.getDragboard().getImage());
            fXimageView.name = placementInfo;
            fXimageView.ifFilled = true;
            success = true;

            int i = Integer.parseInt(e.getDragboard().getString().substring(7, 8));
            cleanImage[i].setImage(null);
            e.setDropCompleted(success);
            e.consume();
            counter++;
        });
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Railroad Ink: Deep Blue Edition");
        group.getChildren().add(board);
        scene = new Scene(group,screenX,screenY);
        fillInBoard();
        this.creatDiceforAround();
        primaryStage.setScene(scene);
        primaryStage.show();
        group.requestFocus();

    }

    public static void main(String[] args) {
        launch(args);
    }
}

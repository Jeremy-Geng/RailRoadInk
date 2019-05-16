package comp1110.ass2.gui;


import com.sun.javafx.css.StyleCacheEntry;
import comp1110.ass2.RailroadInk;
import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;




public class Game extends Application {
    //Game board on screen
    private final int screenX = 1024;
    private final int screenY = 768;
    private static Scene scene;
    private static Group group = new Group();
    private static GridPane board= new GridPane();


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




    public class FXimageView extends ImageView{

    }

    public  void fillInBoard(){
        for(int i = 0;i<tiles.length;i++){
            for(int j = 0; j<tiles.length;j++){
                tiles[i][j] = new FXimageView();
            }
        }

//        set up gates
//        up gates
        for(int i = 0;i < 1;i++){
            for(int j = 2; j<tiles[0].length;j++ ){
                if(j == 2 || j == 6){
                    tiles[i][j].setImage(highWayExit);
                    tiles[i][j].setFitHeight(60);
                    tiles[i][j].setFitWidth(60);
                    board.add(tiles[i][j],j,i);

                }else if(j == 4){
                    tiles[i][j].setImage(railWayExit);
                    tiles[i][j].setFitHeight(60);
                    tiles[i][j].setFitWidth(60);
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
                    board.add(tiles[i][j],j,i);
                }else if(i == 4){
                    tiles[i][j].setImage(highWayExit);
                    tiles[i][j].setFitHeight(60);
                    tiles[i][j].setFitWidth(60);
                    tiles[i][j].setRotate(-90);
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
                    board.add(tiles[i][j],j,i);

                }else if(j == 4){
                    tiles[i][j].setImage(railWayExit);
                    tiles[i][j].setFitHeight(60);
                    tiles[i][j].setFitWidth(60);
                    tiles[i][j].setRotate(180);
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
                    board.add(tiles[i][j],j,i);

                }else if(i == 4){
                    tiles[i][j].setImage(highWayExit);
                    tiles[i][j].setFitHeight(60);
                    tiles[i][j].setFitWidth(60);
                    tiles[i][j].setRotate(90);
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
                board.add(tiles[i][j],i,j);
            }
        }


        board.setLayoutX(240);
        board.setLayoutY(25);


    }

    public void creatDiceforAround(){
        Button button = new Button("Throw a dice");
        button.setLayoutX(800);
        button.setLayoutY(650);
        group.getChildren().add(button);
        FXimageView[] diceImages  = new FXimageView[4];
        Button[] rbs = new Button[4];
        button.setOnAction(e ->{
            String dices = RailroadInk.generateDiceRoll();
            String[] diceBuiler = new String[4];

            for(int i = 0;i<diceBuiler.length;i++){
                diceBuiler[i] = dices.substring(i*2,(i+1)*2);
            }

            for(int i = 0;i < diceBuiler.length;i++){
                diceImages[i] = new FXimageView();
                if(diceBuiler[i].charAt(0) == 'A'){
                    if(diceBuiler[i].charAt(1) == '0'){
                        diceImages[i].setImage(A0);
                    }else if(diceBuiler[i].charAt(1) == '1'){
                        diceImages[i].setImage(A1);
                    }else if(diceBuiler[i].charAt(1) == '2'){
                        diceImages[i].setImage(A2);
                    }else if(diceBuiler[i].charAt(1) == '3'){
                        diceImages[i].setImage(A3);
                    }else if(diceBuiler[i].charAt(1) == '4'){
                        diceImages[i].setImage(A4);
                    }else if(diceBuiler[i].charAt(1) == '5'){
                        diceImages[i].setImage(A5);
                    }

                }else if(diceBuiler[i].charAt(0) == 'B'){
                    if(diceBuiler[i].charAt(1) == '0'){
                        diceImages[i].setImage(B0);
                    }else if(diceBuiler[i].charAt(1) == '1'){
                        diceImages[i].setImage(B0);
                    }else if(diceBuiler[i].charAt(1) == '2'){
                        diceImages[i].setImage(B0);
                    }
                }
            }

            for(int i = 0; i<diceImages.length;i++){
                diceImages[i].setFitHeight(70);
                diceImages[i].setFitWidth(70);
                diceImages[i].setLayoutX(300+120*i);
                diceImages[i].setLayoutY(600);
                group.getChildren().add(diceImages[i]);
            }

            for(int i = 0;i< rbs.length;i++){
                rbs[i] = new Button("Rotate "+ i+1 +" Dice" );
                rbs[i].setLayoutX(300+120*i);
                rbs[i].setLayoutY(700);
                rotatedice(rbs[i],diceImages[i]);
                group.getChildren().addAll(rbs[i]);

            }


        });

        for(int i = 0;i< rbs.length;i++){
            rbs[i] = new Button("Rotate "+ i+1 +" Dice" );
            rbs[i].setLayoutX(300+120*i);
            rbs[i].setLayoutY(700);
            rotatedice(rbs[i],diceImages[i]);
            group.getChildren().addAll(rbs[i]);

        }

    }



    public static void rotatedice(Button rb,FXimageView fiv){
        rb.setOnAction(e->{
            fiv.setRotate(fiv.getRotate() + 90);


        });
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Railroad Ink: Deep Blue Edition");
        group.getChildren().add(board);

        scene = new Scene(group,screenX,screenY);

        fillInBoard();
        this.creatDiceforAround();
        primaryStage.setScene(scene);
        primaryStage.show();




    }
    public static void main(String[] args) {
        launch(args);
    }
}
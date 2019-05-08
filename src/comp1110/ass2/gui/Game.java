package comp1110.ass2.gui;


import javafx.application.Application;

import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;



public class Game extends Application {
    //Game board on screen
    private final int ScreenX = 1024;
    private final int ScreenY = 768;
    //node groups
    private final Group root = new Group();
    private final Group solution = new Group();
    private final Group board = new Group();
    private final Group controls = new Group();
    private final Group dices = new Group();


    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Game");



    }
    public static void main(String[] args) {
        launch(args);
    }
}

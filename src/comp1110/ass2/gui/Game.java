package comp1110.ass2.gui;


import comp1110.ass2.Board;
import comp1110.ass2.Dice;
import comp1110.ass2.RailroadInk;
import javafx.application.Application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static comp1110.ass2.gui.Viewer.postionImage;


public class Game extends Application {

    /* board layout */
    private static final double DICE_HEIGHT = 65;
    private static final double DICE_WIDTH = 65;

    private static final int MARGIN_X = (int) DICE_HEIGHT;
    private static final int BOARD_X = (int) DICE_HEIGHT * 4;
    private static final int MARGIN_Y = (int) (DICE_HEIGHT * 0.5);
    private static final int BOARD_Y = MARGIN_Y;
    private static final int BOARD_WIDTH = Board.NUM_COLS * (int) DICE_HEIGHT;
    private static final int GAME_WIDTH = 2 * BOARD_X + BOARD_WIDTH;
    private static final int BOARD_HEIGHT = (int) (Board.NUM_ROWS * DICE_HEIGHT);
    private static final int PIECE_AREA_HEIGHT = (int) (2 *Dice.MAX_DICE_WIDTH* DICE_HEIGHT);
    private static final int GAME_HEIGHT = 2 * MARGIN_Y + BOARD_HEIGHT + PIECE_AREA_HEIGHT;

    /* color the underlying board */
    private static final Paint SUBBOARD_FILL = Color.DARKGREY;
    private static final Paint SUBBOARD_STROKE = Color.GREY;

    /* where to find media assets */
    private static final String URI_BASE = "assets/";

    private Pane pane = new Pane();
    // node groups
    private final Group root = new Group();
    private final Group solution = new Group();
    private final Group board = new Group();
    private final Group controls = new Group();
    private final Group pieces = new Group();
    // The message on completion
    private final Text completionText = new Text("Well done!");
    // The grid for the game

    public static final int rows = 7;
    public static final int columns = 7;
    // Import dices
        public void makeDices(){
            FlowPane flowPane = new FlowPane();

    }








    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Game");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();



    }
    public static void main(String[] args) {
        launch(args);
    }
}

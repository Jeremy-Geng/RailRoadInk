package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.FileInputStream;

/**
 * A very simple viewer for tile placements in the Railroad Ink game.
 * <p>
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various tile placements.
 */
public class Viewer extends Application {
    /* board layout */
    private static final int VIEWER_WIDTH = 1024;
    private static final int VIEWER_HEIGHT = 768;

    private static final String URI_BASE = "assets/";

    private final Group root = new Group();
    private final Group controls = new Group();
    TextField textField;

    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement A valid placement string
     */
    void makePlacement(String placement) {
        int numberOfTiles = placement.length() / 5;
        String[] arrayOfTiles = new String[numberOfTiles];

//        To spilt Board String into tile Placement string
        for (int i = 0; i < placement.length(); i += 5) {
            arrayOfTiles[i / 5] = placement.substring(i, i + 5);
        }

        int rows = 7;
        int columns = 7;


//      To import pictures of each dice.
        Image A0 = new Image("assets/A0.png",true);
        Image A1 = new Image("assets/A1.png",true);
        Image A2 = new Image("assets/A2.png",true);
        Image A3 = new Image("assets/A3.png",true);
        Image A4 = new Image("assets/A4.png",true);
        Image A5 = new Image("assets/A5.png",true);

        Image FA0 = new Image("assets/FA0.png",true);
        Image FA1 = new Image("assets/FA1.png",true);
        Image FA2 = new Image("assets/FA2.png",true);
        Image FA3 = new Image("assets/FA3.png",true);
        Image FA4 = new Image("assets/FA4.png",true);
        Image FA5 = new Image("assets/FA5.png",true);

        Image S0 = new Image("assets/S0.png",true);
        Image S1 = new Image("assets/S1.png",true);
        Image S2 = new Image("assets/S2.png",true);
        Image S3 = new Image("assets/S3.png",true);
        Image S4 = new Image("assets/S4.png",true);
        Image S5 = new Image("assets/S5.png",true);

        Image FS0 = new Image("assets/FS0.png",true);
        Image FS1 = new Image("assets/FS1.png",true);
        Image FS2 = new Image("assets/FS2.png",true);
        Image FS3 = new Image("assets/FS3.png",true);
        Image FS4 = new Image("assets/FS4.png",true);
        Image FS5 = new Image("assets/FS5.png",true);

        Image B0 = new Image("assets/B0.png",true);
        Image B1 = new Image("assets/B1.png",true);
        Image B2 = new Image("assets/B2.png",true);

        Image FB0 = new Image("assets/FB0.png",true);
        Image FB1 = new Image("assets/FB1.png",true);
        Image FB2 = new Image("assets/FB2.png",true);

        GridPane grid = new GridPane();
        grid.setLayoutX(235);
        grid.setLayoutY(50);

        for(int i = 0; i < rows; i++){
            RowConstraints row = new RowConstraints(80);
            grid.getRowConstraints().add(row);
        }
        for(int i = 0;i < columns;i++){
            ColumnConstraints column = new ColumnConstraints(80);
            grid.getColumnConstraints().add(column);
        }

        for(int i = 0; i < arrayOfTiles.length;i++){
            int orientaion = 0;
            int row = arrayOfTiles[i].charAt(2) - 'A';
            int column = arrayOfTiles[i].charAt(3) - '0';

            if(arrayOfTiles[i].substring(0,2).equals("A0")){
                ImageView a = new ImageView();

                if(arrayOfTiles[i].charAt(4) - '0' <=3) {
                   orientaion = arrayOfTiles[i].charAt(4) - '0';
                   a.setImage(A0);
               }
               else {orientaion = arrayOfTiles[i].charAt(4) - '0' - 4;
                   a.setImage(FA0);
               }
               postionImage(grid,a,column,row,orientaion);
            }

            else if(arrayOfTiles[i].substring(0,2).equals("A1")){
                ImageView a = new ImageView();

                if(arrayOfTiles[i].charAt(4) - '0' <=3) {
                    orientaion = arrayOfTiles[i].charAt(4) - '0';
                    a.setImage(A1);
                }
                else {orientaion = arrayOfTiles[i].charAt(4) - '0' - 4;
                    a.setImage(FA1);
                }
                postionImage(grid,a,column,row,orientaion);
            }

            else if(arrayOfTiles[i].substring(0,2).equals("A2")){
                ImageView a = new ImageView();

                if(arrayOfTiles[i].charAt(4) - '0' <=3) {
                    orientaion = arrayOfTiles[i].charAt(4) - '0';
                    a.setImage(A2);
                }
                else {orientaion = arrayOfTiles[i].charAt(4) - '0' - 4;
                    a.setImage(FA2);
                }
                postionImage(grid,a,column,row,orientaion);
            }

            else if(arrayOfTiles[i].substring(0,2).equals("A3")){
                ImageView a = new ImageView();

                if(arrayOfTiles[i].charAt(4) - '0' <=3) {
                    orientaion = arrayOfTiles[i].charAt(4) - '0';
                    a.setImage(A3);
                }
                else {orientaion = arrayOfTiles[i].charAt(4) - '0' - 4;
                    a.setImage(FA3);
                }
                postionImage(grid,a,column,row,orientaion);
            }

            else if(arrayOfTiles[i].substring(0,2).equals("A4")){
                ImageView a = new ImageView();

                if(arrayOfTiles[i].charAt(4) - '0' <=3) {
                    orientaion = arrayOfTiles[i].charAt(4) - '0';
                    a.setImage(A4);
                }
                else {orientaion = arrayOfTiles[i].charAt(4) - '0' - 4;
                    a.setImage(FA4);
                }
                postionImage(grid,a,column,row,orientaion);
            }

            else if(arrayOfTiles[i].substring(0,2).equals("A5")){
                ImageView a = new ImageView();

                if(arrayOfTiles[i].charAt(4) - '0' <=3) {
                    orientaion = arrayOfTiles[i].charAt(4) - '0';
                    a.setImage(A5);
                }
                else {orientaion = arrayOfTiles[i].charAt(4) - '0' - 4;
                    a.setImage(FA5);
                }
                postionImage(grid,a,column,row,orientaion);
            }

            else if(arrayOfTiles[i].substring(0,2).equals("S0")){
                ImageView a = new ImageView();

                if(arrayOfTiles[i].charAt(4) - '0' <=3) {
                    orientaion = arrayOfTiles[i].charAt(4) - '0';
                    a.setImage(S0);
                }
                else {orientaion = arrayOfTiles[i].charAt(4) - '0' - 4;
                    a.setImage(FS0);
                }
                postionImage(grid,a,column,row,orientaion);
            }

            else if(arrayOfTiles[i].substring(0,2).equals("S1")){
                ImageView a = new ImageView();

                if(arrayOfTiles[i].charAt(4) - '0' <=3) {
                    orientaion = arrayOfTiles[i].charAt(4) - '0';
                    a.setImage(S1);
                }
                else {orientaion = arrayOfTiles[i].charAt(4) - '0' - 4;
                    a.setImage(FS1);
                }
                postionImage(grid,a,column,row,orientaion);
            }

            else if(arrayOfTiles[i].substring(0,2).equals("S2")){
                ImageView a = new ImageView();

                if(arrayOfTiles[i].charAt(4) - '0' <=3) {
                    orientaion = arrayOfTiles[i].charAt(4) - '0';
                    a.setImage(S2);
                }
                else {orientaion = arrayOfTiles[i].charAt(4) - '0' - 4;
                    a.setImage(FS2);
                }
                postionImage(grid,a,column,row,orientaion);
            }

            else if(arrayOfTiles[i].substring(0,2).equals("S3")){
                ImageView a = new ImageView();

                if(arrayOfTiles[i].charAt(4) - '0' <=3) {
                    orientaion = arrayOfTiles[i].charAt(4) - '0';
                    a.setImage(S3);
                }
                else {orientaion = arrayOfTiles[i].charAt(4) - '0' - 4;
                    a.setImage(FS3);
                }
                postionImage(grid,a,column,row,orientaion);
            }

            else if(arrayOfTiles[i].substring(0,2).equals("S4")){
                ImageView a = new ImageView();

                if(arrayOfTiles[i].charAt(4) - '0' <=3) {
                    orientaion = arrayOfTiles[i].charAt(4) - '0';
                    a.setImage(S4);
                }
                else {orientaion = arrayOfTiles[i].charAt(4) - '0' - 4;
                    a.setImage(FS4);
                }
                postionImage(grid,a,column,row,orientaion);
            }

            else if(arrayOfTiles[i].substring(0,2).equals("S5")){
                ImageView a = new ImageView();

                if(arrayOfTiles[i].charAt(4) - '0' <=3) {
                    orientaion = arrayOfTiles[i].charAt(4) - '0';
                    a.setImage(S5);
                }
                else {orientaion = arrayOfTiles[i].charAt(4) - '0' - 4;
                    a.setImage(FS5);
                }
                postionImage(grid,a,column,row,orientaion);
            }

            else if(arrayOfTiles[i].substring(0,2).equals("B0")){
                ImageView a = new ImageView();

                if(arrayOfTiles[i].charAt(4) - '0' <=3) {
                    orientaion = arrayOfTiles[i].charAt(4) - '0';
                    a.setImage(B0);
                }
                else {orientaion = arrayOfTiles[i].charAt(4) - '0' - 4;
                    a.setImage(FB0);
                }
                postionImage(grid,a,column,row,orientaion);
            }

            else if(arrayOfTiles[i].substring(0,2).equals("B1")){
                ImageView a = new ImageView();

                if(arrayOfTiles[i].charAt(4) - '0' <=3) {
                    orientaion = arrayOfTiles[i].charAt(4) - '0';
                    a.setImage(B1);
                }
                else {orientaion = arrayOfTiles[i].charAt(4) - '0' - 4;
                    a.setImage(FB1);
                }
                postionImage(grid,a,column,row,orientaion);
            }

            else if(arrayOfTiles[i].substring(0,2).equals("B2")){
                ImageView a = new ImageView();

                if(arrayOfTiles[i].charAt(4) - '0' <=3) {
                    orientaion = arrayOfTiles[i].charAt(4) - '0';
                    a.setImage(B2);
                }
                else {orientaion = arrayOfTiles[i].charAt(4) - '0' - 4;
                    a.setImage(FB2);
                }
                postionImage(grid,a,column,row,orientaion);
            }
        }
        grid.setGridLinesVisible(true);

        root.getChildren().add(grid);
    }

    public static void postionImage(GridPane grid,ImageView imageView,int column, int row,int orientation) {
        if (orientation == 1) imageView.setRotate(90);
        else if (orientation == 2) imageView.setRotate(180);
        else if (orientation == 3) imageView.setRotate(270);
        imageView.setFitHeight(80);
        imageView.setFitWidth(80);
        grid.add(imageView,column,row);
    }


    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label label1 = new Label("Placement:");
        textField = new TextField();
        textField.setPrefWidth(300);
        Button button = new Button("Refresh");
        button.setOnAction(e -> {
            makePlacement(textField.getText());
            textField.clear();
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("StepsGame Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);

        root.getChildren().add(controls);

        makeControls();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

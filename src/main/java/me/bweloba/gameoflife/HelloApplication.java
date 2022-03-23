package me.bweloba.gameoflife;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import me.bweloba.gameoflife.Grids.Grid;

import java.io.IOException;

public class HelloApplication extends Application {

    private Grid grids = new Grid();

    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 320, 500);
        Scene scene = new Scene(root, 320, 500);
        stage.setTitle("Hello!");
        root.getChildren().add(fxmlLoader.load());
        root.getChildren().add(addTilePane());
        stage.setScene(scene);
        stage.show();
    }

    public TilePane addTilePane() {
        TilePane tile = new TilePane();
        tile.setPrefColumns(45);
        tile.setPrefRows(90);
        tile.setPrefTileWidth(25);
        tile.setPrefTileHeight(25);
        tile.setLayoutX(220);

        int[][] grid = grids.generateRandomGrid(0.6);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    tile.getChildren().add(addButton("1"));
                } else {
                    tile.getChildren().add(addButton("0"));
                }
            }
        }

        //loop throguh all the children
        for (int v = 0; v < tile.getChildren().size(); v++) {
            //get button value
            String value = ((Button) tile.getChildren().get(v)).getText();
            if (value.equals("1")) {
                ((Button) tile.getChildren().get(v)).setStyle("-fx-background-color: #000000;");
            }else{
                ((Button) tile.getChildren().get(v)).setStyle("-fx-background-color: #ffffff;");
            }
        }
//        Scene tileScene = new Scene(tile);
        return tile;
    }

    //method to construct button
    public Button addButton(String value) {
        Button button = new Button(value);
        button.setPrefSize(25, 25);
        //set button spacing to 0
        button.setStyle("-fx-padding: 0; -fx-border-width: 0;");
        return button;
    }

    public static void main(String[] args) {
        launch();
    }
}
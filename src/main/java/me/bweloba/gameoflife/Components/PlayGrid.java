package me.bweloba.gameoflife.Components;

import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import me.bweloba.gameoflife.Grids.Grid;

public class PlayGrid {

    private static final Grid grids = new Grid();

    public static TilePane addTilePane() {
        TilePane tile = new TilePane();
        tile.setPrefColumns(grids.getNumCols());
        tile.setPrefRows(grids.getNumRows());
        tile.setHgap(2);
        tile.setVgap(2);
        tile.alignmentProperty().set(javafx.geometry.Pos.CENTER);
        //add padding to the tile pane
        tile.setPadding(new javafx.geometry.Insets(5, 5, 5, 5));
        //make background blue
        tile.setBackground(new Background(new BackgroundFill(Color.web("#001318"), null, null)));
        tile.setMinSize((grids.getNumCols() * 15) + (grids.getNumCols() * 2), (grids.getNumRows() * 15) + (grids.getNumRows() * 2));

        int[][] grid = grids.generateRandomGrid(0.9);

        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt == 1) {
                    tile.getChildren().add(addButton("1"));
                } else {
                    tile.getChildren().add(addButton("0"));
                }
            }
        }

        //loop through all the children
        for (int v = 0; v < tile.getChildren().size(); v++) {
            //get button value
            String value = tile.getChildren().get(v).getId();
            if (value.equals("1")) {
                tile.getChildren().get(v).setStyle("-fx-background-color: #2a9d8f;-fx-border-color: #ffffff; -fx-border-width: 1px;");
            } else {
                tile.getChildren().get(v).setStyle("-fx-background-color: #001318;-fx-border-color: #ffffff; -fx-border-width: 1px;");
            }
        }
//        Scene tileScene = new Scene(tile);
        return tile;
    }

    //method to construct button
    public static Button addButton(String value) {
        Button button = new Button();
        button.setId(value);
        button.setMinSize(17.5, 17.5);
        button.setMaxSize(17.5, 17.5);
        button.setStyle("-fx-border-color: #ffffff; -fx-border-width: 1px;");
        button.setShape(new javafx.scene.shape.Circle(17.5));

        return button;
    }
}

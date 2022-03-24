package me.bweloba.gameoflife.components;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.TilePane;
import me.bweloba.gameoflife.logic.Grid;
import me.bweloba.gameoflife.models.TilePaneModel;

public class PlayGrid {

    private static final Grid grids = new Grid();
    static TilePaneModel tilePaneModel = new TilePaneModel();
    static TilePane tile = tilePaneModel.getTile();

    double spawnFactor = 0.6;

    @FXML
    public Slider spawnSlider;

    public void initialize() {

        spawnSlider.valueProperty().addListener((observable, oldValue, newValue) -> spawnFactor = newValue.doubleValue());
    }


    public PlayGrid() {
//        this.spawnSlider.setValue(spawnFactor);
        int[][] grid = grids.generateRandomGrid(spawnFactor);
        updateTilePaneWithGrid(grid, tile);
    }


    public static TilePane addTilePane() {
        return PlayGrid.tile;
    }

    private static void updateTilePaneWithGrid(int[][] grid, TilePane tile) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    tile.getChildren().add(addButton(i + "," + j + "," + "1"));
                } else {
                    tile.getChildren().add(addButton(i + "," + j + "," + "0"));
                }
            }
        }
        setCellColor(tile);
    }


    private static void setCellColor(TilePane tile) {
        for (int v = 0; v < tile.getChildren().size(); v++) {
            String val = tile.getChildren().get(v).getId();
//            System.out.println(val);
            String value = val.substring(val.lastIndexOf(",") + 1);
//            System.out.println(value);
            if (value.equals("1")) {
                tile.getChildren().get(v).setStyle("-fx-background-color: #2a9d8f;-fx-border-color: #ffffff; -fx-border-width: 1px;");
            } else {
                tile.getChildren().get(v).setStyle("-fx-background-color: #001318;-fx-border-color: #ffffff; -fx-border-width: 1px;");
            }
        }
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

    @FXML
    public void onClearButtonClick() {
        tile.getChildren().clear();
        int[][] grid = grids.generateEmptyGrid();
        updateTilePaneWithGrid(grid, tile);
        System.out.println("Cleared");
    }


    @FXML
    public void onSpawnButtonClick() {
        tile.getChildren().clear();
        int[][] grid = grids.generateRandomGrid(spawnFactor);

        updateTilePaneWithGrid(grid, tile);
        System.out.println("Spawned");
    }
}

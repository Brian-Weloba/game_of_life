package me.bweloba.gameoflife.components;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.layout.TilePane;
import javafx.util.Duration;
import me.bweloba.gameoflife.models.Grid;
import me.bweloba.gameoflife.models.TilePaneModel;

import static me.bweloba.gameoflife.logic.Algorithms.applyConwayRules;
import static me.bweloba.gameoflife.logic.Algorithms.computeNeighbors;

/**
 * @author Brian Weloba
 * @version 1.0
 * <p>
 * This class is the controller for the menu-view.fxml file. And also loads the Grid.
 * @see Grid
 * @see TilePaneModel
 * @see TilePane
 * @since 1.0
 */
public class PlayGrid {

    private static final Grid grids = new Grid();
    static TilePaneModel tilePaneModel = new TilePaneModel();
    static TilePane tile = tilePaneModel.getTile();
    double spawnFactor = 0.6;
    double speedFactor = 0.6;
    double speed;
    static int[][] pGrid = grids.getGrid();

    @FXML
    public Slider spawnSlider;

    @FXML
    public Button startButton;

    @FXML
    public Button stopButton;

    @FXML
    public Slider speedSlider;

    public void initialize() {
        spawnSlider.valueProperty().addListener((observable, oldValue, newValue) -> spawnFactor = newValue.doubleValue());
        speedSlider.valueProperty().addListener((observable, oldValue, newValue) -> speedFactor = newValue.intValue());
    }


    public PlayGrid() {
        int[][] grid = grids.generateRandomGrid(spawnFactor);
        pGrid = grid;
        initializeTilePaneWithGrid(grid, tile);
    }

    public static TilePane addTilePane() {
        return PlayGrid.tile;
    }

    private static void initializeTilePaneWithGrid(int[][] grid, TilePane tile) {
        tile.getChildren().clear();
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
            String value = val.substring(val.lastIndexOf(",") + 1);
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

        button.setOnMouseClicked(event -> {
            String val = button.getId();
            System.out.println(val);
            String[] values = val.split(",");
            int i = Integer.parseInt(values[0]);
            int j = Integer.parseInt(values[1]);
            int k = Integer.parseInt(values[2]);
            int index = i * 62 + j + i;
            Button b = (Button) tile.getChildren().get(index);
            System.out.println("pGrid[" + i + "][" + j + "] = " + k);
            if (k == 1) {
                b.setStyle("-fx-background-color: #001318;-fx-border-color: #ffffff; -fx-border-width: 1px;");
                b.setId(i + "," + j + "," + "0");
                pGrid[i][j] = 0;
            } else {
                b.setStyle("-fx-background-color: #2a9d8f;-fx-border-color: #ffffff; -fx-border-width: 1px;");
                b.setId(i + "," + j + "," + "1");
                pGrid[i][j] = 1;
            }
            System.out.println("outside pGrid[" + i + "][" + j + "] = " + pGrid[i][j]);

            int neighborCount = computeNeighbors(pGrid, i, j);
            System.out.println(neighborCount);


        });
        return button;
    }

    @FXML
    public void onClearButtonClick() {
        for (int i = 0; i < tile.getChildren().size(); i++) {
            Button b = (Button) tile.getChildren().get(i);
            b.setStyle("-fx-background-color: #001318;-fx-border-color: #ffffff; -fx-border-width: 1px;");
            String[] values = b.getId().split(",");
            b.setId(values[0] + "," + values[1] + "," + "0");
        }
        pGrid = grids.generateEmptyGrid();
        System.out.println("Cleared");
    }


    @FXML
    public void onSpawnButtonClick() {
        int[][] grid = grids.generateRandomGrid(spawnFactor);
        pGrid = grid;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++) {
                Button b = (Button) tile.getChildren().get(i * 62 + j + i);
                if (grid[i][j] == 1) {
                    b.setStyle("-fx-background-color: #2a9d8f;-fx-border-color: #ffffff; -fx-border-width: 1px;");
                    b.setId(i + "," + j + "," + "1");
                } else {
                    b.setStyle("-fx-background-color: #001318;-fx-border-color: #ffffff; -fx-border-width: 1px;");
                    b.setId(i + "," + j + "," + "0");
                }
            }
    }

    Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0.2), event -> {

        int[][] nGrid = applyConwayRules(pGrid);
        pGrid = nGrid;
        for (int i = 0; i < nGrid.length; i++)
            for (int j = 0; j < nGrid[i].length; j++) {
                Button b = (Button) tile.getChildren().get(i * 62 + j + i);
                if (nGrid[i][j] == 1) {
                    b.setId(i + "," + j + "," + "1");
                    b.setStyle("-fx-background-color: #2a9d8f;-fx-border-color: #ffffff; -fx-border-width: 1px;");
                } else {
                    b.setId(i + "," + j + "," + "0");
                    b.setStyle("-fx-background-color: #001318;-fx-border-color: #ffffff; -fx-border-width: 1px;");
                }
            }
    }));

    @FXML
    public void onStopButtonClick() {

        if (timeline.getStatus() == Animation.Status.RUNNING) {
            timeline.stop();
        }
        stopButton.setDisable(true);
        startButton.setDisable(false);
        speedSlider.setDisable(false);
    }

    @FXML
    public void onStartButtonClick() {
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        stopButton.setDisable(false);
        startButton.setDisable(true);
        speedSlider.setDisable(true);
    }
}

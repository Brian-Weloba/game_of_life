package me.bweloba.gameoflife.models;

import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;


public class TilePaneModel {
    private  TilePane tile = new TilePane();
    public final Grid grids = new Grid();

    public  TilePaneModel() {
        tile.setPrefColumns(grids.getNumCols());
        tile.setPrefRows(grids.getNumRows());
        tile.setHgap(2);
        tile.setVgap(2);
        tile.alignmentProperty().set(javafx.geometry.Pos.CENTER);
        tile.setPadding(new javafx.geometry.Insets(5, 5, 5, 5));
        this.tile.setBackground(new Background(new BackgroundFill(Color.web("#001318"), null, null)));
        tile.setMinSize((grids.getNumCols() * 15) + (grids.getNumCols() * 2), (grids.getNumRows() * 15) + (grids.getNumRows() * 2));
    }

    public  TilePane getTile() {
        return tile;
    }

    public void setTile(TilePane tile) {
        this.tile = tile;
    }
}

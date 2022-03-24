package me.bweloba.gameoflife.Components;

import javafx.fxml.FXMLLoader;
import me.bweloba.gameoflife.Main;

import java.io.IOException;

public class SplitPaneContainer {
    public static javafx.scene.control.SplitPane addSplitPane() throws IOException {
        javafx.scene.control.SplitPane splitPane = new javafx.scene.control.SplitPane();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu-view.fxml"));
        splitPane.getItems().add(fxmlLoader.load());
        splitPane.getItems().add(PlayGrid.addTilePane());
        return splitPane;
    }
}

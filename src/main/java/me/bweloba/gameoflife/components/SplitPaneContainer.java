package me.bweloba.gameoflife.components;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.SplitPane;
import me.bweloba.gameoflife.Main;

import java.io.IOException;

/**
 * @author Brian Weloba
 * @version 1.0
 * <p>
 * This class is used to load the FXML file for the SplitPane.
 * </p>
 * @see SplitPane
 * @since 1.0
 */
public class SplitPaneContainer {
    /**
     * This method is used to load the FXML file for the SplitPane.
     *
     * @return SplitPane object
     * @throws IOException if the FXML file cannot be loaded
     */
    public static javafx.scene.control.SplitPane addSplitPane() throws IOException {
        javafx.scene.control.SplitPane splitPane = new javafx.scene.control.SplitPane();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("menu-view.fxml"));
        splitPane.getItems().add(fxmlLoader.load());
        splitPane.getItems().add(PlayGrid.addTilePane());
        return splitPane;
    }
}

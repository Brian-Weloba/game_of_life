package me.bweloba.gameoflife;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import me.bweloba.gameoflife.components.SplitPaneContainer;

import java.io.IOException;

/**
 * <p>
 *     Main class of the application.
 *     This class is responsible for initializing the application.
 *     </p>
 * @author Brian Weloba
 * @version 1.0
 * @since 1.0
 * @see Application
 * @see Stage
 * @see Scene
 */
public class Main extends Application {

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }

    /**
     *  The start() method is called after the init() method has returned.
     * @param stage the primary stage for this application
     * @throws IOException if the fxml file could not be loaded
     */
    @Override
    public void start(Stage stage) throws IOException {
        // Make the stage full screen
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        //Disable resizing
        stage.setResizable(false);
        //Set the title
        stage.setTitle("GAME OF LIFE");
        //Add the split pane container to the scene
        Scene scene = new Scene(SplitPaneContainer.addSplitPane());
        //set the scene
        stage.setScene(scene);
        //show the stage
        stage.show();
    }
}
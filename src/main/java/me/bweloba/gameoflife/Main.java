package me.bweloba.gameoflife;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import me.bweloba.gameoflife.components.SplitPaneContainer;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        stage.setX(bounds.getMinX());
        stage.setY(bounds.getMinY());
        stage.setWidth(bounds.getWidth());
        stage.setHeight(bounds.getHeight());
        stage.setResizable(false);
        stage.setTitle("GAME OF LIFE");

        Scene scene = new Scene(SplitPaneContainer.addSplitPane());
        stage.setScene(scene);

        stage.show();
    }
}
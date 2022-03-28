module me.bweloba.gameoflife {
    requires javafx.controls;
    requires javafx.fxml;

    requires javafx.graphics;
    requires javafx.base;

    opens me.bweloba.gameoflife to javafx.fxml;
    exports me.bweloba.gameoflife;
    exports me.bweloba.gameoflife.components;
}
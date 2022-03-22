module me.bweloba.gameoflife {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens me.bweloba.gameoflife to javafx.fxml;
    exports me.bweloba.gameoflife;
}
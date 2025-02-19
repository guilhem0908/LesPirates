module org.l7gui.pirates {
    requires javafx.controls;
    requires javafx.fxml;

    opens org.l7gui.pirates.view to javafx.fxml, javafx.graphics;
    exports org.l7gui.pirates;
}
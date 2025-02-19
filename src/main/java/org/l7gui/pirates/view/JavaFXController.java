package org.l7gui.pirates.view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class JavaFXController {
    @FXML
    private Label welcomeText;

    public void setWelcomeText(String text) {
        welcomeText.setText(text);
    }
}

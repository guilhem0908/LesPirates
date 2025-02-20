package org.l7gui.pirates.view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class JavaFXController {
    private JavaFXView parentView;

    @FXML
    private ImageView welcomeImage;

    @FXML
    private Button startButton;

    @FXML
    private Text welcomeTitle;

    @FXML
    private Text welcomeRules;

    public void setWelcome() {
        welcomeImage.setVisible(true);
        startButton.setVisible(true);
        welcomeTitle.setVisible(true);
        welcomeRules.setVisible(true);
    }

    public void setParentView(JavaFXView view) {
        this.parentView = view;
    }

    @FXML
    public void onStartButtonClick() {
        if (parentView != null) {
            parentView.welcomeButtonPressed();
        }
    }
}

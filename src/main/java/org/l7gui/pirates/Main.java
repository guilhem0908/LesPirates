package org.l7gui.pirates;

import org.l7gui.pirates.view.IView;
import org.l7gui.pirates.view.ConsoleView;
import org.l7gui.pirates.view.JavaFXView;
import org.l7gui.pirates.model.GameModel;
import org.l7gui.pirates.controller.GameController;

public class Main {
    public static void main(String[] args) {
        // Mode GUI
        JavaFXView.launchJavaFX();
        IView view = new JavaFXView();
        // Mode Console
        // IView view = new ConsoleView();
        GameModel model = new GameModel();
        GameController controller = new GameController(view, model);
        controller.start();
    }
}
package org.l7gui.pirates.view;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.CountDownLatch;

public class JavaFXView implements IView {
    private static Stage stage;
    private static final CountDownLatch stageLatch = new CountDownLatch(1);
    private JavaFXController controller;

    public JavaFXView() {
        try {
            stageLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Platform.runLater(() -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("view.fxml"));
                Parent root = fxmlLoader.load();
                controller = fxmlLoader.getController();
                Scene scene = new Scene(root, 320, 240);
                stage.setTitle("Jeu des Pirates");
                stage.setScene(scene);
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public static void launchJavaFX() {
        new Thread(() -> Application.launch(JavaFXStarter.class)).start();
        try {
            stageLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void displayWelcome() {
        Platform.runLater(() -> {
            if (controller != null) {
                controller.setWelcomeText("🦜 Bienvenue dans le jeu des Pirates 🏴‍☠️");
            }
        });
    }

    @Override
    public String getPlayerName(int playerNumber) {
        final String[] name = new String[1];
        CountDownLatch latch = new CountDownLatch(1);
        Platform.runLater(() -> {
            TextInputDialog dialog = new TextInputDialog();
            dialog.setTitle("Nom du joueur");
            dialog.setHeaderText("Entrez le nom du joueur " + playerNumber + " :");
            Optional<String> result = dialog.showAndWait();
            name[0] = result.orElse("");
            latch.countDown();
        });
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return name[0].trim();
    }

    public static class JavaFXStarter extends Application {
        @Override
        public void start(Stage stage) {
            JavaFXView.stage = stage;
            stageLatch.countDown();
        }
    }
}

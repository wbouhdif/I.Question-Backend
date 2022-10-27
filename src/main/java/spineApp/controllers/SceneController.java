package spineApp.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;

public class SceneController {
    public static void switchScene(String fxmlFile) {
        Stage stage = (Stage) javafx.stage.Window.getWindows().get(0);

        try {
            Scene newScene = new Scene(FXMLLoader.load(Paths.get("./src/main/resources/fxml/" + fxmlFile).toUri().toURL()));
            stage.setScene(newScene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

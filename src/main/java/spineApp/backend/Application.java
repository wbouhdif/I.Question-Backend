package spineApp.backend;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;

@SpringBootApplication
public class Application extends javafx.application.Application {
    public void start(Stage stage) {
        try {
            URL url = Paths.get("./src/main/resources/fxml/LoginScreen.fxml").toUri().toURL();
            Parent root = FXMLLoader.load(url);
            stage.setTitle("iQuestion");
            stage.setScene(new javafx.scene.Scene(root));
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String args[]) {
        launch();
    }
}
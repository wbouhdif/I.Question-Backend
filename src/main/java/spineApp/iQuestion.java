package spineApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
@SpringBootApplication

public class iQuestion extends Application {
    public void start(Stage stage) {
        try {
            URL url = Paths.get("./src/main/resources/fxml/questionnaireEditor.fxml").toUri().toURL();
            Parent root = FXMLLoader.load(url);
            stage.setTitle("iQuestion");
            stage.setScene(new javafx.scene.Scene(root));
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String args[]) {
        SpringApplication.run(iQuestion.class, args);

        launch();
    }
}
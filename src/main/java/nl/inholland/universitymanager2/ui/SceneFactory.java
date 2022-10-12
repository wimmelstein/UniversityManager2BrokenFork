package nl.inholland.universitymanager2.ui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import nl.inholland.universitymanager2.Application;

import java.io.IOException;

public class SceneFactory {

    private SceneFactory() {
    }

    public static Scene initScene(String fileName, Object controller) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(fileName));
        fxmlLoader.setController(controller);
        return new Scene(fxmlLoader.load());
    }
}

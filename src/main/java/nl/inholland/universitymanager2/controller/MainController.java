package nl.inholland.universitymanager2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import nl.inholland.universitymanager2.Application;
import nl.inholland.universitymanager2.data.Database;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    HBox layout;

    Database database;

    public void loadScene(String name, Object controller) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource(name));
            fxmlLoader.setController(controller);
            Scene scene = new Scene(fxmlLoader.load());
            if (layout.getChildren().size() > 1)
                layout.getChildren().remove(1);
            layout.getChildren().add(scene.getRoot());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void OnStudentButtonClick(ActionEvent event) {
        loadScene("student-list-view.fxml", new StudentListController(database));
    }

    public void OnTeacherButtonClick(ActionEvent event) {
        loadScene("teacher-list-view.fxml", new TeacherListController(database));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        database = new Database();
        loadScene("student-list-view.fxml", new StudentListController(database));
    }
}

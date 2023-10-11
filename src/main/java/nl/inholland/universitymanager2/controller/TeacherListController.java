package nl.inholland.universitymanager2.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import nl.inholland.universitymanager2.data.Database;
import nl.inholland.universitymanager2.model.Teacher;

import java.net.URL;
import java.util.ResourceBundle;

public class TeacherListController implements Initializable {

    @FXML
    TableView teacherTableView;

    private Database database;

    public TeacherListController(Database database) {
        this.database = database;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Teacher> teachers = FXCollections.observableArrayList(database.getTeachers());
        teacherTableView.setItems(teachers);
    }
}

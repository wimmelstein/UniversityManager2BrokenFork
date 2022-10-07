package nl.inholland.universitymanager2.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import nl.inholland.universitymanager2.data.Database;
import nl.inholland.universitymanager2.model.Group;
import nl.inholland.universitymanager2.model.Student;

import java.net.URL;
import java.util.ResourceBundle;

public class StudentDialogController implements Initializable {

    @FXML
    ComboBox groupComboBox;
    @FXML
    TextField firstNameField;
    @FXML
    TextField lastNameField;
    @FXML
    TextField emailField;

    Database database;

    public Student getStudent() {
        return student;
    }

    Student student;

    public StudentDialogController(Database database) {
        this.database = database;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<Group> groups = FXCollections.observableArrayList(database.getGroups());
        groupComboBox.setItems(groups);
    }


    public void onCancelClick(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void onAddClick(ActionEvent event) {
        student = new Student(firstNameField.getText(), lastNameField.getText(), emailField.getText(), (Group) groupComboBox.getValue());
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }
}

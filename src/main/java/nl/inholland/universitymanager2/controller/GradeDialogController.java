package nl.inholland.universitymanager2.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import nl.inholland.universitymanager2.model.Grade;

import java.net.URL;
import java.util.ResourceBundle;

public class GradeDialogController implements Initializable {

    @FXML
    TextField courseField;

    @FXML
    TextField gradeField;

    private Grade grade;

    public Grade getGrade() {
        return grade;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void onCancelClick(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void onAddClick(ActionEvent event) {
        grade = new Grade(courseField.getText(), Double.parseDouble(gradeField.getText()));
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }
}

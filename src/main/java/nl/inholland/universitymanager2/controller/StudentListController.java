package nl.inholland.universitymanager2.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import nl.inholland.universitymanager2.Application;
import nl.inholland.universitymanager2.data.Database;
import nl.inholland.universitymanager2.model.Grade;
import nl.inholland.universitymanager2.model.Student;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentListController implements Initializable {

    @FXML
    TableView studentTableView;
    @FXML
    TableView gradeTableView;
    @FXML
    TableColumn<Student, String> coachColumn;

    private Database database;
    private ObservableList<Student> students;
    private Student selectedStudent;

    public StudentListController(Database database) {
        this.database = database;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        students = FXCollections.observableArrayList(database.getStudents());

        studentTableView.setItems(students);
    }

    public void onAddStudentClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("student-dialog-view.fxml"));
            StudentDialogController studentDialogController = new StudentDialogController(database);
            fxmlLoader.setController(studentDialogController);
            Scene scene = new Scene(fxmlLoader.load());

            Stage dialog = new Stage();
            dialog.setScene(scene);
            dialog.setTitle("Add student");
            dialog.showAndWait();

            if (studentDialogController.getStudent() != null) {
                students.add(studentDialogController.getStudent());
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onAddGradeClick(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("grade-dialog-view.fxml"));
            GradeDialogController gradeDialogController = new GradeDialogController();
            fxmlLoader.setController(gradeDialogController);
            Scene scene = new Scene(fxmlLoader.load());

            Stage dialog = new Stage();
            dialog.setScene(scene);
            dialog.setTitle("Add grade");
            dialog.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

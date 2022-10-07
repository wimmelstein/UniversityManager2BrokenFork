module nl.inholland.universitymanager2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens nl.inholland.universitymanager2 to javafx.fxml;
    exports nl.inholland.universitymanager2;
    exports nl.inholland.universitymanager2.controller;
    opens nl.inholland.universitymanager2.controller to javafx.fxml;

    exports nl.inholland.universitymanager2.model;
    opens nl.inholland.universitymanager2.model to javafx.fxml;
}
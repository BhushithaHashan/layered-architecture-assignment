package org.example.schoolmanagement.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.example.schoolmanagement.util.StudentMarks;

public class ViewMarks {

    // ComboBox for selecting class, subject, term, and year
    @FXML
    private ComboBox<String> classlist;

    @FXML
    private ComboBox<String> subject;

    @FXML
    private ComboBox<String> term;

    @FXML
    private ComboBox<String> year;



    @FXML
    private Button home;
    @FXML
    private Button logout;
    @FXML
    private Button resetBtn;
    @FXML
    private Button seeMarksBtn;

    // TableView to display student marks
    @FXML
    private TableView<StudentMarks> table;

    // Columns to display student name and marks
    @FXML
    private TableColumn<StudentMarks, String> nameCol;
    @FXML
    private TableColumn<StudentMarks, Integer> marksCol;

    // Event handler methods
    @FXML
    public void initialize(){

    }
    @FXML
    void goToHome(ActionEvent event) {
        // Implement logic for navigating to home
    }

    @FXML
    void logOut(ActionEvent event) {
        // Implement logic for logging out
    }

    @FXML
    void reset(ActionEvent event) {
        // Implement reset functionality (clear selections, reset table, etc.)
    }

    @FXML
    void seeMarks(ActionEvent event) {
        // Implement logic to fetch and display marks based on selected class, subject, year, and term
    }
}

package org.example.schoolmanagement.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.schoolmanagement.dto.Student;
import org.example.schoolmanagement.model.StudentModel;

import java.io.IOException;
import java.sql.Date;

public class NewUpdateStudentController {

    @FXML
    private Button classroom;

    @FXML
    private TextField dob;

    @FXML
    private TextField firstname;

    @FXML
    private Button home;

    @FXML
    private TextField lastname;

    @FXML
    private Button logout;

    @FXML
    private Button mails;

    @FXML
    private Button perent;

    @FXML
    private Button resetBtn;

    @FXML
    private Button student;

    @FXML
    private TextField studentId;

    @FXML
    private Button updateBtn;

    @FXML
    private Button user;

    @FXML
    void goToClass(ActionEvent event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/view/newClassPanel.fxml"));
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
            currentStage.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void goToHome(ActionEvent event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/view/newAdminDash.fxml"));
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
            currentStage.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void goToMails(ActionEvent event) {

    }

    @FXML
    void goToPerent(ActionEvent event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/view/newPerentView.fxml"));
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
            currentStage.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void goToStudent(ActionEvent event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/view/newStudentPanel.fxml"));
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
            currentStage.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void goToUser(ActionEvent event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/view/newUserPanel.fxml"));
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
            currentStage.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void logOut(ActionEvent event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/view/loginPage.fxml"));
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
            currentStage.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void reset(ActionEvent event) {
        studentId.clear();
        firstname.clear();
        lastname.clear();
        dob.clear();
    }

    @FXML
    void update(ActionEvent event) {
        // Get input values
        String studentIdText = studentId.getText();
        String firstName = firstname.getText();
        String lastName = lastname.getText();
        String birthday = dob.getText();
        StudentModel studentModel = new StudentModel();
        // Validate Student ID (check if it's a valid integer and exists in the database)
        if (studentIdText.isEmpty() || !studentIdText.matches("\\d+")) {
            showAlert("Invalid Input", "Please enter a valid student ID.", Alert.AlertType.ERROR);
            return;
        }
        int id = Integer.parseInt(studentIdText);

        // Validate that student exists in the database
        if (!studentModel.isStudentExist(id)) {
            showAlert("Student Not Found", "No student found with ID: " + id, Alert.AlertType.ERROR);
            return;
        }

        // Validate first name and last name (ensure they are non-empty)
        if (firstName.trim().isEmpty()) {
            showAlert("Invalid Input", "First name cannot be empty.", Alert.AlertType.ERROR);
            return;
        }
        if (lastName.trim().isEmpty()) {
            showAlert("Invalid Input", "Last name cannot be empty.", Alert.AlertType.ERROR);
            return;
        }

        // Validate Date of Birth (ensure it's in the correct format)
        if (birthday.trim().isEmpty()) {
            showAlert("Invalid Input", "Date of Birth cannot be empty.", Alert.AlertType.ERROR);
            return;
        }

        try {
            Date.valueOf(birthday);  // Will throw IllegalArgumentException if the date format is incorrect
        } catch (IllegalArgumentException e) {
            showAlert("Invalid Input", "Please enter a valid date of birth in the format YYYY-MM-DD.", Alert.AlertType.ERROR);
            return;
        }

        // If all validations pass, update the student
        Student student1 = new Student();
        student1.setDob(Date.valueOf(birthday));
        student1.setFirstName(firstName);
        student1.setLastName(lastName);
        student1.setStudentID(id);



        studentModel.updateStudent(student1);

        showAlert("Success", "Student details updated successfully!", Alert.AlertType.INFORMATION);
        studentId.clear();
        firstname.clear();
        lastname.clear();
        dob.clear();
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.getDialogPane().setStyle("-fx-background-color: #f4f4f9; -fx-font-family: 'Arial'; -fx-font-size: 14px;");
        alert.setHeaderText("");
        alert.setContentText(message);
        alert.showAndWait();
    }


}

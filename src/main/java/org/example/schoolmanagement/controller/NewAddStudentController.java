package org.example.schoolmanagement.controller;

import com.mysql.cj.exceptions.NumberOutOfRange;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.schoolmanagement.dto.Parent;
import org.example.schoolmanagement.dto.Student;
import org.example.schoolmanagement.model.ClassModel;
import org.example.schoolmanagement.model.StudentModel;
import org.example.schoolmanagement.util.DBConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;

public class NewAddStudentController {

    @FXML
    private Button addStudent;

    @FXML
    private Button classroom;

    @FXML
    private TextField dob;

    @FXML
    private TextField email;

    @FXML
    private TextField firstnamefield;

    @FXML
    private TextField firstnameparent;

    @FXML
    private Button home;

    @FXML
    private TextField lastnamefieldstudent;

    @FXML
    private TextField lastnameperent;

    @FXML
    private TextField grade;

    @FXML
    private TextField classname;

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
    private Button user;

    @FXML
    void goToClass(ActionEvent event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            javafx.scene.Parent root = FXMLLoader.load(getClass().getResource("/view/newClassPanel.fxml"));
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
            javafx.scene.Parent root = FXMLLoader.load(getClass().getResource("/view/newAdminDash.fxml"));
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
            javafx.scene.Parent root = FXMLLoader.load(getClass().getResource("/view/newPerentView.fxml"));
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
            javafx.scene.Parent root = FXMLLoader.load(getClass().getResource("/view/newStudentPanel.fxml"));
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
            javafx.scene.Parent root = FXMLLoader.load(getClass().getResource("/view/newUserPanel.fxml"));
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
            javafx.scene.Parent root = FXMLLoader.load(getClass().getResource("/view/loginPage.fxml"));
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
            currentStage.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void reset(ActionEvent event) {
        firstnamefield.clear();
        lastnamefieldstudent.clear();
        lastnameperent.clear();
        firstnameparent.clear();
        dob.clear();
        email.clear();
        grade.clear();
        classname.clear();
    }

    @FXML
    void viewPerent(ActionEvent event) {
        // Get the values entered in the fields
        ClassModel classModel = new ClassModel();
        String studentFirstName = firstnamefield.getText().trim();
        String studentLastName = lastnamefieldstudent.getText().trim();
        String studentDob = dob.getText().trim();
        String parentFirstName = firstnameparent.getText().trim();
        String parentLastName = lastnameperent.getText().trim();
        String parentEmail = email.getText().trim();
        String className= grade.getText().trim()+classname.getText().trim();


        // Validate empty fields
        if (studentFirstName.isEmpty() || studentLastName.isEmpty() || studentDob.isEmpty() ||
                parentFirstName.isEmpty() || parentLastName.isEmpty() || parentEmail.isEmpty()) {
            showAlert("Empty Fields", "All fields must be filled out.", Alert.AlertType.ERROR);
            return;
        }
        int studentGrade;
        try{
            studentGrade = Integer.parseInt(grade.getText());
            if(studentGrade<0 && studentGrade>11){
                showAlert("Invalid Grade","grade must be an integer between 1 & 11", Alert.AlertType.ERROR);
                return;
            }
        }catch (NumberOutOfRange e){
            e.printStackTrace();
            showAlert("Invalid Grade","grade must be an integer between 1 & 11", Alert.AlertType.ERROR);
            return;
        }
        if (!classname.getText().matches("^[A-Z]$")) {
            showAlert("Invalid Class Name", "Class name must be a single uppercase letter.", Alert.AlertType.ERROR);
            return;
        }


        Date studentDobDate;
        try {
            studentDobDate = Date.valueOf(studentDob);
        } catch (IllegalArgumentException e) {
            showAlert("Invalid Date", "Date of Birth must be in the format yyyy-MM-dd.", Alert.AlertType.ERROR);
            return;
        }

        // Check for future dates
        if (studentDobDate.after(new java.util.Date())) {
            showAlert("Invalid Date", "Date of Birth cannot be in the future.", Alert.AlertType.ERROR);
            return;
        }

        // Validate email format
        if (!parentEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")) {
            showAlert("Invalid Email", "Please enter a valid email address.", Alert.AlertType.ERROR);
            return;
        }


        if (studentFirstName.length() > 50 || studentLastName.length() > 50 ||
                parentFirstName.length() > 50 || parentLastName.length() > 50) {
            showAlert("Input Too Long", "Names should not exceed 50 characters.", Alert.AlertType.ERROR);
            return;
        }
        if(classModel.getClassIdByName(className)==null){
            showAlert("Invalid Class Name", "Please enter a valid class Name.", Alert.AlertType.ERROR);
            return;
        }


        Student student = new Student();
        student.setFirstName(studentFirstName);
        student.setLastName(studentLastName);
        student.setDob(studentDobDate);

        Parent parent = new Parent();
        parent.setFirstName(parentFirstName);
        parent.setLastName(parentLastName);
        parent.setEmail(parentEmail);


        StudentModel studentModel = new StudentModel();
        if (studentModel.addStudentTransaction(student, parent,className)) {
            showAlert("Success", "Student and Parent added successfully.", Alert.AlertType.INFORMATION);
        } else {
            showAlert("Failure", "Unable to add Student and Parent. Please check the details.", Alert.AlertType.ERROR);
        }

        // Clear input fields
        firstnamefield.clear();
        lastnamefieldstudent.clear();
        lastnameperent.clear();
        firstnameparent.clear();
        dob.clear();
        email.clear();
        classname.clear();
        grade.clear();
    }


    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.getDialogPane().setStyle("-fx-background-color: #f4f4f9; -fx-font-family: 'Arial'; -fx-font-size: 14px;");

        alert.setHeaderText("Adding Student");
        alert.setContentText(message);
        alert.showAndWait();
    }


}

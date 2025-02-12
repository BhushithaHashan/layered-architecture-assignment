package org.example.schoolmanagement.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.Parent;

import java.io.IOException;

public class AdminDashController {

    @FXML
    private Button attendance;

    @FXML
    private Button classroom;

    @FXML
    private Button exam;

    @FXML
    private Button home;

    @FXML
    private Button logout;

    @FXML
    private Button mails;

    @FXML
    private Button perent;

    @FXML
    private Button schedule;

    @FXML
    private Button student;

    @FXML
    private Button subject;

    @FXML
    private Button teacher;

    @FXML
    private Button user;

    @FXML
    void goToAttendance(ActionEvent event) {

    }

    @FXML
    void goToClass(ActionEvent event) {

    }

    @FXML
    void goToExam(ActionEvent event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root= FXMLLoader.load(getClass().getResource("/view/examRecordPanel.fxml"));
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
            currentStage.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void goToHome(ActionEvent event) {

    }

    @FXML
    void goToMails(ActionEvent event) {

    }

    @FXML
    void goToPerent(ActionEvent event) {

    }

    @FXML
    void goToStudent(ActionEvent event) {

    }

    @FXML
    void goToSubject(ActionEvent event) {

    }

    @FXML
    void goToTeacher(ActionEvent event) {

    }

    @FXML
    void goToUser(ActionEvent event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/view/userServicePanelAdmin.fxml"));
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
            currentStage.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void goToschedule(ActionEvent event) {

    }

    @FXML
    void logOut(ActionEvent event) {

    }

}


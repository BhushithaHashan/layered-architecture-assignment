package org.example.schoolmanagement.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class TeacherDashController {

    @FXML
    private Button attendance;

    @FXML
    private Button exam;

    @FXML
    private Button home;

    @FXML
    private Button logout;

    @FXML
    private Button perent;

    @FXML
    private Button student;

    @FXML
    void goToAttendance(ActionEvent event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root= FXMLLoader.load(getClass().getResource("/view/attendanceServicePanelTeacher.fxml"));
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
            currentStage.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
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
    void goToPerent(ActionEvent event) {

    }

    @FXML
    void goToStudent(ActionEvent event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root= FXMLLoader.load(getClass().getResource("/view/studentServicePanelTeacher.fxml"));
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
            currentStage.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void logOut(ActionEvent event) {

    }

}


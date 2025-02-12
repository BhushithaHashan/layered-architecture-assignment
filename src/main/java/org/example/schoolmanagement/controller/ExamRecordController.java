
package org.example.schoolmanagement.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import org.example.schoolmanagement.dto.Student;
import org.example.schoolmanagement.dto.ExamDto;
import org.example.schoolmanagement.dto.ClassDTO;
import org.example.schoolmanagement.dto.ExamRecordDTO;
import org.example.schoolmanagement.dto.TermDTO;
import org.example.schoolmanagement.dto.SubjectDTO;


public class ExamRecordController{

    @FXML
    private Button attendance;

    @FXML
    private Button deleteMarksBtn;

    @FXML
    private Button editMarksBtn;

    @FXML
    private Button exam;

    @FXML
    private Button home;

    @FXML
    private Button logout;

    @FXML
    private Button perent;

    @FXML
    private Button setMarksBtn;

    @FXML
    private Button student;

    @FXML
    private Button viewMarksBtn;

    @FXML
    void deleteMarks(ActionEvent event) {

    }

    @FXML
    void editMarks(ActionEvent event) {

    }

    @FXML
    void goToAttendance(ActionEvent event) {

    }

    @FXML
    void goToExam(ActionEvent event) {
        System.out.println("already in exam bro");
    }

    @FXML
    void goToHome(ActionEvent event) {

    }

    @FXML
    void goToPerent(ActionEvent event) {

    }

    @FXML
    void goToStudent(ActionEvent event) {

    }

    @FXML
    void logOut(ActionEvent event) {

    }

    @FXML
    void setMarks(ActionEvent event) {

    }

    @FXML
    void viewMarks(ActionEvent event) {

    }

}

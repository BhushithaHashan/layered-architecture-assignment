package org.example.schoolmanagement.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.schoolmanagement.dto.Student;
import org.example.schoolmanagement.dto.UserDTO;
import org.example.schoolmanagement.model.StudentModel;
import org.example.schoolmanagement.model.UserModel;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class NewStudentViewController implements Initializable {

    @FXML
    private Button classroom;

    @FXML
    private TableColumn<Student, String> dob;

    @FXML
    private TableColumn<Student,String> firstName;

    @FXML
    private Button home;

    @FXML
    private TableColumn<Student, String> lastName;

    @FXML
    private Button logout;

    @FXML
    private Button mails;

    @FXML
    private Button perent;

    @FXML
    private TableColumn<Student, Integer> sid;

    @FXML
    private TableColumn<Student,Integer> regDate;

    @FXML
    private Button student;

    @FXML
    private Button user;

    @FXML
    private TableView<Student> userTable;

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

    private StudentModel studentModel;
    private ObservableList<Student> oblist;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        studentModel = new StudentModel();
        List<Student> list = studentModel.getAllStudents();
        oblist = FXCollections.observableArrayList(list);
        sid.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        dob.setCellValueFactory(new PropertyValueFactory<>("dob"));
        regDate.setCellValueFactory(new PropertyValueFactory<>("registeredDate"));

        userTable.setItems(oblist);


    }
}

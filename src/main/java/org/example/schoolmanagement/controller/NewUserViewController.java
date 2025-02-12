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
import org.example.schoolmanagement.dto.UserDTO;
import org.example.schoolmanagement.model.UserModel;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class NewUserViewController implements Initializable {

    @FXML
    private Button classroom;

    @FXML
    private Button home;

    @FXML
    private TableColumn<UserDTO, Integer> id;

    @FXML
    private Button logout;

    @FXML
    private TableColumn<UserDTO, String> mail;

    @FXML
    private Button mails;

    @FXML
    private TableColumn<UserDTO, String> name;

    @FXML
    private TableColumn<UserDTO, String> pass;

    @FXML
    private Button perent;

    @FXML
    private Button student;

    @FXML
    private Button user;

    @FXML
    private TableView<UserDTO> userTable;

    private UserModel userModel;
    private ObservableList<UserDTO> oblist;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize the UserModel and fetch users
        userModel = new UserModel();
        List<UserDTO> list = userModel.getAllUsers();
        oblist = FXCollections.observableArrayList(list);

        // Set up the table columns to map to UserDTO properties
        id.setCellValueFactory(new PropertyValueFactory<>("userId"));
        name.setCellValueFactory(new PropertyValueFactory<>("username"));
        mail.setCellValueFactory(new PropertyValueFactory<>("email"));
        pass.setCellValueFactory(new PropertyValueFactory<>("password"));

        // Set the table items
        userTable.setItems(oblist);

    }

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

        System.out.println("Navigating to Mails view...");
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
}

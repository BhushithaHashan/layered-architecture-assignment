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
import org.example.schoolmanagement.model.ParentModel;


import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class NewPerentViewController implements Initializable {

    @FXML
    private TableColumn<org.example.schoolmanagement.dto.Parent, String> LastName;

    @FXML
    private Button classroom;

    @FXML
    private TableColumn<org.example.schoolmanagement.dto.Parent, String> firstName;

    @FXML
    private Button home;

    @FXML
    private Button logout;

    @FXML
    private TableColumn<org.example.schoolmanagement.dto.Parent, String> mail;

    @FXML
    private Button mails;

    @FXML
    private Button perent;

    @FXML
    private TableColumn<org.example.schoolmanagement.dto.Parent, Integer> perentID;

    @FXML
    private TableView<org.example.schoolmanagement.dto.Parent> perentTable;

    @FXML
    private Button student;

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
            e.printStackTrace();
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
        System.out.println("perent");

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

    private ParentModel parentModel;
    private ObservableList<org.example.schoolmanagement.dto.Parent> oblist;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        parentModel = new ParentModel();

        List<org.example.schoolmanagement.dto.Parent> list = parentModel.getAllParents();


        oblist = FXCollections.observableArrayList(list);
        perentID.setCellValueFactory(new PropertyValueFactory<>("parentId"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        LastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        mail.setCellValueFactory(new PropertyValueFactory<>("email"));

        perentTable.setItems(oblist);


    }
}

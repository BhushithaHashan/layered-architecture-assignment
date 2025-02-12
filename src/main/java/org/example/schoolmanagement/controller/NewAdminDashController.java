
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
import org.example.schoolmanagement.dto.Event;
import org.example.schoolmanagement.dto.Student;
import org.example.schoolmanagement.model.EventModel;
import org.example.schoolmanagement.model.StudentModel;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class NewAdminDashController implements Initializable {

    @FXML
    private Button classroom;

    @FXML
    private TableColumn<Event, String> event;

    @FXML
    private TableColumn<Event, Integer> eventid;

    @FXML
    private TableView<Event> eventlog;

    @FXML
    private Button home;

    @FXML
    private Button logout;

    @FXML
    private Button mails;

    @FXML
    private Button perent;

    @FXML
    private Button student;

    @FXML
    private TableColumn<Event, String> time;

    @FXML
    private Button user;

    @FXML
    private TableColumn<Event, Integer> userid;

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
        System.out.println("Home");
    }


    @FXML
    void goToMails(ActionEvent event) {
        System.out.println("mail");
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/view/newSendMailByparent.fxml"));
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
            currentStage.show();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
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
            e.printStackTrace();
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

    private EventModel eventModel;
    private ObservableList<Event> oblist;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        eventModel = new EventModel();
        List<Event> list = eventModel.getAllEvents();
        oblist = FXCollections.observableArrayList(list);
        userid.setCellValueFactory(new PropertyValueFactory<>("userId"));
        eventid.setCellValueFactory(new PropertyValueFactory<>("eventId"));
        event.setCellValueFactory(new PropertyValueFactory<>("eventType"));
        time.setCellValueFactory(new PropertyValueFactory<>("eventTime"));


        eventlog.setItems(oblist);


    }

}


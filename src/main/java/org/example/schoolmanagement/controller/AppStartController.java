package org.example.schoolmanagement.controller;

import java.io.IOException;

import javafx.scene.Node;
import org.example.schoolmanagement.model.UserModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AppStartController {

    @FXML
    private void appInitialize(ActionEvent event) {
        UserModel userModel = new UserModel();


        if (userModel.getAllUsers().isEmpty()) {

            loadFXML("RegisterFirstUser.fxml",event);
        } else {

            loadFXML("loginPage.fxml",event);
        }
    }

    private void loadFXML(String fxmlFileName,ActionEvent event) {
        try {
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/view/"+fxmlFileName));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            currentStage.setScene(scene);
            currentStage.centerOnScreen();

            currentStage.show();

        } catch (IOException e) {

            System.out.println(e.getMessage());
            showError("Error", "Unable to load the page. Please try again later.");
        }
    }

    private void showError(String title, String message) {

        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}

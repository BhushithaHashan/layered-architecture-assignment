package org.example.schoolmanagement.controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import org.example.schoolmanagement.dto.UserDTO;
import org.example.schoolmanagement.model.UserModel;
import org.example.schoolmanagement.util.Role;

import java.io.IOException;
import java.util.regex.Pattern;

public class RegisterFirstUserController{

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private Label email;

    @FXML
    private TextField emailField;

    @FXML
    private Label name;

    @FXML
    private TextField namefield;

    @FXML
    private Label password;

    @FXML
    private Label passwordConfirm;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Rectangle rectangle;

    @FXML
    private Button signup;

    @FXML
    private Text titleOne;

    @FXML
    private Text titleOne1;

    @FXML
    private Text titleOne11;

    @FXML
    void signUp(ActionEvent event) {
        String userName = namefield.getText();
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirmPass = confirmPasswordField.getText();

        if(userName.isEmpty()||email.isEmpty()||password.isEmpty()||confirmPass.isEmpty()){
            showAlert("Empty Fields Found","Fields Cannot be empty!", AlertType.ERROR);
            passwordField.clear();
            confirmPasswordField.clear();
        }
        String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";


        if(!Pattern.matches(EMAIL_REGEX, email)){
            showAlert("Invalid Email","Enter a valid E-mail!", AlertType.ERROR);
            passwordField.clear();
            confirmPasswordField.clear();
        }
        if(!password.equals(confirmPass)){
            showAlert("Password not match with Comfirm Password","Make sure the Password & Confirm Password fields are matching!", AlertType.ERROR);
            confirmPasswordField.clear();
        }
        try{
            UserDTO user = new UserDTO();
            user.setUsername(userName);
            user.setEmail(email);
            user.setPassword(password);
            user.setRole(Role.ADMIN);
            user.setSpecificAttribute(null);

            UserModel userModel = new UserModel();
            System.out.println(userModel.addUser(user));
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/view/newAdminDash.fxml"));
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
            currentStage.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.getDialogPane().setStyle("-fx-background-color: #f4f4f9; -fx-font-family: 'Arial'; -fx-font-size: 14px;");

        alert.setHeaderText("Sign up failed");
        alert.setContentText(message);
        alert.showAndWait();
    }

}
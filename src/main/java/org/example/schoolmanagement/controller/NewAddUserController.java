package org.example.schoolmanagement.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.schoolmanagement.dto.UserDTO;
import org.example.schoolmanagement.facad.UserFacad;
import org.example.schoolmanagement.facad.UserFacadInterface;
import org.example.schoolmanagement.model.UserModel;
import org.example.schoolmanagement.service.ServiceFactory;
import org.example.schoolmanagement.service.ValidatorInterface;
import org.example.schoolmanagement.util.Role;
import org.example.schoolmanagement.util.SERVICES;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class NewAddUserController {

    @FXML
    private Button addBtn;

    @FXML
    private Button classroom;

    @FXML
    private TextField confirmPassField;

    @FXML
    private TextField email;

    @FXML
    private Button home;

    @FXML
    private Button logout;

    @FXML
    private Button mails;

    @FXML
    private TextField name;

    @FXML
    private TextField pass;

    @FXML
    private Button perent;

    @FXML
    private Button resetBtn;

    @FXML
    private Button student;

    @FXML
    private Button user;

    private UserFacadInterface userFacad = new UserFacad();
    private ValidatorInterface validator = ServiceFactory.getService(SERVICES.VALIDATESERVICE, null, null);

    @FXML
    void addUsr(ActionEvent event) {
        String userName = name.getText();
        String userMail = email.getText();
        String password = pass.getText();
        String confirmPass = confirmPassField.getText();
        UserDTO user = new UserDTO();
        if(validator.isEmpty(userName)||validator.isEmpty(userMail)||validator.isEmpty(password)||validator.isEmpty(confirmPass)){
            showAlert("Empty Fields Found","Fields Cannot be empty!", Alert.AlertType.ERROR);
            return;
        }
        // if(userName.isEmpty()||userMail.isEmpty()||password.isEmpty()||confirmPass.isEmpty()){
        //     showAlert("Empty Fields Found","Fields Cannot be empty!", Alert.AlertType.ERROR);
        //     pass.clear();
        //     confirmPassField.clear();
        // }
        //String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        if (!validator.validateEmail(userMail)) {
            showAlert("Invalid Email","Enter a valid E-mail!", Alert.AlertType.ERROR);
            return;
        }
        // if(!Pattern.matches(EMAIL_REGEX, userMail)){
        //     showAlert("Invalid Email","Enter a valid E-mail!", Alert.AlertType.ERROR);
        //     pass.clear();
        //     confirmPassField.clear();
        // }
        if (!validator.validatePasswordMatch(password, confirmPass)) {
            showAlert("Password not match with Comfirm Password","Make sure the Password & Confirm Password fields are matching!", Alert.AlertType.ERROR);
            confirmPassField.clear();
            pass.clear();
            return;
        }else{
            user.setUsername(userName);
            user.setEmail(userMail);
            user.setPassword(password);
            user.setRole(Role.ADMIN);
            user.setSpecificAttribute(null);
            if (userFacad.addUser(user)) {
                pass.clear();
                confirmPassField.clear();
                name.clear();
                email.clear();
                showAlert("User Added","user added successfully", Alert.AlertType.ERROR);
            }else{
                showAlert("User Not Added","User Name Already Taken", Alert.AlertType.ERROR);
            }

            
        }

        // if(!password.equals(confirmPass)){
        //     showAlert("Password not match with Comfirm Password","Make sure the Password & Confirm Password fields are matching!", Alert.AlertType.ERROR);
        //     confirmPassField.clear();
        //     pass.clear();
        // }else {
        //     UserDTO user = new UserDTO();
        //     user.setUsername(userName);
        //     user.setEmail(userMail);
        //     user.setPassword(password);
        //     user.setRole(Role.ADMIN);
        //     user.setSpecificAttribute(null);

        //     UserModel userModel = new UserModel();
        //     List<UserDTO> users = userModel.getAllUsers();
        //     for(UserDTO currentuser:users){
        //         if(currentuser.getUsername().equals(user.getUsername())){
        //             showAlert("User Not Added","User Name Already Taken", Alert.AlertType.ERROR);
        //             user = null;
        //             break;
        //         }
        //     }
        //     if(user!=null){
        //         userModel.addUser(user);
        //         showAlert("User Added","user added successfully", Alert.AlertType.ERROR);
        //     }




        // }
    }

    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.getDialogPane().setStyle("-fx-background-color: #f4f4f9; -fx-font-family: 'Arial'; -fx-font-size: 14px;");

        alert.setHeaderText("Register User");
        alert.setContentText(message);
        alert.showAndWait();
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

    @FXML
    void reset(ActionEvent event) {
        name.clear();
        pass.clear();
        pass.clear();
        confirmPassField.clear();

    }

}

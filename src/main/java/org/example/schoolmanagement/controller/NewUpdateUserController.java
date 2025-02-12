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
import org.example.schoolmanagement.service.ValidateService;
import org.example.schoolmanagement.service.ValidatorInterface;
import org.example.schoolmanagement.util.Role;
import org.example.schoolmanagement.util.SERVICES;

import java.io.IOException;
import java.util.regex.Pattern;

public class NewUpdateUserController {

    @FXML
    private Button classroom;

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
    private Button updateBtn;

    @FXML
    private Button user;

    @FXML
    private TextField userid;
    private UserDTO userInstance = new UserDTO();
    private ValidatorInterface validator = ServiceFactory.getService(SERVICES.VALIDATESERVICE, null, null);
    private UserFacadInterface userFacad = new UserFacad();
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
        name.setText("");
        userid.setText("");
        pass.setText("");
        email.setText("");
    }
    UserModel userModel = new UserModel();
    private UserDTO userDTO = new UserDTO();
    
    

    @FXML
    void update(ActionEvent event) {

        userDTO.setRole(Role.ADMIN);
        // String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        // if(pass.getText().isEmpty()||email.getText().isEmpty()||name.getText().isEmpty()||userid.getText().isEmpty()){
        //     showAlert("Update Failed","Fields Cannot Be Empty", Alert.AlertType.ERROR);

        // }
        if(validator.isEmpty(pass.getText())||validator.isEmpty(email.getText())||validator.isEmpty(name.getText())||validator.isEmpty(userid.getText())){
            showAlert("Update Failed","Fields Cannot Be Empty", Alert.AlertType.ERROR);
            return;
        }
        if (!validator.validateEmail(email.getText())) {
            showAlert("Invalid Email","Enter a valid E-mail!", Alert.AlertType.ERROR);
            email.clear();
            return;
        }
        // if(!Pattern.matches(EMAIL_REGEX, email.getText())){
        //     showAlert("Invalid Email","Enter a valid E-mail!", Alert.AlertType.ERROR);
        //     email.clear();
        // }
        int id = -1;
        try{
            id = Integer.parseInt(userid.getText());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
            return;
        }
        String password = pass.getText();
        String mail = email.getText();
        String userName = name.getText();
        System.out.println(user.getText());


        userDTO.setUserId(id);
        userDTO.setPassword(password);
        userDTO.setEmail(mail);
        userDTO.setUsername(userName);
        
        if (userFacad.updateUser(userDTO)) {
            showAlert("Success","Update Successfull", Alert.AlertType.ERROR);
            email.clear();
            pass.clear();
            userid.clear();
            name.clear();
            return;
        }
        else{
            showAlert("Failed","update Failed", Alert.AlertType.ERROR);
            return;
        }
        // if(userModel.updateUser(userDTO)){
        //     showAlert("Success","Update Successfull", Alert.AlertType.ERROR);
        //     email.clear();
        //     pass.clear();
        //     userid.clear();
        //     name.clear();
        // }else{
        //     showAlert("Failed","update Failed", Alert.AlertType.ERROR);
        // }





    }
    private void showAlert(String title, String message, Alert.AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.getDialogPane().setStyle("-fx-background-color: #f4f4f9; -fx-font-family: 'Arial'; -fx-font-size: 14px;");

        alert.setHeaderText("");
        alert.setContentText(message);
        alert.showAndWait();
    }

}

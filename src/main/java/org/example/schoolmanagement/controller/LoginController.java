package org.example.schoolmanagement.controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.example.schoolmanagement.dto.Event;
import org.example.schoolmanagement.dto.UserDTO;
import org.example.schoolmanagement.model.EventModel;
import org.example.schoolmanagement.model.UserModel;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import org.example.schoolmanagement.util.Role;

import java.io.IOException;

public class LoginController {
    @FXML
    private ImageView backgroundImage; // To hold the image in the controller


    @FXML
    private Button forgotPass;

    @FXML
    private Label name;

    @FXML
    private TextField namefield;

    @FXML
    private Label password;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Rectangle rectangle;

    @FXML
    private AnchorPane root;

    @FXML
    private Button signup;

    @FXML
    private Text titleOne;

    @FXML
    private Text titleOne1;

    @FXML
    private Text titleOne11;


    private UserModel userModel = new UserModel();


    @FXML
    void login(ActionEvent event) {
        String username = namefield.getText();
        String password = passwordField.getText();


        if (username.isEmpty() || password.isEmpty()) {
            showAlert("Error", "Username and password must not be empty!", AlertType.ERROR);
            return;
        }


        UserDTO userDTO = userModel.getUserByUsername(username);

        if (userDTO != null && userDTO.getPassword().equals(password)) {

            openMainScreen(userDTO,event);
            Event eventLogger = new Event();
            eventLogger.setEventType("User logged In");
            eventLogger.setUserId(userDTO.getUserId());
            EventModel eventModel =new EventModel();
            eventModel.addEvent(eventLogger);

        } else {

            showAlert("Login Failed", "Invalid username or password.", AlertType.ERROR);
            Event eventLogger = new Event();
            eventLogger.setEventType("Attempt to login failed");
            eventLogger.setUserId(null);
            EventModel eventModel =new EventModel();
            eventModel.addEvent(eventLogger);
        }
    }

    // Show alert message
    private void showAlert(String title, String message, AlertType type) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.getDialogPane().setStyle("-fx-background-color: #f4f4f9; -fx-font-family: 'Arial'; -fx-font-size: 14px;");

        alert.setHeaderText("Login failed");
        alert.setContentText(message);
        alert.showAndWait();
    }


    private void openMainScreen(UserDTO userDTO,ActionEvent event) {

        String fxmlSource;
        if(userDTO.getRole()== Role.ADMIN){
            System.out.println("admin loggedin bro");
             fxmlSource= "newAdminDash.fxml";
        }else{
            fxmlSource="teacherDash.fxml";
        }
        try{
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/view/"+fxmlSource));
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
            currentStage.show();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

    }


    @FXML
    void forgotPassPage(ActionEvent event) {

        System.out.println("Forgot password page opened!");
    }



    
}

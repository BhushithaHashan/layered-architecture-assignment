package org.example.schoolmanagement.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.example.schoolmanagement.dto.EmailByParent;
import org.example.schoolmanagement.model.EmailByParentModel;

import java.awt.event.MouseEvent;
import java.util.List;

public class SendMailByParentController {

    @FXML
    private TextField classfield;

    @FXML
    private Button classroom;

    @FXML
    private TableColumn<EmailByParent, String> email;

    @FXML
    private TextField gradefield;

    @FXML
    private TextField header;

    @FXML
    private Button home;

    @FXML
    private Button logout;

    @FXML
    private Button mails;

    @FXML
    private TextArea message;

    @FXML
    private TableColumn<EmailByParent, String> parentName;

    @FXML
    private Button perent;

    @FXML
    private TableView<EmailByParent> perentTable;

    @FXML
    private TextField recieveraddress;

    @FXML
    private Button search;

    @FXML
    private Button sendEmail;

    @FXML
    private Button student;

    @FXML
    private TableColumn<EmailByParent, String> studentName;

    @FXML
    private Button user;

    @FXML
    void goToClass(ActionEvent event) {

    }

    @FXML
    void goToHome(ActionEvent event) {

    }

    @FXML
    void goToMails(ActionEvent event) {

    }

    @FXML
    void goToPerent(ActionEvent event) {

    }

    @FXML
    void goToStudent(ActionEvent event) {

    }

    @FXML
    void goToUser(ActionEvent event) {

    }

    @FXML
    void logOut(ActionEvent event) {

    }

    @FXML
    void searchParent(ActionEvent event) {
        try {
            // Fetching the data
            EmailByParentModel emailByParentModel = new EmailByParentModel();
            List<EmailByParent> list = emailByParentModel.getParentStudentList(
                    Integer.parseInt(gradefield.getText()), classfield.getText());

            // Logging the result size and contents
            if (list.isEmpty()) {
                System.out.println("No data found for the given grade and section.");
            } else {
                System.out.println("Found " + list.size() + " records.");
                for (EmailByParent emailByParent : list) {
                    System.out.println("Parent: " + emailByParent.getParentName() + ", Student: " + emailByParent.getStudentName());
                }
            }

            // Convert the list to an ObservableList
            ObservableList<EmailByParent> oblist = FXCollections.observableArrayList(list);

            // Set the table columns
            email.setCellValueFactory(new PropertyValueFactory<>("email"));
            parentName.setCellValueFactory(new PropertyValueFactory<>("parentName"));
            studentName.setCellValueFactory(new PropertyValueFactory<>("studentName"));

            // Populate the table
            perentTable.setItems(oblist);

        } catch (NumberFormatException e) {
            // Handle invalid input for gradefield
            System.err.println("Invalid input for gradefield. Please enter a valid number.");
            e.printStackTrace();
        } catch (Exception e) {
            // Catch any other exceptions and print the stack trace
            System.err.println("An error occurred while fetching data:");
            e.printStackTrace();
        }
    }


    @FXML
    void sendmail(ActionEvent event) {

    }
    @FXML
//    void getID(MouseEvent event) {
//
//
//
//    }

    public void getID(javafx.scene.input.MouseEvent mouseEvent) {
        int index = perentTable.getSelectionModel().getSelectedIndex();
        if(index>=0){
            System.out.println("method works");
            recieveraddress.setText(email.getCellData(index).toString());
        }else{
            System.out.println("method not work");
            return;
        }
    }
}

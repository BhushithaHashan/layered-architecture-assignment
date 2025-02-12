package org.example.schoolmanagement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/appStart.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("appStart");
        stage.centerOnScreen();
        stage.show();
    }
}
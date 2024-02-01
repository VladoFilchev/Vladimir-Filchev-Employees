package com.sirmasolutionsinternproject.UI;

import com.sirmasolutionsinternproject.Controller.MainScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainScreen extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        String filePath="/com/view/MainScreenView.fxml";
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(filePath));

            Parent root = fxmlLoader.load();
            stage.setTitle("Employee Table");
            Scene scene = new Scene(root);

            stage.setScene(scene);

            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

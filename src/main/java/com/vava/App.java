package com.vava;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;
public class App extends Application{
    private Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws IOException {
      this.primaryStage = primaryStage;
      reloadScene();
    }

    public void reloadScene() {
        try {
            ResourceBundle resources = ResourceBundle.getBundle("com.vava.bundles.messages");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Localization.fxml"), resources);
            Parent root = loader.load();

            Scene scene = new Scene(root, 1000, 800);
            primaryStage.setScene(scene);

            LocalizationController controller = loader.getController();
            controller.setApp(this); // Pass a reference of App to the controller

            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

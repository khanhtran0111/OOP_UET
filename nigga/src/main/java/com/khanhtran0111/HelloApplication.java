package com.khanhtran0111;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.Group;

import java.io.IOException;

public class HelloApplication extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene  scene = new Scene(root, Color.GREEN);

        stage.setTitle("hello world");
        stage.setScene(scene);
        stage.setWidth(450);
        stage.setHeight(450);
        stage.show();
    }
}   
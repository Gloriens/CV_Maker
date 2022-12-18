package com.example.cv_maker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CV_Maker extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CV_Maker.class.getResource("CV_Maker.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 846, 460);
        stage.setTitle("CV Maker");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
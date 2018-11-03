package com.company.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.slf4j.Logger;

public class MyFxApp extends Application {

    Logger logger;

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("TP2 Algoritmos III");

        Label label = new Label("Age of Empires II");
        Scene scene = new Scene(label, 1200, 600);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}
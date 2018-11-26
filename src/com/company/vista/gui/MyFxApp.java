package com.company.vista.gui;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MyFxApp extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("TP2 Algoritmos III");

        Label label = new Label("Age of Empires II");

        Rectangle rectangle = new Rectangle();
        rectangle.setX(200);
        rectangle.setY(200);
        rectangle.setWidth(200);
        rectangle.setHeight(200);
        Group root = new Group(rectangle);

        Scene scene = new Scene(root, 1200, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}

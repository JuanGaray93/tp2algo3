package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("AOE2");

        Group root = new Group();
        Scene escena = new Scene(root,1200, 600);
        escena.setFill(Color.BROWN);

        primaryStage.setScene(escena);

        Button botonCambiarTurno = new Button("Pasar turno");
        botonCambiarTurno.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("AAAAA");
            }
        });

        root.getChildren().add(botonCambiarTurno);
        primaryStage.show();



    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}
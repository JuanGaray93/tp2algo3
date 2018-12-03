package com.company;

import com.company.vista.gui.ContenedorPrincipal;
import com.company.vista.gui.eventos.CambiarTurnoHandler;
import com.company.vista.terreno.Mapa;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("AOE2");
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(primaryStage);

        Scene escena = new Scene(contenedorPrincipal,1200, 600);
        //Scene escena = new Scene(new Mapa(),1200, 600);
        primaryStage.setScene(escena);

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}
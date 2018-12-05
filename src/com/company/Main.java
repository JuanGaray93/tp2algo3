package com.company;

import com.company.vista.gui.ContenedorPrincipal;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("AOE2");
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(primaryStage);

        Scene escena = new Scene(contenedorPrincipal,1200, 600);
        primaryStage.setScene(escena);

        primaryStage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}

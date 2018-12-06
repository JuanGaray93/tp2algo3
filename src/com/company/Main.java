package com.company;

import com.company.modelo.Partida;
import com.company.vista.gui.ContenedorPrincipal;
import com.company.vista.terreno.MapaView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("AOE2");
        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(primaryStage);

        Scene escena = new Scene(contenedorPrincipal,1200, 600);
        primaryStage.setScene(escena);

        primaryStage.show();
        Partida partida = new Partida();
        try {
            partida.correr();
        } catch (Exception e) {
            e.printStackTrace();
        }

        MapaView mapa = MapaView.getMapa();
        mapa.actualizarCasilleros();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}

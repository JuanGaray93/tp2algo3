package com.company;

import com.company.controlador.Controlador;
import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.modelo.Partida;
import com.company.vista.gui.ContenedorPrincipal;
import com.company.vista.terreno.MapaView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws CasilleroNoExistenteException, CasilleroLlenoException {
        primaryStage.setTitle("AOE2");

        Partida partida = new Partida();

        try {
            partida.correr();
        } catch (Exception e) {
            e.printStackTrace();
        }


        ContenedorPrincipal contenedorPrincipal = new ContenedorPrincipal(primaryStage);
        //generadorDeBotones.establecerContenedor(contenedorPrincipal);


        Scene escena = new Scene(contenedorPrincipal,1200, 600);
        primaryStage.setScene(escena);

        primaryStage.show();


        MapaView mapa = MapaView.getMapa();
        mapa.actualizarCasilleros();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }


}

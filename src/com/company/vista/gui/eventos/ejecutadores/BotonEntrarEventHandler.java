package com.company.vista.gui.eventos.ejecutadores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Scene proximaEscena;
    //MediaPlayer mediaPlayer;
    //MediaPlayer mediaPlayerBatalla;

    public BotonEntrarEventHandler(Stage stage, Scene proximaEscena/*, MediaPlayer mediaPlayer, MediaPlayer mediaPlayerBatalla*/) {
        this.stage = stage;
        this.proximaEscena = proximaEscena;
        // this.mediaPlayer = mediaPlayer;
        //this.mediaPlayerBatalla = mediaPlayerBatalla;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(proximaEscena);

        //mediaPlayer.stop();
        //mediaPlayerBatalla.setAutoPlay(true);
        //mediaPlayerBatalla.setCycleCount(MediaPlayer.INDEFINITE);
        stage.setMaximized(true);
    }
}
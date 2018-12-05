package com.company.vista.gui;

import com.company.vista.gui.eventos.CambiarTurnoHandler;
import com.company.vista.terreno.Mapa;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContenedorPrincipal extends BorderPane {

    BarraDeMenu menuBar;
    Mapa mapa;

    public ContenedorPrincipal(Stage stage){
        Mapa mapa = new Mapa();
        setCenter(mapa);
        setMenu(stage);
        setBotonera();
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    private void setBotonera() {

        Button botonCambiarTurno = new Button("Pasar turno");
        botonCambiarTurno.setOnAction(new CambiarTurnoHandler());

        VBox contenedorVertical = new VBox(botonCambiarTurno);
        contenedorVertical.setSpacing(10);
        contenedorVertical.setPadding(new Insets(15));

        this.setLeft(contenedorVertical);

    }

}

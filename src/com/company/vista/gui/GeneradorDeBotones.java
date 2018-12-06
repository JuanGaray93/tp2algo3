package com.company.vista.gui;

import com.company.DTO.Accion;
import com.company.vista.gui.eventos.CambiarTurnoHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.ArrayList;

public class GeneradorDeBotones {

    private static GeneradorDeBotones instancia;
    private VBox controles = new VBox();

    private ContenedorPrincipal contenedorPrincipal;

    private GeneradorDeBotones(){
        controles.setSpacing(10);
        controles.setPadding(new Insets(15));
    }

    public static GeneradorDeBotones getGenerador() {
        if(instancia == null){
            instancia = new GeneradorDeBotones();
        }
        return instancia;
    }

    public void establecerContenedor(ContenedorPrincipal contenedorPrincipal) {
        this.contenedorPrincipal = contenedorPrincipal;
        contenedorPrincipal.setLeft(controles);
    }

    private Label getLabel(){
        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 18));
        etiqueta.setText("Controles");
        etiqueta.setTextFill(Color.web("#66A7C5"));
        return etiqueta;
    }

    public void generarBotones(ArrayList<Accion> acciones) {
        controles.getChildren().clear();
        generarBotonPasarTurno();
        controles.getChildren().add(getLabel());
        for(Accion accion :acciones){
            Button boton = generarBoton(accion);
            controles.getChildren().add(boton);
        }
    }

    public Button generarBoton(Accion accion){
        Button boton = new Button();
        boton.setText(accion.getDescripcion());
        boton.setOnAction(accion.getHandlerDelBoton());
        boton.setStyle("-fx-base: #394867");
        boton.setTextFill(Color.WHITE);
        return boton;
    }

    public void limpiarBotonera(){
        controles.getChildren().clear();
        contenedorPrincipal.setLeft(controles);
        generarBotonPasarTurno();
    }

    public void generarBotonPasarTurno(){
        Button botonCambiarTurno = new Button("~ ~ Pasar este turno ~ ~");
        botonCambiarTurno.setOnAction(new CambiarTurnoHandler());
        controles.getChildren().add(botonCambiarTurno);
    }
}

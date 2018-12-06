package com.company.vista.gui;

import com.company.DTO.Accion;
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

    public static GeneradorDeBotones getGenerador() {


        if(instancia == null){
            instancia = new GeneradorDeBotones();
        }
        return instancia;
    }

    public void establecerContenedor(ContenedorPrincipal contenedorPrincipal) {
        this.contenedorPrincipal = contenedorPrincipal;
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
        controles.getChildren().add(getLabel());
        for(Accion accion :acciones){
            Button boton = new Button();
            boton.setText(accion.getDescripcion());
            boton.setOnAction(accion.getHandlerDelBoton());
            boton.setStyle("-fx-base: #394867");
            boton.setTextFill(Color.WHITE);
            controles.getChildren().add(boton);
        }
        contenedorPrincipal.setLeft(controles);
    }

    public void limpiarBotonera(){
        controles.getChildren().clear();
        contenedorPrincipal.setLeft(controles);
    }
}

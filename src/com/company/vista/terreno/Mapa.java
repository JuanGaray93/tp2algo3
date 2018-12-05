package com.company.vista.terreno;

import com.company.vista.terreno.entidades.Pasto;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class Mapa extends GridPane {

    private final Integer CASILLEROS_DE_ANCHO = 25;
    private final Integer CASILLEROS_DE_ALTO = 25;
    private Float dimensionCasillero = 25.0F;

    public Mapa(){
        this.inicializarCasilleros();
        this.setHgap(dimensionCasillero / 20);
        this.setVgap(dimensionCasillero / 20);
    }

    private void inicializarCasilleros(){
        for(Integer y = 0; y < CASILLEROS_DE_ALTO; y++){
            for(Integer x = 0; x < CASILLEROS_DE_ANCHO; x++){
                Casillero casilleroNuevo = new Pasto(x, y, dimensionCasillero, this);
                establecerCasillero(casilleroNuevo);
            }
        }
    }

    public void establecerCasillero(Casillero casilleroNuevo){
        GridPane.setRowIndex(casilleroNuevo, casilleroNuevo.getFila() );
        GridPane.setColumnIndex(casilleroNuevo, casilleroNuevo.getColumna());
        this.getChildren().addAll(casilleroNuevo);
    }

}

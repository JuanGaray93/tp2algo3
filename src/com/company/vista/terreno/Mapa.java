package com.company.vista.terreno;

import com.company.DTO.EntidadDTO;
import com.company.vista.terreno.entidades.Casillero;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

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
                // EntidadDTO entidad = Controlador.getEntidadEn(x, y);
                Casillero casilleroNuevo = new Casillero(x, y, dimensionCasillero, this,
                        null);
                establecerCasillero(casilleroNuevo);
                casilleroNuevo.mostrarEtiqueta();
            }
        }
    }

    public void establecerCasillero(Casillero casilleroNuevo){
        GridPane.setRowIndex(casilleroNuevo, casilleroNuevo.getFila() );
        GridPane.setColumnIndex(casilleroNuevo, casilleroNuevo.getColumna());
        this.getChildren().addAll(casilleroNuevo);
    }

}

package com.company.vista.terreno;

import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

public class Mapa extends GridPane {

    private final Integer CASILLEROS_DE_ANCHO = 25;
    private final Integer CASILLEROS_DE_ALTO = 25;
    private Float dimensionCasillero = 25.0F;
    private Casillero[][] casilleros;

    public Mapa(){

        this.inicializarCasilleros();
        this.setHgap(dimensionCasillero / 20);
        this.setVgap(dimensionCasillero / 20);


    }

    private void inicializarCasilleros(){
        casilleros = new Casillero[CASILLEROS_DE_ALTO][CASILLEROS_DE_ANCHO];
        for(Integer y = 0; y < CASILLEROS_DE_ALTO; y++){
            for(Integer x = 0; x < CASILLEROS_DE_ANCHO; x++){
                try{
                    Casillero casilleroNuevo = new Casillero(x, y, dimensionCasillero);
                    casilleroNuevo.setFill(Color.GREEN);
                    GridPane.setRowIndex(casilleroNuevo, y);
                    GridPane.setColumnIndex(casilleroNuevo, x);
                    this.getChildren().addAll(casilleroNuevo);
                    //La siguiente línea de código muestra el índice de cada casillero.
                    //                                             útil para debuggear:
                    // this.add(new Label("" + x + "," + y), x, y);
                } catch (Exception e){
                    //TODO
                }
            }
        }
    }

    public void establecerCasillero(Casillero casilleroNuevo){
        // TODO
    }

}

package com.company.vista.terreno;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
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

        //this.inicializarDimensiones();

        this.inicializarCasilleros();
        this.setHgap(dimensionCasillero / 20);
        this.setVgap(dimensionCasillero / 20);


    }

    private void inicializarDimensiones(){
        // Restrinjo las columnas y las filas a las dimensiones prestablecidas.
        for (int i = 0; i < CASILLEROS_DE_ANCHO; i++) {
            ColumnConstraints colConst = new ColumnConstraints();
            colConst.setPercentWidth(100.0 / CASILLEROS_DE_ANCHO);
            this.getColumnConstraints().add(colConst);
        }
        for (int i = 0; i < CASILLEROS_DE_ALTO; i++) {
            RowConstraints rowConst = new RowConstraints();
            rowConst.setPercentHeight(100.0 / CASILLEROS_DE_ALTO);
            this.getRowConstraints().add(rowConst);
        }
        //Establezco la separación entre casilleros

        this.setAlignment(Pos.CENTER);
    }

    private void inicializarCasilleros(){
        casilleros = new Casillero[CASILLEROS_DE_ALTO][CASILLEROS_DE_ANCHO];
        for(Integer y = 0; y < CASILLEROS_DE_ALTO; y++){
            for(Integer x = 0; x < CASILLEROS_DE_ANCHO; x++){
                try{
                    Casillero casilleroNuevo = new Casillero(x, y, dimensionCasillero);
                    casilleroNuevo.setFill(Color.GREEN);

                    casilleros[x][y] = casilleroNuevo;
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

}

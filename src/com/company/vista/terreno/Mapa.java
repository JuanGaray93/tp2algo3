package com.company.vista.terreno;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;

public class Mapa extends GridPane {

    private final Integer CASILLEROS_DE_ANCHO = 60;
    private final Integer CASILLEROS_DE_ALTO = 60;
    private Float dimensionCasillero = 50.0F;
    private Casillero[][] casilleros;

    public Mapa(){

        //this.inicializarDimensiones();


        Double dimensionRestrictora = Math.min( this.getHeight(), this.getWidth());

        this.dimensionCasillero = dimensionRestrictora.floatValue() / (CASILLEROS_DE_ANCHO * 1.1F);
        this.setHgap(dimensionCasillero / 20);
        this.setVgap(dimensionCasillero / 20);
        this.inicializarCasilleros();

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
                    this.add(new Label("A"), x, y);
                } catch (Exception e){
                    //TODO
                }
            }
        }
    }

}

package com.company.vista.terreno;


import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

public class Casillero extends Rectangle {

    private Integer columna;
    private Integer fila;
    private String nombre = "";
    private Mapa mapa;

    public Casillero(Integer x, Integer y, Float dimension, Mapa mapa){
        this.columna = x;
        this.fila = y;
        this.setWidth(dimension);
        this.setHeight(dimension);
    }

    public Integer getColumna(){
        return this.columna;
    }

    public Integer getFila(){
        return this.fila;
    }

    private void establecerEtiqueta(String nuevaEtiqueta){
        mapa.add(new Label(nuevaEtiqueta), this.getColumna(), this.getFila());
    }
}

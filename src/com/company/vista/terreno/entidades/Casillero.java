package com.company.vista.terreno.entidades;

import com.company.DTO.EntidadDTO;
import com.company.vista.terreno.Mapa;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Casillero extends Rectangle {

    private Integer columna;
    private Integer fila;
    private String nombre = "";
    private Mapa mapa;

    public Casillero(Integer x, Integer y, Float dimension, Mapa mapa, EntidadDTO entidad){
        this.mapa = mapa;
        this.columna = x;
        this.fila = y;
        this.setWidth(dimension);
        this.setHeight(dimension);

        if(entidad == null){
            setFill(Color.GREEN);
        } else {
            if(entidad.getJugador() == 1){
                setFill(Color.BLUE);
            } else {
                setFill(Color.RED);
            }
            nombre = entidad.getNombre();
        }
    }

    public Integer getColumna(){
        return this.columna;
    }

    public Integer getFila(){
        return this.fila;
    }

    public void mostrarEtiqueta(){
        mapa.add(new Label(nombre), this.getColumna(), this.getFila());
    }
}

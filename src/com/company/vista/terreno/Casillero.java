package com.company.vista.terreno;


import javafx.scene.shape.Rectangle;

public class Casillero extends Rectangle {

    private Integer x;
    private Integer y;
    private Float ancho;
    private Float alto;

    public Casillero(Integer x, Integer y, Float dimension){
        this.x = x;
        this.y = y;
        this.setWidth(dimension);
        this.setHeight(dimension);
    }
}

package com.company.vista.terreno;

public class Casillero {

    private Integer x;
    private Integer y;
    private Integer ancho;
    private Integer alto;

    public Casillero(Integer x, Integer y, Integer dimension){
        this.x = x;
        this.y = y;
        this.ancho = dimension;
        this.alto = dimension;
    }
}

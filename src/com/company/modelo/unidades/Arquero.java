package com.company.modelo.unidades;

public class Arquero extends Unidad {

    public Arquero(int posicionHorizontal, int posicionVertical){
        super(posicionHorizontal, posicionVertical);
        this.vida = 75;
        this.costo = 75;
    }
}

package com.company.vista.terreno.entidades;

import com.company.vista.terreno.Casillero;
import com.company.vista.terreno.Mapa;
import javafx.scene.paint.Color;

public class Pasto extends Casillero {

    public Pasto(Integer x, Integer y, Float dimension, Mapa mapa) {
        super(x, y, dimension, mapa);
        setFill(Color.GREEN);
    }

}

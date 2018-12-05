package com.company.vista.terreno.entidades;

import com.company.vista.terreno.Casillero;
import com.company.vista.terreno.Mapa;

public class EntidadViva extends Casillero {
    public EntidadViva(Integer x, Integer y, Float dimension, Mapa mapa) {
        super(x, y, dimension, mapa);
    }
}

package com.company.modelo.unidades;

import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.Unidad;

public class Espadachin extends Unidad {

    public Espadachin(){
        this.vida = 100;
        this.costo = 25;
    }

    @Override
    public void atacarEdificio(Edificio unEdificio) {
        unEdificio.recibirDanio(15);
    }

    @Override
    public void atacarUnidad(Unidad unaUnidad) {
        unaUnidad.recibirDanio(25);
    }
}

package com.company.modelo.unidades;

import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.Unidad;

public class Arquero extends Unidad {

    public Arquero(){
        this.vida = 75;
        this.costo = 75;
    }

    @Override
    public void atacarEdificio(Edificio unEdificio) {

        unEdificio.recibirDanio(10);
    }

    @Override
    public void atacarUnidad(Unidad unaUnidad) {

        unaUnidad.recibirDanio(15);
    }
}

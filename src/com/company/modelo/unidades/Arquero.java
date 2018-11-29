package com.company.modelo.unidades;

import com.company.modelo.Jugador;
import com.company.modelo.unidades.estados.EstadoUnidad;

public class Arquero extends UnidadAtacante {

    private final Integer VIDA_MAXIMA = 75;
    private final Integer COSTO = 75;

    EstadoUnidad estado;

    public Arquero(Jugador jugador) {

        super(jugador);
         estado =  establecerEstadoInicial(VIDA_MAXIMA, VIDA_MAXIMA);
        this.rangoAtaque = 3;
        this.danioAEdifcio = 10;
        this.danioAUnidad = 15;
    }

    public Integer getVida(){
        return estado.getVidaActual();
    }

}

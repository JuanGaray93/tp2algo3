package com.company.modelo.unidades;

import com.company.modelo.Jugador;

public class Espadachin extends UnidadAtacante {

    private static Integer VIDA_MAXIMA = 100;

    public Espadachin(Jugador jugador) {
        super(jugador);
        establecerEstadoInicial(VIDA_MAXIMA, VIDA_MAXIMA);
        COSTO = 50;
        this.rangoAtaque = 1;
        this.danioAEdifcio = 15;
        this.danioAUnidad = 25;
    }

}

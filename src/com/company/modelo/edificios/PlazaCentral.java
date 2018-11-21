package com.company.modelo.edificios;

import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.estados.EstadoPorConstruir;

public class PlazaCentral extends Edificio {

    public PlazaCentral(Jugador jugador) {
        super(jugador);

        BLOQUES_DE_ALTO = 2;
        BLOQUES_DE_ANCHO = 2;
        MONTO_DE_REPARACION = 25;
        COSTO = 100;
        VIDA_MAXIMA = 450;
        vidaActual = 450;

        this.estado = new EstadoPorConstruir(VIDA_MAXIMA,MONTO_DE_REPARACION);
    }

    //verifica si otroPosicionable pertenece a mi alianza
    @Override
    public Boolean verificarAlianza(Posicionable otroPosicionable) {
        return null;
    }

    //verifica si otroJugador pertenece a mi alianza
    @Override
    public Boolean verificarAlianza(Jugador otroJugador) {
        return null;
    }

    @Override
    public void ubicar(Integer posicionHorizontal, Integer posicionVertical) {

    }
}
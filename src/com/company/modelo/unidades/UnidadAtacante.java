package com.company.modelo.unidades;

import com.company.excepciones.PosicionableEsAliadoException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.Edificio;

public abstract class UnidadAtacante extends Unidad {
    public UnidadAtacante(Jugador jugador) {
        super(jugador);
    }

    public abstract void atacar(Unidad enemigo);
    public abstract void atacar(Edificio enemigo) throws PosicionableEsAliadoException;
}

package com.company.modelo.edificios;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.UnidadErroneaException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.estados.EstadoPorConstruir;
import com.company.modelo.unidades.Unidad;

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

    @Override
    public void actualizar() {

    }

    @Override
    public void crear(Unidad unidad) throws CasilleroNoExistenteException, CasilleroLlenoException {
        if(!unidad.seLlama("ALDEANO")){
            throw new UnidadErroneaException("Esta unidad no se crea en Plaza Central");
        }
        posiciones.get(1).posicionar(unidad);
    }
}
package com.company.modelo.edificios;

import com.company.excepciones.CasilleroLlenoException;
import com.company.excepciones.CasilleroNoExistenteException;
import com.company.excepciones.UnidadErroneaException;
import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.unidades.Unidad;

public class Castillo extends Edificio {


    public Castillo(Jugador jugador) {
        super(jugador);
        VIDA_MAXIMA = 1000;
        vidaActual = 1000;
    }

    @Override
    public void crear(Unidad unidad) throws CasilleroNoExistenteException, CasilleroLlenoException {
        if(!unidad.seLlama("ARMA_ASEDIO")){
            throw new UnidadErroneaException("esta unidad no puede ser creada aqui");
        }
        posiciones.get(1).posicionar(unidad);
    }

    public void actualizar() {

    }

    public void atacar(Unidad enemigo) {
        // TODO
    }

    public void atacar(Edificio enemigo) {
        // TODO
    }


}

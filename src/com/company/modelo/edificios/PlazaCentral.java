package com.company.modelo.edificios;

import com.company.excepciones.*;
import com.company.modelo.Jugador;
import com.company.modelo.Posicionable;
import com.company.modelo.edificios.estados.EstadoEdificioInactivo;
import com.company.modelo.edificios.estados.EstadoPorConstruir;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.Unidad;

public class PlazaCentral extends Edificio {

    public PlazaCentral(Jugador jugador) {
        super(jugador);
        COSTO = 100;
        MONTO_DE_REPARACION = 25;
        BLOQUES_DE_ANCHO = 2;
        BLOQUES_DE_ALTO = 2;
        VIDA_MAXIMA = 450;
    }

    @Override
    public void crearUnidad(Unidad unidad) throws CasilleroNoExistenteException, CasilleroLlenoException, MapaLlenoException, UnidadErroneaException, MovimientoInvalidoException, EdificioNoDisponibleException {

        if( !(estado instanceof EstadoEdificioInactivo) ) throw new EdificioNoDisponibleException("El edificio no esta disponible");

        if( !( unidad instanceof Aldeano ) ) {
            throw new UnidadErroneaException("Imposible crear ese tipo de unidad");
        }

        posiciones.get(0).colocarEnCasilleroLibreMasCercano(unidad);
        jugador.agregarAPoblacion(unidad);
    }

    @Override
    public void actualizar() {

    }

}
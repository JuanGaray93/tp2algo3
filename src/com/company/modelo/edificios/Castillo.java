package com.company.modelo.edificios;

import com.company.excepciones.*;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.estados.EstadoEdificioInactivo;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.MaquinaAsedio;
import com.company.modelo.unidades.Unidad;

public class Castillo extends Edificio {

    public Castillo(Jugador jugador) {
        super(jugador);
        COSTO = 0;
        MONTO_DE_REPARACION = 15;
        BLOQUES_DE_ANCHO = 8;
        BLOQUES_DE_ALTO = 8;
        VIDA_MAXIMA = 1000;
    }

    @Override
    public void construir(Aldeano quienLoConstruye, Integer posicionHorizontal, Integer posicionVertical) throws EdificioEnConstruccionException, ErrorDeConstruccionException {
        throw new ErrorDeConstruccionException("Este edificio no se puede construir");
    }

    @Override
    public void crearUnidad(Unidad unidad) throws CasilleroNoExistenteException, CasilleroLlenoException, MapaLlenoException, UnidadErroneaException, MovimientoInvalidoException, EdificioNoDisponibleException {

        if( !(estado instanceof EstadoEdificioInactivo) ) throw new EdificioNoDisponibleException("El edificio no esta disponible");

        if( !( unidad instanceof MaquinaAsedio ) ) {
            throw new UnidadErroneaException("Imposible crear ese tipo de unidad");
        }

        posiciones.get(0).colocarEnCasilleroLibreMasCercano(unidad);
        jugador.agregarAPoblacion(unidad);
    }

    public void surgir(Integer posicionHorizontal, Integer posicionVertical) throws CasilleroNoExistenteException, CasilleroLlenoException {
        this.ubicar(posicionHorizontal, posicionVertical);
        jugador.agregarAEdificios(this);
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

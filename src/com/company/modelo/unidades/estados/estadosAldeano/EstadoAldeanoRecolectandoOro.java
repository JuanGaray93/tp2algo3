package com.company.modelo.unidades.estados.estadosAldeano;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.EdificioDestruidoExcepcion;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.EstadoUnidad;

public class EstadoAldeanoRecolectandoOro extends EstadoAldeano {

    private Jugador jugadorActual;

    public EstadoAldeanoRecolectandoOro(Jugador jugador, Integer vidaActual){
        super(vidaActual);
        edificioATrabajar = null;
        jugadorActual = jugador;
    }

    public EstadoUnidad otorgarGanancia(Jugador jugador) {
        jugador.sumarOro(PRODUCCION_ORO);
        return this;
    }

    public EstadoUnidad construir(Edificio edificio)
            throws Exception, EdificioEnConstruccionException {
        return new EstadoAldeanoConstruyendo(VIDA_ACTUAL).construir(edificio);
    }

    public EstadoUnidad reparar(Edificio edificio)
            throws Exception, EdificioEnConstruccionException, EdificioDestruidoExcepcion {

        return new EstadoAldeanoReparando(VIDA_ACTUAL).reparar(edificio);
    }

    public EstadoUnidad actualizar() {
        jugadorActual.sumarOro(PRODUCCION_ORO);
        return this;
    }
}

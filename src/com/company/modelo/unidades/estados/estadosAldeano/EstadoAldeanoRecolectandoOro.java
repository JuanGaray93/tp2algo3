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

    public EstadoAldeano otorgarGanancia(Jugador jugador) {
        jugador.sumarOro(PRODUCCION_ORO);
        return this;
    }

    public EstadoAldeano construir(Edificio edificio)
            throws Exception, EdificioEnConstruccionException {
        return new EstadoAldeanoConstruyendo(vidaActual).construir(edificio);
    }

    public EstadoAldeano reparar(Edificio edificio)
            throws Exception, EdificioEnConstruccionException, EdificioDestruidoExcepcion {

        return new EstadoAldeanoReparando().reparar(edificio);
    }

    public EstadoAldeano actualizar() {
        jugadorActual.sumarOro(PRODUCCION_ORO);
        return this;
    }
}

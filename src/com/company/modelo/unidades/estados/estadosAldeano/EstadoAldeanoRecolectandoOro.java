package com.company.modelo.unidades.estados.estadosAldeano;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.EstadoUnidad;

public class EstadoAldeanoRecolectandoOro extends EstadoAldeano {

    Jugador jugadorActual ;

    public EstadoAldeanoRecolectandoOro(Jugador jugador) {

        edificioATrabajar = null;
        jugadorActual = jugador;
    }

    public EstadoAldeano actualizar() {
        jugadorActual.sumarOro(PRODUCCION_ORO);
        return this;
    }

    public EstadoAldeano construir(Edificio edificio)
            throws Exception, EdificioEnConstruccionException {
        return new EstadoAldeanoConstruyendo().construir(edificio);
    }

    public EstadoAldeano reparar(Edificio edificio)
            throws Exception, EdificioEnConstruccionException {

        return new EstadoAldeanoReparando().reparar(edificio);
    }

}

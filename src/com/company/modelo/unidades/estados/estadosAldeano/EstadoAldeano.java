package com.company.modelo.unidades.estados.estadosAldeano;

import com.company.excepciones.DistanciaInvalidaException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.EdificioDestruidoExcepcion;
import com.company.excepciones.EdificioNoConstruidoException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.EstadoUnidad;

public abstract class EstadoAldeano extends EstadoUnidad {

    protected final static Integer PRODUCCION_ORO = 20;
    protected Edificio edificioATrabajar;

    public EstadoAldeano(Integer vidaMaxima) {
        super(vidaMaxima);
        this.edificioATrabajar = null;

    }

    public abstract EstadoAldeano otorgarGanancia(Jugador jugador);

    public abstract EstadoAldeano construir(Edificio edificio, Integer posicionH, Integer posicionV)
            throws DistanciaInvalidaException, EdificioNoConstruidoException, EdificioDestruidoExcepcion, EdificioEnConstruccionException;

    public abstract EstadoAldeano reparar(Edificio edificio) throws EdificioEnConstruccionException, EdificioNoConstruidoException, EdificioDestruidoExcepcion;

}

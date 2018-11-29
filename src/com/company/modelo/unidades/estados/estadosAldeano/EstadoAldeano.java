package com.company.modelo.unidades.estados.estadosAldeano;

import com.company.excepciones.DistanciaInvalidaException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioTerminadoException;
import com.company.excepciones.EdificioDestruidoExcepcion;
import com.company.excepciones.EdificioNoConstruidoException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.EstadoUnidad;

public abstract class EstadoAldeano extends EstadoUnidad {

    protected final static Integer PRODUCCION_ORO = 20;
    protected Edificio edificioATrabajar;

    public EstadoAldeano(Integer vidaActual) {
        super(vidaActual);
        this.edificioATrabajar = null;

    }

    public void abandonarTareaActual() throws Exception, EdificioEnConstruccionException {
        if (edificioATrabajar == null)
            throw new EdificioTerminadoException("No tengo una tarea actual.");

        //edificioATrabajar.suspender();
    }

    @Override
    public EstadoUnidad recibirDanio(Integer montoDeDanio) throws Exception, EdificioEnConstruccionException {

        if (montoDeDanio >= VIDA_ACTUAL) {
            VIDA_ACTUAL = 0;
            //edificioATrabajar.suspender();

            edificioATrabajar = null;

        }

        VIDA_ACTUAL -= montoDeDanio;
        return this;
    }

    public abstract EstadoUnidad construir(Edificio edificio) throws Exception, EdificioEnConstruccionException;

    public abstract EstadoUnidad reparar(Edificio edificio) throws Exception, EdificioEnConstruccionException, EdificioDestruidoExcepcion;

    public abstract EstadoUnidad actualizar() throws Exception;


}

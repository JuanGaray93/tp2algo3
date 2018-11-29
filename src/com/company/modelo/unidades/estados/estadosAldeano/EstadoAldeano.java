package com.company.modelo.unidades.estados.estadosAldeano;

import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioTerminadoException;
import com.company.excepciones.UnidadMuertaException;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.estados.EstadoUnidad;

public abstract class EstadoAldeano extends EstadoUnidad {

    protected final Integer PRODUCCION_ORO = 20;
    protected static Integer VIDA_MAXIMA = 50;

    protected Edificio edificioATrabajar;

    public EstadoAldeano() {
        super(VIDA_MAXIMA,VIDA_MAXIMA);

    }

    public void abandonarTareaActual() throws Exception, EdificioEnConstruccionException {
        if (edificioATrabajar == null)
            throw new EdificioTerminadoException("No tengo una tarea actual.");

        edificioATrabajar.suspender();
    }

    public EstadoAldeano recibirDanio(Integer montoDeDanio) throws Exception, EdificioEnConstruccionException {

        if (montoDeDanio >= vidaActual) {
            vidaActual = 0;
            edificioATrabajar.suspender();

            edificioATrabajar = null;

        }

        this.vidaActual -= montoDeDanio;
        return this;
    }

    public abstract EstadoAldeano construir(Edificio edificio) throws Exception, EdificioEnConstruccionException;

    public abstract EstadoAldeano reparar(Edificio edificio) throws Exception, EdificioEnConstruccionException;

    public abstract EstadoAldeano actualizar() throws Exception;

}

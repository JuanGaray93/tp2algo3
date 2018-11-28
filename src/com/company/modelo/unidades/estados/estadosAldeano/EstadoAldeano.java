package com.company.modelo.unidades.estados.estadosAldeano;

import com.company.excepciones.DistanciaInvalidaException;
import com.company.excepciones.Edificio.EdificioEnConstruccionException;
import com.company.excepciones.Edificio.EdificioTerminadoException;
import com.company.excepciones.UnidadMuertaException;
import com.company.modelo.Jugador;
import com.company.modelo.edificios.Edificio;
import com.company.modelo.unidades.Aldeano;
import com.company.modelo.unidades.estados.EstadoUnidad;

public abstract class EstadoAldeano extends EstadoUnidad {

    protected final Integer PRODUCCION_ORO = 20;

    protected Edificio edificioATrabajar;

    public EstadoAldeano() {

        VIDA_MAXIMA = 50;
        COSTO = 25;
        vidaActual = 50;
    }

    public void abandonarTareaActual() throws Exception {
        if(edificioATrabajar == null)
            throw new EdificioTerminadoException("No tengo una tarea actual.");

        edificioATrabajar.suspender();
    }

    public void recibirDanio(Integer montoDeDanio) throws Exception {

        if(montoDeDanio>=vidaActual){
            vidaActual = 0;
            edificioATrabajar.suspender();

            edificioATrabajar = null;

        }

        this.vidaActual -= montoDeDanio;
    }

    public abstract EstadoAldeano construir(Edificio edificio, Integer posicionH, Integer posicionV)
            throws Exception, DistanciaInvalidaException;

    public abstract EstadoAldeano reparar(Edificio edificio) throws Exception;

    public abstract EstadoAldeano actualizar() throws Exception;

}

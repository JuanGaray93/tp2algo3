package com.company.modelo.unidades.estados.estadosAldeano;

import com.company.modelo.Jugador;
import com.company.modelo.unidades.estados.EstadoUnidad;

public abstract class EstadoAldeano extends EstadoUnidad {

    protected final static Integer PRODUCCION_ORO = 20;

    protected static String nombreEstado;

    public EstadoAldeano() {
        VIDA_MAXIMA = 50;
        COSTO =  25;
        vidaActual = 50;
    }

    public abstract EstadoAldeano ejecutarAccion();

    protected boolean tieneEstado(String estado){
        return this.nombreEstado == estado;
    }

    public abstract void otorgarGanancia(Jugador jugador);

    //public void actualizar(Aldeano aldeano, Integer vidaEdificio);

}

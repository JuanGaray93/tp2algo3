package com.company.modelo.unidades.estados.estadosEspadachin;

import com.company.modelo.unidades.estados.EstadoUnidad;

public class EstadoEspadachin extends EstadoUnidad {
    private static final Integer DISTANCIA_MAX_ATQ = 1;

    public EstadoEspadachin(){
        VIDA_MAXIMA = 100;
        COSTO =  50;
        vidaActual = 100;
    }

    @Override
    public EstadoUnidad actualizar() throws Exception {
        return this;
    }

}

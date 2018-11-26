package com.company.modelo.unidades.estados.estadosArquero;

import com.company.modelo.unidades.estados.EstadoUnidad;

public class EstadoArquero extends EstadoUnidad {

    private static final Integer DISTANCIA_MAX_ATQ = 3;

    public EstadoArquero(){
        VIDA_MAXIMA = 75;
        COSTO =  75;
        vidaActual = 75;
    }

    @Override
    public EstadoUnidad actualizar() throws Exception {
        return this;
    }

}



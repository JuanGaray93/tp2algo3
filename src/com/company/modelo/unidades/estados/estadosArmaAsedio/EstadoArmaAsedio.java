package com.company.modelo.unidades.estados.estadosArmaAsedio;

import com.company.modelo.unidades.estados.EstadoUnidad;

public class EstadoArmaAsedio extends EstadoUnidad {
    private static final Integer DISTANCIA_MAX_ATQ = 5;

    public EstadoArmaAsedio(){
        VIDA_MAXIMA = 150;
        COSTO =  200;
        vidaActual = 150;
    }

}

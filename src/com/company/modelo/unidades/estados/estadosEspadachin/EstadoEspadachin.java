package com.company.modelo.unidades.estados.estadosEspadachin;

import com.company.modelo.unidades.estados.EstadoUnidad;

public class EstadoEspadachin extends EstadoUnidad {
    private static final Integer DISTANCIA_MAX_ATQ = 1;

    public EstadoEspadachin(Integer vida){

       vidaActual = vida;
    }

	
    @Override
    public EstadoUnidad actualizar() throws Exception {
        return this;
    }

}

package com.company.modelo.unidades.estados.estadosArquero;

import com.company.excepciones.UnidadMuertaException;
import com.company.modelo.unidades.estados.EstadoUnidad;

public class EstadoArquero extends EstadoUnidad {

    private static final Integer DISTANCIA_MAX_ATQ = 3;

    public EstadoArquero(Integer vida){
        vidaActual = vida;
    }

    public Integer getVidaActual() throws UnidadMuertaException{
        return vidaActual;
    }

	@Override
    public EstadoUnidad actualizar() throws Exception {
        return this;
    }

}



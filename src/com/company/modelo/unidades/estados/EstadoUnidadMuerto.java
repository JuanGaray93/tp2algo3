package com.company.modelo.unidades.estados;

import com.company.excepciones.UnidadMuertaException;

public class EstadoUnidadMuerto extends EstadoUnidad{

    public EstadoUnidadMuerto(Integer vida){
        super(vida);
    }

    @Override
    public EstadoUnidad recibirDanio(Integer montoDeDanio) throws UnidadMuertaException {
        throw new UnidadMuertaException("La unidad esta muerta, no se la puede atacar");
    }

    @Override
    public  Integer getVidaActual() throws UnidadMuertaException {
        throw new UnidadMuertaException("La unidad esta muerta");
    }
}

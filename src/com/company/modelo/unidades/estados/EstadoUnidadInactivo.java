package com.company.modelo.unidades.estados;

public class EstadoUnidadInactivo extends EstadoUnidad{

    public EstadoUnidadInactivo(Integer vidaMaxima){
        super(vidaMaxima);
    }

    @Override
    public EstadoUnidad actualizar() throws Exception {
        return this;
    }
}

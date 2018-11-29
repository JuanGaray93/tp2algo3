package com.company.modelo.unidades.estados;

public class EstadoUnidadInactivo extends EstadoUnidad{

    public EstadoUnidadInactivo(Integer vidaActual){
        super(vidaActual);
    }

    @Override
    public EstadoUnidad actualizar() throws Exception {
        return this;
    }
}

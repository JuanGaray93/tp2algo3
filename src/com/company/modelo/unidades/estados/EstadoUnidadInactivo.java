package com.company.modelo.unidades.estados;

public class EstadoUnidadInactivo extends EstadoUnidad {

    public EstadoUnidadInactivo(Integer vidaMaxima,Integer vidaActual) {

        super(vidaMaxima,vidaActual);
    }

    @Override
    public EstadoUnidad actualizar()  {
        return null;
    }

}

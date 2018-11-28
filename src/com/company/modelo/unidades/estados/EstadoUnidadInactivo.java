package com.company.modelo.unidades.estados;

public class EstadoUnidadInactivo extends EstadoUnidad {

    public EstadoUnidadInactivo() {

    }

    @Override
    public EstadoUnidad actualizar() {
        return this;
    }

}

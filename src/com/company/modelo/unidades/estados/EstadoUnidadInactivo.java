package com.company.modelo.unidades.estados;

public class EstadoUnidadInactivo extends EstadoUnidad{
    @Override
    public EstadoUnidad actualizar() {
        return this;
    }
}

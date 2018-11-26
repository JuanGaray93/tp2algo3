package com.company.modelo.unidades.estados;

public class EstadoUnidadMuerto extends EstadoUnidad{
    @Override
    public EstadoUnidad actualizar() {
        return this;
    }
}

package com.company.modelo.unidades.estados;

public class EstadoAldeanoInactivo extends EstadoAldeano {

    public EstadoAldeanoInactivo(){
        this.nombreEstado += "INACTIVO";
    }

    @Override
    public EstadoAldeano ejecutarAccion() {
        return new EstadoAldeanoInactivo();
    }
    @Override
    public Integer getGanancia(){
        return this.PRODUCCION_ORO;
    }

}

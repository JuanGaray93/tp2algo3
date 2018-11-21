package com.company.modelo.unidades.estados;

public class Inactivo extends EstadoAldeano {


    final private static Integer PRODUCCION_ORO = 20;

    public Inactivo(){

    }

    public EstadoAldeano ejecutarAccion(){
        return new Inactivo();
    }

    public Integer getGanancia(){
        return this.PRODUCCION_ORO;
    }

}

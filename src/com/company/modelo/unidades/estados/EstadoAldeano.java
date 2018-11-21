package com.company.modelo.unidades.estados;

public abstract class EstadoAldeano extends EstadoUnidad {

    protected final static Integer PRODUCCION_ORO = 20;

    protected static String nombreEstado;

    public EstadoAldeano() {
        super(50, 25);

    }

    public abstract EstadoAldeano ejecutarAccion();

    public abstract Integer getGanancia();

    public boolean tieneEstado(String estado){
        return this.nombreEstado == estado;
    }

    //public void actualizar(Aldeano aldeano, Integer vidaEdificio);

}
